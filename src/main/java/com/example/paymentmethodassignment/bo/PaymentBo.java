package com.example.paymentmethodassignment.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonAutoDetect
public class PaymentBo {
	
	private PaymentMethodBo paymentMethods;

	public PaymentBo(PaymentMethodBo paymentMethods) {
		super();
		this.paymentMethods = paymentMethods;
	}
	
	public PaymentBo() {
		super();
	}

	public PaymentMethodBo getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethodBo paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	
}
