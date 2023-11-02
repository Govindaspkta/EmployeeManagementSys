package employeemgmntapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemgmntapp.DTO.EmployeeRequestDTO;
import com.employeemgmntapp.DTO.EmployeeResponseDTO;
import com.employeemgmntapp.Service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getemployee")
    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/getemployee/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/createemployee")
    public EmployeeResponseDTO createEmployee(@RequestBody EmployeeRequestDTO requestDTO) {
        return employeeService.createEmployee(requestDTO);
    }

    @PutMapping("/update")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id, @Validated @RequestBody EmployeeRequestDTO requestDTO) {
        return employeeService.updateEmployee(id, requestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
