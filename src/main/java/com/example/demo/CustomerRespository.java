package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRespository extends JpaRepository<Customer, Long> {
    @Query("SELECT s FROM Customer s WHERE s.email = ?1")
    Optional<Customer> findCustomerByEmail(String email_address);

    @Query("SELECT s FROM Customer s WHERE s.fname = ?1 AND s.sex =?2")
    List<Customer> findCustomerByFnameEqualsAndSexEquals(String firstName, String sex);

    @Query(value = "SELECT * FROM Customer WHERE fname = ?1 AND email =?2", nativeQuery = true)
    List<Customer> SelectCustomerByFnameEqualsAndEmailEqualsNative(String firstName, String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM Customer s WHERE s.id = ?1")
    int deleteCustomerById(Long id);
}
