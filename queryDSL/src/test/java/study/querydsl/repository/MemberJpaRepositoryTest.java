package study.querydsl.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import study.querydsl.dto.MemberSearchCondition;
import study.querydsl.dto.MemberTeamDto;
import study.querydsl.entity.Member;
import study.querydsl.entity.Team;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

	@Autowired
	EntityManager em;

	@Autowired
	MemberJPARepository memberJpaRepository;

	@Test
	public void basicTest() throws Exception{
		Member member1= new Member("member1", 10);
		memberJpaRepository.save(member1);

		Member findMember = memberJpaRepository.findById(member1.getId()).get();
		assertThat(findMember).isEqualTo(member1);

		List<Member> result = memberJpaRepository.findAll();
		assertThat(result).containsExactly(member1);

		List<Member> result2 = memberJpaRepository.findByUsername("member1");
		assertThat(result2).containsExactly(member1);

	}
	@Test
	public void basicTest_querydsl() throws Exception{
		Member member1= new Member("member1", 10);
		memberJpaRepository.save(member1);

		Member findMember = memberJpaRepository.findById(member1.getId()).get();
		assertThat(findMember).isEqualTo(member1);

		List<Member> result = memberJpaRepository.findAll_querydsl();
		assertThat(result).containsExactly(member1);

		List<Member> result2 = memberJpaRepository.findByUsername_querydsl("member1");
		assertThat(result2).containsExactly(member1);

	}
	
	@Test
	public void searchTest() throws Exception{
		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");
		em.persist(teamA);
		em.persist(teamB);

		Member member1 = new Member("member1", 10, teamA);
		Member member2 = new Member("member2", 20, teamA);

		Member member3 = new Member("member3", 30, teamB);
		Member member4 = new Member("member4", 40, teamB);
		em.persist(member1);
		em.persist(member2);
		em.persist(member3);
		em.persist(member4);

		MemberSearchCondition condition = new MemberSearchCondition();
		// condition.setAgeGoe(35);
		// condition.setAgeLoe(40);
		condition.setTeamName("teamB");

		List<MemberTeamDto> result = memberJpaRepository.searchByBuilder(condition);
		for (MemberTeamDto memberTeamDto : result) {
			System.out.println("memberTeamDto = " + memberTeamDto);
		}
		assertThat(result).extracting("username").containsExactly("member3","member4");
	}


	@Test
	public void searchWhereTest() throws Exception{
		Team teamA = new Team("teamA");
		Team teamB = new Team("teamB");
		em.persist(teamA);
		em.persist(teamB);

		Member member1 = new Member("member1", 10, teamA);
		Member member2 = new Member("member2", 20, teamA);

		Member member3 = new Member("member3", 30, teamB);
		Member member4 = new Member("member4", 40, teamB);
		em.persist(member1);
		em.persist(member2);
		em.persist(member3);
		em.persist(member4);

		MemberSearchCondition condition = new MemberSearchCondition();
		// condition.setAgeGoe(35);
		// condition.setAgeLoe(40);
		condition.setTeamName("teamB");

		List<MemberTeamDto> result = memberJpaRepository.search(condition);
		for (MemberTeamDto memberTeamDto : result) {
			System.out.println("memberTeamDto = " + memberTeamDto);
		}
		assertThat(result).extracting("username").containsExactly("member3","member4");
	}



}