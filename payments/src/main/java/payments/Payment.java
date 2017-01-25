package payments;

import org.springframework.data.annotation.Id;

public class Payment {

	@Id private String id;
	private String paymentXml;
	private String paymentStatus;
	private String channel;
	public String getId() {
		return id;
	}
	

	public String getPaymentXml() {
		return paymentXml;
	}

	public void setPaymentXml(String paymentXml) {
		this.paymentXml = paymentXml;
	}


	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
	}

}
