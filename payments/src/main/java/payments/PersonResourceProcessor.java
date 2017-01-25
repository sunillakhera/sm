package payments;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

@Component
public class PersonResourceProcessor implements ResourceProcessor<Resource<Person>>{
	public Resource<Person> process(Resource<Person> resource) {
		String idStr=resource.getContent().getId();
		UriComponents uricomp = ServletUriComponentsBuilder.fromCurrentContextPath().path("people/se").build();
		String uri=uricomp.toUriString();
		resource.add(new Link(uri,"somethingNew"));
		return resource;
	}
	
	
}