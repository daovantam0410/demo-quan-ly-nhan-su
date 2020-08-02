package com.daovantam.demoquanlynhansu.api;

import com.daovantam.demoquanlynhansu.dto.DepartmentDTO;
import com.daovantam.demoquanlynhansu.service.IDepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentAPI {


    private IDepartmentService departmentService;

    public DepartmentAPI(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/addDepartment")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        return departmentService.save(departmentDTO);
    }

    @PutMapping("/updateDepartment/{id}")
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO department, @PathVariable("id") Integer id) {
        department.setId(id);
        return departmentService.update(department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable Integer id) {
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/departments")
    public List<DepartmentDTO> getDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/findDepartmentById/{id}")
    public DepartmentDTO findDepartmentById(@PathVariable Integer id) {
        return departmentService.getDepartmentById(id);
    }
}
