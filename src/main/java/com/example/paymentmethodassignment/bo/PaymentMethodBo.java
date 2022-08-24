package com.example.paymentmethodassignment.bo;

import com.example.paymentmethodassignment.entity.PaymentMethods;

public class PaymentMethodBo {

	private PaymentMethods paymentMethods;

	public PaymentMethodBo() {
		super();
	}
	
	public PaymentMethodBo(PaymentMethods paymentMethods) {
		super();
		this.paymentMethods = paymentMethods;
	}

	public PaymentMethods getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethods paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	@Override
	public String toString() {
		return "PaymentMethodBo [paymentMethods=" + paymentMethods + "]";
	}
	
	
}
