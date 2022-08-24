package com.example.paymentmethodassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paymentmethodassignment.entity.PaymentMethods;

public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {

	PaymentMethods findByname(String name);
}
