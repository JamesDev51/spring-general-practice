package hello.jdbc.connection;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DBConnectionUtilTest {

	@Test
	void getConnection() {
		Connection connection = DBConnectionUtil.getConnection();
		assertThat(connection).isNotNull();
	}
}