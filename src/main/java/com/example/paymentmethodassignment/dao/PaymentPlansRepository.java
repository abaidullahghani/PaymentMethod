package com.example.paymentmethodassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.paymentmethodassignment.entity.PaymentPlans;

public interface PaymentPlansRepository extends JpaRepository<PaymentPlans, Integer> {

}
