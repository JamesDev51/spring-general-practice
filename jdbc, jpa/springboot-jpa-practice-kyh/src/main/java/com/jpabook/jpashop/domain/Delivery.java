package com.jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {

	@Id @GeneratedValue
	@Column(name="delivery_id")
	private Long id;

	@OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
	private Order order;

	//TODO
	@Embedded
	private Address address;

	@Enumerated(EnumType.STRING) //ORDINAL 절대 사용 X 하나 추가되면 장애남
	private DeliveryStatus status;

}
