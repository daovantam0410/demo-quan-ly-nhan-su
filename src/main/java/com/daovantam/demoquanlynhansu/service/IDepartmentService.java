package com.daovantam.demoquanlynhansu.service;

import com.daovantam.demoquanlynhansu.dto.DepartmentDTO;

import java.util.List;

public interface IDepartmentService {

    DepartmentDTO save(DepartmentDTO departmentDTO);

    DepartmentDTO update(DepartmentDTO departmentDTO);

    List<DepartmentDTO> findAll();

    DepartmentDTO getDepartmentById(Integer id);

    String deleteDepartment(Integer id);
}
