package com.intro.storecoffe.employee;

import com.intro.storecoffe.Errors.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " not found."));
    }

    public Employee post(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee put(Employee employee, Long id) {
        Employee employeeFound = getById(id);

        if (employeeRepository.findById(id).isPresent()) {
            employeeFound.setFirstName(employee.getFirstName());
            employeeFound.setLastName(employee.getLastName());
            employeeFound.setAge(employee.getAge());
            return employeeRepository.save(employeeFound);
        } else {
            throw new IllegalArgumentException("Coffee not found with id: " + id);
        }
    }

    public String delete(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "id: " + id;
        } else {
            throw new IllegalArgumentException("Coffee not found with id: " + id);
        }
    }
}
