package com.example.paymentmethodassignment.bo;

import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonAutoDetect
public class PaymentMethodResponseBo {

	@NotNull
	@JsonProperty("name")
	private String name;
	@NotNull
	@JsonProperty("paymentType")
	private String paymentType;
	@NotNull
	@JsonProperty("displayName")
	private String displayName;
	@JsonProperty("paymentPlans")
	private List<PaymentPlansResponseBo> paymentPlans;
	
	public PaymentMethodResponseBo() {
		super();
	}
	public PaymentMethodResponseBo(String name, String paymentType, List<PaymentPlansResponseBo> paymentPlans) {
		super();
		this.name = name;
		this.paymentType = paymentType;
		this.paymentPlans = paymentPlans;
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
	public List<PaymentPlansResponseBo> getPaymentPlans() {
		return paymentPlans;
	}
	public void setPaymentPlans(List<PaymentPlansResponseBo> paymentPlans) {
		this.paymentPlans = paymentPlans;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(displayName, name, paymentPlans, paymentType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentMethodResponseBo other = (PaymentMethodResponseBo) obj;
		return Objects.equals(displayName, other.displayName) && Objects.equals(name, other.name)
				&& Objects.equals(paymentPlans, other.paymentPlans) && Objects.equals(paymentType, other.paymentType);
	}
	
	
}
