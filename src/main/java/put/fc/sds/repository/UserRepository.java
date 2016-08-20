package put.fc.sds.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import put.fc.sds.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User getById(int id);

	User getByLogin(String login);
	User getByLoginAndPassword(String login,String password);
}
