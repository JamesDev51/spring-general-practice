package study.querydsl.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Team {

	@Id @GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<Member> memberList = new ArrayList<>();
	private String name;

	public Team(String name) {
		this.name = name;
	}

	public List<Member> getMemberList() {
		return memberList;
	}
}