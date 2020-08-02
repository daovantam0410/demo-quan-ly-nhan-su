package com.daovantam.demoquanlynhansu.service;

import com.daovantam.demoquanlynhansu.dto.EmployeeDTO;

import java.util.List;

public interface IEmployeeService {

    EmployeeDTO save(EmployeeDTO employeeDTO);

    EmployeeDTO update(EmployeeDTO employeeDTO);

    String delete(Integer id);

    List<EmployeeDTO> findAll();

    EmployeeDTO getEmployeeById(Integer id);


}
