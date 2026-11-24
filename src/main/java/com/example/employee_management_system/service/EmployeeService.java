package com.example.employee_management_system.service;

import com.example.employee_management_system.dto.EmployeeResponseDTO;
import com.example.employee_management_system.dto.EmployeeRequestDTO;
import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.exception.EmployeeNotFoundException;
import com.example.employee_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public  EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository= employeeRepository;
    }

    // convert entity to response dto
    private EmployeeResponseDTO convertToDto(Employee employee){
        return new EmployeeResponseDTO(
                employee.getId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }

    //Convert request dto to  entity
    private Employee convertToEntity(EmployeeRequestDTO dto){
        Employee employee= new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        return  employee;
    }

    // create employee
    public EmployeeResponseDTO  createEmployee(EmployeeRequestDTO dto){
        Employee employee= convertToEntity(dto);
        Employee saveEmployee= employeeRepository.save(employee);

        return convertToDto(saveEmployee);

    }

    // get all employee
    public List<EmployeeResponseDTO> getAllEmployees(){

        return  employeeRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }
    //get employee by id


    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee= employeeRepository.findById(id)
                .orElseThrow(()->
                        new EmployeeNotFoundException("Employee not found with id: " + id));
        return convertToDto(employee);
    }

    // update employee
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());

        return convertToDto(employeeRepository.save(employee));
    }

    // delete employee
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

}
