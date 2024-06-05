package com.intro.storecoffe.employee;

public record EmployeeDTO(
        Long id,
        String firstName,
        String lastName,
        short age,
        float salary,
        String employeeId) {

    public static EmployeeDTO mapFromEntity(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getAge(),
                employee.getSalary(),
                employee.getStore().getId().toString()
        );
    }
}
