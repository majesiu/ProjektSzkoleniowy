package put.fc.sds.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
	@Column(unique=true)
	@NotNull
	private String login;
	@NotNull
	private String password;
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<IndividualOrder> individualOrders;
	

	public User(String id, String login, String password) {
		this.id = id;
		this.login = login;
		this.password = password;
	}
	
	
}
