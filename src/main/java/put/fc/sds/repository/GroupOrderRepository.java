package put.fc.sds.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import put.fc.sds.domain.GroupOrder;

@RepositoryRestResource
public interface GroupOrderRepository extends CrudRepository<GroupOrder, String> {

}
