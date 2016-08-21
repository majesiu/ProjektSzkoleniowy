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
public class GroupOrder {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
	@NotNull
	private String restaurantName;
	@OneToMany(mappedBy = "groupOrder", cascade = CascadeType.ALL)
	private List<IndividualOrder> individualOrders;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public List<IndividualOrder> getIndividualOrders() {
		return individualOrders;
	}
	public void setIndividualOrders(List<IndividualOrder> individualOrders) {
		this.individualOrders = individualOrders;
	}
	
	public GroupOrder()	{
	
	}
}
