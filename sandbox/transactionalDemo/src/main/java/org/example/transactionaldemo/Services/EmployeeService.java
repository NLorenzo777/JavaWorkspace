package org.example.transactionaldemo.Services;

import org.example.transactionaldemo.Entity.Address;
import org.example.transactionaldemo.Entity.Employee;
import org.example.transactionaldemo.Repository.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
    @Autowired
    private AddressService addressService;
    @Autowired
    private Employees employeesRepository;

    @Transactional(rollbackFor = Exception.class)
    public Employee addEmployee(Employee employee) {
        Employee employeeToBeSaved = this.employeesRepository.save(employee);
        System.out.println("EMPLOYEE SAVED");

        // Create address for Employee
        Address address = new Address();
        address.setAddress("Test");
        address.setEmployee(employee);

        if (employee.getName().equalsIgnoreCase("error")) {
            throw new RuntimeException("Simulated Exception: Forcing Rollback");
        }

        this.addressService.addAddress(address);
        return employeeToBeSaved;

    }


}
