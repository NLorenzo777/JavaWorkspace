package org.example.transactionaldemo.Repository;

import org.example.transactionaldemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Employees extends JpaRepository<Employee, Long> {
}