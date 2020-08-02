package com.daovantam.demoquanlynhansu.api;

import com.daovantam.demoquanlynhansu.dto.EmployeeDTO;
import com.daovantam.demoquanlynhansu.service.IEmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeAPI {

    private IEmployeeService employeeService;

    public EmployeeAPI (IEmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping("/addEmployee")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.save(employeeDTO);
    }

    @PutMapping("/updateEmployee/{id}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employee,@PathVariable Integer id){
        employee.setId(id);
        return employeeService.update(employee);
    }

    @GetMapping("/employees")
    public List<EmployeeDTO> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employee/{id}")
    public EmployeeDTO findEmployeeById(@PathVariable Integer id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Integer id){
       return employeeService.delete(id);
    }

}
