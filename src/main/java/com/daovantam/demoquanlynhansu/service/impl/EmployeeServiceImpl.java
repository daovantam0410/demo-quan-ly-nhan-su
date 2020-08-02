package com.daovantam.demoquanlynhansu.service.impl;

import com.daovantam.demoquanlynhansu.converter.EmployeeConverter;
import com.daovantam.demoquanlynhansu.dto.EmployeeDTO;
import com.daovantam.demoquanlynhansu.entity.DepartmentEntity;
import com.daovantam.demoquanlynhansu.entity.EmployeeEntity;
import com.daovantam.demoquanlynhansu.repository.DepartmentRepository;
import com.daovantam.demoquanlynhansu.repository.EmployeeRepository;
import com.daovantam.demoquanlynhansu.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    private EmployeeConverter employeeConverter;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               EmployeeConverter employeeConverter,
                               DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeConverter = employeeConverter;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        DepartmentEntity departmentEntity = departmentRepository.getOne(employeeDTO.getDepartmentId());
        EmployeeEntity employeeEntity = employeeConverter.toEntity(employeeDTO);
        employeeEntity.setDepartmentEntity(departmentEntity);
        employeeEntity = employeeRepository.save(employeeEntity);
        return employeeConverter.toDTO(employeeEntity);

    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO) {
        EmployeeEntity oldEmployeeEntity = employeeRepository.findById(employeeDTO.getId()).orElse(null);
        DepartmentEntity departmentEntity = departmentRepository.getOne(employeeDTO.getDepartmentId());
        EmployeeEntity newEmployeeEntity = employeeConverter.toEntity(employeeDTO, oldEmployeeEntity);
        newEmployeeEntity.setDepartmentEntity(departmentEntity);
        newEmployeeEntity = employeeRepository.save(newEmployeeEntity);
        return employeeConverter.toDTO(newEmployeeEntity);
    }

    @Override
    public String delete(Integer id) {
        employeeRepository.deleteById(id);
        return "Employee no "+ id + " removed";
    }

    @Override
    public List<EmployeeDTO> findAll() {
        List<EmployeeEntity> list = employeeRepository.findAll();
        List<EmployeeDTO> dtoList = list.stream()
                                                .map(employeeConverter::toDTO)
                                                .collect(Collectors.toList());
        return dtoList;
    }

    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        EmployeeEntity employeeEntity = employeeRepository.getOne(id);
        return employeeConverter.toDTO(employeeEntity);
    }


}
