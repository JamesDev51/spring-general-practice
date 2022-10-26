package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //컴포넌트 스캔 대상
@RequiredArgsConstructor
public class MemberRepository {

//	@PersistenceContext //엔티티 매니저를 주입해줌 따로 팩토리로 주입할 필요 없음
	private final EntityManager em;


	public void save(Member member) {
		em.persist(member);
	}

	public Member findOne(Long id){
		return em.find(Member.class,id);
	}

	public List<Member> findAll() {
		return em.createQuery("select m from Member m", Member.class)
				.getResultList();
	}

	public List<Member> findByName(String name) {
		return em.createQuery("select m from Member m where m.name= :name", Member.class)
				.setParameter("name",name)
				.getResultList();
	}
}