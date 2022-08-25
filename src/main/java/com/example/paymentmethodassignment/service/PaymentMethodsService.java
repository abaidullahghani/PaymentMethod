package com.example.paymentmethodassignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.paymentmethodassignment.dao.PaymentMethodsRepository;
import com.example.paymentmethodassignment.entity.PaymentMethods;

@Service
public class PaymentMethodsService {

	@Autowired 
	private PaymentMethodsRepository paymentMethodsRepository;
	
	public PaymentMethods createPaymentMethod(PaymentMethods paymentMethods) {
		return paymentMethodsRepository.save(paymentMethods);
	}
	
	public List<PaymentMethods> getAllPaymentMethods() {
		return paymentMethodsRepository.findAll();
	}
	
	public PaymentMethods getPaymentMethodByName(String name) {
		return paymentMethodsRepository.findByname(name);
	}
	
	public PaymentMethods getPaymentMethodById(Integer id) {
		return paymentMethodsRepository.findById(id).orElseThrow();
	}
	
	public PaymentMethods updatePaymentMethod(int id, PaymentMethods paymentMethod) {
		PaymentMethods existingPaymentMethod = paymentMethodsRepository.findById(id).orElseThrow();
		if(existingPaymentMethod != null) {
			existingPaymentMethod = paymentMethod;
			paymentMethodsRepository.save(existingPaymentMethod);
		}
		return existingPaymentMethod;
	}
}
