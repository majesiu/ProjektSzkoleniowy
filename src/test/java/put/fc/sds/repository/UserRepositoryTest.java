package put.fc.sds.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import put.fc.sds.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
    private UserRepository repository;
	
	@Autowired
    private TestEntityManager entityManager;
	
	@Test
	public void testGetById() {
	}

	@Test
	public void testGetByLogin() {
		this.entityManager.persist(new User("login", "password"));
        User user = this.repository.getByLogin("login");
        
        assertThat(user.getLogin()).isEqualTo("login");
        assertThat(user.getPassword()).isEqualTo("password");
	}

	@Test
	public void testGetByLoginAndPassword() {
		this.entityManager.persist(new User("login", "password"));
        User user = this.repository.getByLoginAndPassword("login","password");
        
        assertThat(user.getLogin()).isEqualTo("login");
        assertThat(user.getPassword()).isEqualTo("password");
	}

	@Test
	public void testDeleteById() {
	}

}
