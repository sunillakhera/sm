package payments;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@Component
public class PaymentProcessResourceProcessor implements ResourceProcessor<Resource<PaymentProcess>> {
	public Resource<PaymentProcess> process(Resource<PaymentProcess> resource) {
		PaymentProcess pp = resource.getContent();
		if (!(pp.getNextStep().equalsIgnoreCase("end"))) {
			UriComponents uricomp = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path(pp.getNextStep() + "?id=" + pp.getId()).build();
			String uri = uricomp.toUriString();
			resource.add(new Link(uri, "NextStep"));
		}
		return resource;
	}

}