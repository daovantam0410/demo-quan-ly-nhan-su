package com.daovantam.demoquanlynhansu.converter;

import com.daovantam.demoquanlynhansu.dto.DepartmentDTO;
import com.daovantam.demoquanlynhansu.entity.DepartmentEntity;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {

    public DepartmentEntity toEntity(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(departmentDTO.getId());
        departmentEntity.setDepartmentName(departmentDTO.getDepartmentName());
        return departmentEntity;
    }

    public DepartmentDTO toDTO(DepartmentEntity departmentEntity) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(departmentEntity.getId());
        departmentDTO.setDepartmentName(departmentEntity.getDepartmentName());
        return departmentDTO;
    }

    public DepartmentEntity toEntity(DepartmentDTO departmentDTO, DepartmentEntity departmentEntity) {
        departmentEntity.setDepartmentName(departmentDTO.getDepartmentName());
        return departmentEntity;
    }
}
