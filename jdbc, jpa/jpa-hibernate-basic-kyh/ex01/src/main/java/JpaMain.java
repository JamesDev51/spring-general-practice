import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Member;

public class JpaMain {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			//등록
			// Member member = new Member();
			// member.setId(2L);
			// member.setName("bello");
			// em.persist(member);

			//조회
			// entity.Member findMember = em.find(entity.Member.class, 1L);
			// System.out.println("findMember.id = "+ findMember.getId());
			// System.out.println("findMember.name = "+ findMember.getName());

			//수정
			// entity.Member findMember = em.find(entity.Member.class, 1L);
			// findMember.setName("HelloJPA");

			List<Member> result = em.createQuery("select m from Member as m", Member.class)
				.setMaxResults(5)
				.getResultList();
			for (Member member : result) {
				System.out.println("member.name="+member.getName());
			}


			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();

	}
}
