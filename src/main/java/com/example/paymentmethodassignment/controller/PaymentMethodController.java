package com.example.paymentmethodassignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentmethodassignment.bo.PaymentMethodBo;
import com.example.paymentmethodassignment.entity.PaymentMethods;
import com.example.paymentmethodassignment.service.PaymentMethodsService;

@RestController
public class PaymentMethodController {

	@Autowired 
	private PaymentMethodsService paymentMethodsService;
	
	@PostMapping("/api/v1.0/configuration/payment-methods")
	public PaymentMethods createPaymentMethod(@RequestBody PaymentMethodBo paymentMethods) {
		return paymentMethodsService.createPaymentMethod(paymentMethods.getPaymentMethods());
	}
	
	@GetMapping("/api/v1.0/configuration/payment-methods")
	public List<PaymentMethods> getAllPaymentMethods() {
		return paymentMethodsService.getAllPaymentMethods();
	}
	
	@GetMapping("/api/v1.0/configuration/payment-methods-by-name")
	public PaymentMethods getPaymentMethodsByName(@RequestParam(name = "name") String name) {
		return paymentMethodsService.getPaymentMethodByName(name);
	}
	
	@GetMapping("/api/v1.0/configuration/payment-methods-by-id")
	public PaymentMethods getPaymentMethodsByName(@RequestParam(name = "id") Integer id) {
		return paymentMethodsService.getPaymentMethodById(id);
	}
	
	@PutMapping("/api/v1.0/configuration/payment-methods/{id}")
	public PaymentMethods updatePaymentMethod(@PathVariable(name = "id") Integer id, @RequestBody PaymentMethodBo paymentMethods) {
		return paymentMethodsService.updatePaymentMethod(id, paymentMethods.getPaymentMethods());
	}
	
}
