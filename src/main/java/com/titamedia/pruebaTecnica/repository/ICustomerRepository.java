package com.titamedia.pruebaTecnica.repository;

import com.titamedia.pruebaTecnica.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, String> {

    @Query(value = "SELECT DISTINCT " +
            "l.customer_id AS customerId, " +
            "c.dni AS dni, " +
            "CONCAT_WS(' ', c.first_name , c.second_name , c.first_surname  , c.second_surname) AS name, " +
            "l.bank_id AS bankId, " +
            "b.name AS bankName " +
            "FROM loan l  " +
            "INNER JOIN customer c ON c.id = l.customer_id  " +
            "INNER JOIN bank b ON b.id = l.bank_id  " +
            "WHERE c.dni = :dni", nativeQuery = true)
    List<Object[]> getBankToUser(@Param("dni") String dni);
}
