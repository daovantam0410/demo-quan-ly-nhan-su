package com.daovantam.demoquanlynhansu.converter;

import com.daovantam.demoquanlynhansu.dto.EmployeeDTO;
import com.daovantam.demoquanlynhansu.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public EmployeeEntity toEntity(EmployeeDTO employeeDTO){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFullName(employeeDTO.getFullName());
        employeeEntity.setAddress(employeeDTO.getAddress());
        employeeEntity.setAge(employeeDTO.getAge());
        employeeEntity.setGender(employeeDTO.getGender());
        return employeeEntity;
    }

    public EmployeeDTO toDTO(EmployeeEntity employeeEntity){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFullName(employeeEntity.getFullName());
        employeeDTO.setAddress(employeeEntity.getAddress());
        employeeDTO.setAge(employeeEntity.getAge());
        employeeDTO.setGender(employeeEntity.getGender());
        return employeeDTO;
    }

    public EmployeeEntity toEntity(EmployeeDTO employeeDTO, EmployeeEntity employeeEntity) {
        employeeEntity.setFullName(employeeDTO.getFullName());
        employeeEntity.setAddress(employeeDTO.getAddress());
        employeeEntity.setGender(employeeDTO.getGender());
        employeeEntity.setAge(employeeDTO.getAge());
        return employeeEntity;
    }
}
