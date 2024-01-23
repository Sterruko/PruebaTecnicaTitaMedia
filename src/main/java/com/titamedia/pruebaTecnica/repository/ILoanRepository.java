package com.titamedia.pruebaTecnica.repository;

import com.titamedia.pruebaTecnica.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILoanRepository extends JpaRepository<LoanEntity, Integer> {

    @Query(value = "select " +
            "l.id as loanId, " +
            "l.id as customerId, " +
            "l.bank_id as bankId, " +
            "b.document_number as nitBank, " +
            "b.name as nameBank, " +
            "l.total_amount as totalAmount, " +
            "l.quota_value as quotaValue, " +
            "l.quota_amount as quotaAmount, " +
            "l.total_quota as totalQuota, " +
            "s.description_state as status " +
            "from loan l " +
            "inner join bank b on b.id = l.bank_id  " +
            "inner join customer c on c.id = l.customer_id  " +
            "inner join status s on s.id = l.status_id  " +
            "where c.dni = :dni and b.id = :bankId", nativeQuery = true)
    List<Object[]> getListLoansBank(@Param("dni") String dni, @Param("bankId") int bankId);


    @Query(value = "select " +
            "l.id as loanId, " +
            "l.id as customerId, " +
            "l.bank_id as bankId, " +
            "b.document_number as nitBank, " +
            "b.name as nameBank, " +
            "l.total_amount as totalAmount, " +
            "l.total_quota as totalQuota, " +
            "s.description_state as status " +
            "from loan l " +
            "inner join bank b on b.id = l.bank_id  " +
            "inner join customer c on c.id = l.customer_id  " +
            "inner join status s on s.id = l.status_id  " +
            "where l.id = :loanId", nativeQuery = true)
    List<Object[]> getDetailsLoan(@Param("loanId") int loanId);
}
