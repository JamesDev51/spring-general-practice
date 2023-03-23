package hello.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import hello.jdbc.domain.Member;
import hello.jdbc.repository.MemberRepositoryV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class MemberServiceV2 {

	private final DataSource dataSource;
	private final MemberRepositoryV2 memberRepositoryV2 ;

	public void accountTransfer(String fromId, String toId, int money) throws SQLException {
		Connection con = dataSource.getConnection();
		try {
			con.setAutoCommit(false); //트랜잭션 시작
			bizLogic(con, fromId, toId, money);
			//커밋, 롤백
			con.commit();
		} catch (Exception e) {
			con.rollback();
			log.error("에러 발생: {}", e);
			throw new IllegalStateException(e);
		} finally{
			con.setAutoCommit(true);
			con.close();
		}
	}

	private void bizLogic(Connection con, String fromId, String toId, int money) throws SQLException,IllegalStateException{
		//비즈니스 로직
		Member fromMember = memberRepositoryV2.findById(con, fromId);
		Member toMember = memberRepositoryV2.findById(con, toId);

		memberRepositoryV2.update(con, fromId, fromMember.getMoney() - money);
		validation(toMember);
		memberRepositoryV2.update(con, toId, toMember.getMoney()+ money);
	}

	private void validation(Member toMember)  throws IllegalStateException{
		if (toMember.getMemberId().equals("ex")) {
			throw new IllegalStateException("이체중 예외 발생");
		}
	}

}
