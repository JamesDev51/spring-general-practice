package japbook.jpahsop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import japbook.jpahsop.domain.Order;

public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();

		tx.begin();

		try {

			Order order = new Order();
			em.persist(order);


			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
