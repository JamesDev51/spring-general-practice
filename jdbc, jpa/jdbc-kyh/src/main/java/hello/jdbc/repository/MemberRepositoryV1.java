package hello.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import javax.sql.DataSource;

import hello.jdbc.connection.DBConnectionUtil;
import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;

/**
 * JDBC - DataSource 사용, JdbcUtils 사용
 */
@Slf4j
public class MemberRepositoryV1 {

	private final DataSource dataSource;

	public MemberRepositoryV1(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Member save(Member member) throws SQLException {
		String sql = "insert into member(member_id, money) values (?, ?)";

		try(Connection con= getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql)) {
			pstmt.setString(1, member.getMemberId());
			pstmt.setInt(2, member.getMoney());
			pstmt.executeUpdate();
			return member;
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		}
	}

	public Member findById(String memberId) throws SQLException {
		String sql = "select * from member where member_id= ?";

		try (Connection con = getConnection();
			 PreparedStatement pstmt = createPreparedStatement(sql,con,memberId);
			 ResultSet rs = pstmt.executeQuery();) {
			pstmt.setString(1, memberId);
			if (rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMoney(rs.getInt("money"));
				return member;
			} else {
				throw new NoSuchElementException("member not found memberId=" + memberId);
			}
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		}
	}

	private PreparedStatement createPreparedStatement(String sql, Connection con, String memberId) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1,memberId);
		return pstmt;

	}

	public void update(String memberId, int money) throws SQLException {
		String sql = "update member set money=? where member_id=?";

		try(Connection con= getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);) {
			pstmt.setInt(1, money);
			pstmt.setString(2, memberId);
			int resultSize = pstmt.executeUpdate();
			log.info("resultSize={}", resultSize);
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		}
	}

	public void delete(String memberId) throws SQLException {
		String sql = "delete from member where member_id=?";

		try(Connection con= getConnection();
			PreparedStatement pstmt=con.prepareStatement(sql);) {;
			pstmt.setString(1, memberId);
			int resultSize = pstmt.executeUpdate();
			log.info("resultSize={}", resultSize);
		} catch (SQLException e) {
			log.error("db error", e);
			throw e;
		}

	}

	private  Connection getConnection() throws SQLException {
		Connection con = dataSource.getConnection();
		log.info("get connection : {}, class={}", con,con.getClass());
		return con;
	}


}
