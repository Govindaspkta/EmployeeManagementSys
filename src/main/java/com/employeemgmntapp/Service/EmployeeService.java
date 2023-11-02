package com.employeemgmntapp.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemgmntapp.DTO.EmployeeRequestDTO;
import com.employeemgmntapp.DTO.EmployeeResponseDTO;
import com.employeemgmntapp.Employee.Employee;
import com.employeemgmntapp.Repo.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class EmployeeService {
	@Autowired
    private final EmployeeRepository employeeRepository;
//@Autowired
//public  Employee employee;
  
	@Autowired 
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        return mapToResponseDTO(employee);
    }

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO requestDTO) {
        Employee employee = mapToEntity(requestDTO);
        employee = employeeRepository.save(employee);
        return mapToResponseDTO(employee);
    }

    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO requestDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));

        employee.setFirstName(requestDTO.getFirstName());
        employee.setLastName(requestDTO.getLastName());
        employee.setEmail(requestDTO.getEmail());
        
        

        employee = employeeRepository.save(employee);
        return mapToResponseDTO(employee);
    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Employee not found with id: " + id);
        }
    }

    private EmployeeResponseDTO mapToResponseDTO(Employee employee) {
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        BeanUtils.copyProperties(employee, responseDTO);
        return responseDTO;
    }

    private Employee mapToEntity(EmployeeRequestDTO requestDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(requestDTO, employee);
        return employee;
    }
}
