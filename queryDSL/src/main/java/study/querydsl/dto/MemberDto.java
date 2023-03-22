package study.querydsl.dto;

import com.querydsl.core.annotations.QueryProjection;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {

	private String username;
	private int age;

	@QueryProjection
	public MemberDto(String username, int age) {
		System.out.println("생성자 호출됨");
		this.username = username;
		this.age = age;
	}
}
