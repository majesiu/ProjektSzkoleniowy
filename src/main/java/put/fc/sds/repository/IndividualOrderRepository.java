package put.fc.sds.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import put.fc.sds.domain.IndividualOrder;

@RepositoryRestResource
public interface IndividualOrderRepository extends CrudRepository<IndividualOrder, String> {

}
