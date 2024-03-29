package com.jpabook.jpashop.repository;

import com.jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

	private final EntityManager em;

	public void save(Item item){

		if(item.getId()==null){ //id값이 없다 -> 새로 생성한 객체
			em.persist(item); //신규등록
		}else{ //db에 한번 등록됐던 것을 가져온 것
			em.merge(item);
		}
	}

	public Item findOne(Long id){
		return em.find(Item.class, id);
	}

	public List<Item> findAll() {
		return em.createQuery("select i from Item i",Item.class)
				.getResultList();
	}
}
