package com.example.paymentmethodassignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentmethodassignment.bo.PaymentBo;
import com.example.paymentmethodassignment.bo.PaymentMethodBo;
import com.example.paymentmethodassignment.entity.PaymentMethods;
import com.example.paymentmethodassignment.service.PaymentMethodsService;
import com.fasterxml.jackson.core.JsonParseException;

@RestController
public class PaymentMethodController {

	@Autowired 
	private PaymentMethodsService paymentMethodsService;
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping("/api/v1.0/configuration/payment-methods")
	public ResponseEntity<PaymentBo> createPaymentMethod(@RequestBody PaymentBo paymentMethods) {
		
		//converting bo to entity
		PaymentMethods paymentMethodRequest = modelMapper.map(paymentMethods.getPaymentMethods(), PaymentMethods.class);
		PaymentMethods paymentMethod = paymentMethodsService.createPaymentMethod(paymentMethodRequest);
		//converting entity to bo for response
		PaymentBo payment = modelMapper.map(paymentMethod,PaymentBo.class);
		return new ResponseEntity<PaymentBo>(payment, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/v1.0/configuration/payment-methods")
	public List<PaymentBo> getAllPaymentMethods() {
		
		return paymentMethodsService.getAllPaymentMethods().stream().map(paymentMethods-> modelMapper.map(paymentMethods, PaymentBo.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/api/v1.0/configuration/payment-methods-by-name")
	public ResponseEntity<PaymentBo> getPaymentMethodsByName(@RequestParam(name = "name") String name) {
		PaymentMethods paymentMethods = paymentMethodsService.getPaymentMethodByName(name);
		PaymentBo payment = modelMapper.map(paymentMethods,PaymentBo.class);
		return ResponseEntity.ok().body(payment);
	}
	
	@GetMapping("/api/v1.0/configuration/payment-methods-by-id")
	public ResponseEntity<PaymentBo> getPaymentMethodsByName(@RequestParam(name = "id") Integer id) {
		PaymentMethods paymentMethods = paymentMethodsService.getPaymentMethodById(id);
		PaymentBo payment = modelMapper.map(paymentMethods,PaymentBo.class);
		return ResponseEntity.ok().body(payment);
	}
	
	@PutMapping("/api/v1.0/configuration/payment-methods/{id}")
	public ResponseEntity<PaymentBo> updatePaymentMethod(@PathVariable(name = "id") Integer id, @RequestBody PaymentBo paymentMethods) {
		PaymentMethods paymentMethodRequest = modelMapper.map(paymentMethods.getPaymentMethods(), PaymentMethods.class);
		PaymentMethods paymentMethod = paymentMethodsService.updatePaymentMethod(id,paymentMethodRequest);
		PaymentBo payment = modelMapper.map(paymentMethod,PaymentBo.class);
		return ResponseEntity.ok().body(payment);
	}
	
}
