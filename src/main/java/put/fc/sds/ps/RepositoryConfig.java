package put.fc.sds.ps;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@Configuration
@EnableJpaRepositories(basePackages = "put.fc.sds.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"put.fc.sds.domain"})
public class RepositoryConfig {

}
