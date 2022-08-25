package com.example.paymentmethodassignment.bo;


import javax.validation.constraints.NotNull;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonAutoDetect
public class PaymentPlansResponseBo {
	
	private int id;
	@NotNull
	@JsonProperty("netAmount")
	private float netAmount;
	private float taxAmount;
	private float grossAmount;
	@NotNull
	@JsonProperty("currency")
	private String currency;
	private String duration;
	
	public PaymentPlansResponseBo() {
		super();
	}
	public PaymentPlansResponseBo(float netAmount, float taxAmount, float grossAmount, String currency, String duration) {
		super();
		this.netAmount = netAmount;
		this.taxAmount = taxAmount;
		this.grossAmount = grossAmount;
		this.currency = currency;
		this.duration = duration;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}
	public float getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(float taxAmount) {
		this.taxAmount = taxAmount;
	}
	public float getGrossAmount() {
		return grossAmount;
	}
	public void setGrossAmount(float grossAmount) {
		this.grossAmount = grossAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}
