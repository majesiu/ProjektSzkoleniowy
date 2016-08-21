package put.fc.sds.repository;

import org.springframework.data.repository.CrudRepository;
import put.fc.sds.domain.User;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, String> {

	User getById(String id);

	User getByLogin(String login);
	User getByLoginAndPassword(String login,String password);
	void deleteById(String id);
}
