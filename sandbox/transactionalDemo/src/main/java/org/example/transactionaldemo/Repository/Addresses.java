package org.example.transactionaldemo.Repository;

import org.example.transactionaldemo.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Addresses extends JpaRepository<Address, Long> {

}