package com.example.paymentmethodassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paymentmethodassignment.entity.PaymentMethods;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {

	PaymentMethods findByname(String name);
}
