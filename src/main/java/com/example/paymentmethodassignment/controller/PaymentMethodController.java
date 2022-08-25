package com.example.paymentmethodassignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentmethodassignment.bo.PaymentBo;
import com.example.paymentmethodassignment.bo.PaymentMethodBo;
import com.example.paymentmethodassignment.bo.PaymentResponseBo;
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
	public ResponseEntity<PaymentResponseBo> createPaymentMethod(@Valid @RequestBody PaymentBo paymentMethods) {
		
		//converting bo to entity
		PaymentMethods paymentMethodRequest = modelMapper.map(paymentMethods.getPaymentMethods(), PaymentMethods.class);
		PaymentMethods paymentMethod = paymentMethodsService.createPaymentMethod(paymentMethodRequest);
		//converting entity to bo for response
		PaymentResponseBo payment = modelMapper.map(paymentMethod,PaymentResponseBo.class);
		return new ResponseEntity<PaymentResponseBo>(payment, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/api/v1.0/configuration/payment-methods")
	public List<PaymentResponseBo> getAllPaymentMethods() {
		
		return paymentMethodsService.getAllPaymentMethods().stream().map(paymentMethods-> modelMapper.map(paymentMethods, PaymentResponseBo.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/api/v1.0/configuration/payment-methods-by-name")
	public ResponseEntity<PaymentResponseBo> getPaymentMethodsByName(@RequestParam(required = true, name = "name") String name) {
		PaymentMethods paymentMethods = paymentMethodsService.getPaymentMethodByName(name);
		PaymentResponseBo payment = modelMapper.map(paymentMethods,PaymentResponseBo.class);
		return ResponseEntity.ok().body(payment);
	}
	
	@GetMapping("/api/v1.0/configuration/payment-methods-by-id")
	public ResponseEntity<PaymentResponseBo> getPaymentMethodsByName(@RequestParam(required = true, name = "id") Integer id) {
		PaymentMethods paymentMethods = paymentMethodsService.getPaymentMethodById(id);
		PaymentResponseBo payment = modelMapper.map(paymentMethods,PaymentResponseBo.class);
		return ResponseEntity.ok().body(payment);
	}
	
	@PutMapping("/api/v1.0/configuration/payment-methods/{id}")
	public ResponseEntity<PaymentResponseBo> updatePaymentMethod(@PathVariable(required = true, name = "id") Integer id,@Valid @RequestBody PaymentBo paymentMethods) {
		PaymentMethods paymentMethodRequest = modelMapper.map(paymentMethods.getPaymentMethods(), PaymentMethods.class);
		PaymentMethods paymentMethod = paymentMethodsService.updatePaymentMethod(id,paymentMethodRequest);
		PaymentResponseBo payment = modelMapper.map(paymentMethod,PaymentResponseBo.class);
		return ResponseEntity.ok().body(payment);
	}
	
}
