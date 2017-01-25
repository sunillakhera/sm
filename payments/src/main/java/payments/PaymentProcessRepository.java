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



@RepositoryRestResource(collectionResourceRel = "paymentprocess", path = "paymentprocess")
public interface PaymentProcessRepository extends MongoRepository<PaymentProcess, String> {

	List<PaymentProcess> findByStatus(@Param("status") String status);
	PaymentProcess findById(@Param("id") String id);

}