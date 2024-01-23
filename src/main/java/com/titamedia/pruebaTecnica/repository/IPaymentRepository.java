package com.titamedia.pruebaTecnica.repository;

import com.titamedia.pruebaTecnica.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentEntity, Integer> {
}
