package org.example.transactionaldemo.api;

import org.example.transactionaldemo.Entity.Employee;
import org.example.transactionaldemo.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class Controller {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
        try {
            Employee employeeSaved = employeeService.addEmployee(employee);
            return ResponseEntity.ok(employeeSaved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Transaction Failed: " + e.getMessage());
        }
    }

}
