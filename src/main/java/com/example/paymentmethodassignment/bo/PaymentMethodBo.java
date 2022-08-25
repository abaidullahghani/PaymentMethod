package com.example.paymentmethodassignment.bo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonAutoDetect
public class PaymentMethodBo {

	private int id;
	private String name;
	private String paymentType;
	private List<PaymentPlansBo> paymentPlans;
	
	public PaymentMethodBo() {
		super();
	}
	public PaymentMethodBo(String name, String paymentType, List<PaymentPlansBo> paymentPlans) {
		super();
		this.name = name;
		this.paymentType = paymentType;
		this.paymentPlans = paymentPlans;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public List<PaymentPlansBo> getPaymentPlans() {
		return paymentPlans;
	}
	public void setPaymentPlans(List<PaymentPlansBo> paymentPlans) {
		this.paymentPlans = paymentPlans;
	}
	
	
}
