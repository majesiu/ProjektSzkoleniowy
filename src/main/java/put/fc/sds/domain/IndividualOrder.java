package put.fc.sds.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IndividualOrder {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
	@NotNull
	private int amountPaid;
	@ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	@ManyToOne
	@JoinColumn(name = "group_order_id")
	private GroupOrder groupOrder;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
