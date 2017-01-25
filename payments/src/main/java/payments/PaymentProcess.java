package payments;



import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class PaymentProcess {

	@Id
	private String id;
	private String paymentId;
	private String nextStep="/payment/or/tt/accept";
	private String status;
	private List<String> history=new ArrayList<String>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getHistory() {
		return history;
	}

	public void setHistory(List<String> history) {
		this.history = history;
	}

}
