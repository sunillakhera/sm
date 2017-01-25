package payments;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;



@RepositoryRestResource(collectionResourceRel = "payment", path = "payment")
public interface PaymentRepository extends MongoRepository<Payment, String> {

	List<Payment> findByChannel(@Param("channel") String channel);

}