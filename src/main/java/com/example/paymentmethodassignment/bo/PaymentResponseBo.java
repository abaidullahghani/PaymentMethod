package com.example.paymentmethodassignment.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonAutoDetect
public class PaymentResponseBo {
	
	private PaymentMethodResponseBo paymentMethods;

	public PaymentResponseBo(PaymentMethodResponseBo paymentMethods) {
		super();
		this.paymentMethods = paymentMethods;
	}
	
	public PaymentResponseBo() {
		super();
	}

	public PaymentMethodResponseBo getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethodResponseBo paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	
}
