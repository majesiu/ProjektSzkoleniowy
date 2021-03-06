package put.fc.sds.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import put.fc.sds.domain.Product;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, String> {

}
