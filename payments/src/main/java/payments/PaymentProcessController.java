package payments;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentProcessController {
	@Autowired
	private PaymentProcessRepository ppRep;

	@RequestMapping(value="/payment/or/tt/accept", method= RequestMethod.PUT)
	public String accept(@RequestParam(value = "id") String id) {
		System.out.println("finding by id" + ppRep.findById(id));
		PaymentProcess pp = ppRep.findById(id);
		pp.getHistory().add("Step completed" + pp.getNextStep() + " on " + System.currentTimeMillis());
		pp.setNextStep("/payment/or/tt/validate");
		ppRep.save(pp);
		return "process accepted for " + id;
	}

	@RequestMapping(value="/payment/or/tt/validate", method= RequestMethod.PUT)
	public String validate(@RequestParam(value = "id") String id) {
		System.out.println("finding by id" + ppRep.findById(id));
		PaymentProcess pp = ppRep.findById(id);
		pp.getHistory().add("Step completed" + pp.getNextStep() + " on " + System.currentTimeMillis());
		//call state machine
		//send event - ex validation complete
		//state machine should give you next step
		//set this in payment process
		pp.setNextStep("/payment/or/tt/finalize");
		ppRep.save(pp);
		return "process validated for " + id;
	}

	@RequestMapping(value="/payment/or/tt/finalize", method= RequestMethod.PUT)
	public String finalize(@RequestParam(value = "id") String id) {
		System.out.println("finding by id" + ppRep.findById(id));
		PaymentProcess pp = ppRep.findById(id);
		pp.getHistory().add("Step completed" + pp.getNextStep() + " on " + System.currentTimeMillis());
		pp.setNextStep("end");
		ppRep.save(pp);
		return "process finalized for " + id;
	}

}