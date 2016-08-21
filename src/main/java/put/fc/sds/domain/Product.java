package put.fc.sds.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
	@NotNull
	private String name;
	@NotNull
	private int prize;
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<IndividualOrder> individualOrders;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrize() {
		return prize;
	}
	public void setPrize(int prize) {
		this.prize = prize;
	}
	
	public List<IndividualOrder> getIndividualOrders() {
		return individualOrders;
	}
	public void setIndividualOrders(List<IndividualOrder> individualOrders) {
		this.individualOrders = individualOrders;
	}
	
	
}
