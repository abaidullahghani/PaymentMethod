package com.example.paymentmethodassignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paymentmethodassignment.entity.PaymentPlans;

@Repository
public interface PaymentPlansRepository extends JpaRepository<PaymentPlans, Integer> {

}
