package com.daovantam.demoquanlynhansu.service.impl;

import com.daovantam.demoquanlynhansu.converter.DepartmentConverter;
import com.daovantam.demoquanlynhansu.dto.DepartmentDTO;
import com.daovantam.demoquanlynhansu.entity.DepartmentEntity;
import com.daovantam.demoquanlynhansu.repository.DepartmentRepository;
import com.daovantam.demoquanlynhansu.service.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    private DepartmentRepository departmentRepository;

    private DepartmentConverter departmentConverter;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, DepartmentConverter departmentConverter){
        this.departmentRepository=departmentRepository;
        this.departmentConverter=departmentConverter;
    }

    @Override
    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity = departmentConverter.toEntity(departmentDTO);
        departmentEntity = departmentRepository.save(departmentEntity);
        return departmentConverter.toDTO(departmentEntity);
    }

    @Override
    public DepartmentDTO update(DepartmentDTO departmentDTO) {
        DepartmentEntity oldDepartmentEntity = departmentRepository.findById(departmentDTO.getId()).orElse(null);
        DepartmentEntity newDepartmentEntity=departmentConverter.toEntity(departmentDTO,oldDepartmentEntity);
        newDepartmentEntity=departmentRepository.save(newDepartmentEntity);
        return departmentConverter.toDTO(newDepartmentEntity);
    }

    @Override
    public List<DepartmentDTO> findAll() {
        List<DepartmentEntity> list = departmentRepository.findAll();
        List<DepartmentDTO> dtoList = list.stream()
                                                    .map(departmentConverter::toDTO)
                                                    .collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public DepartmentDTO getDepartmentById(Integer id) {
        DepartmentEntity departmentEntity = departmentRepository.getOne(id);
        return departmentConverter.toDTO(departmentEntity);

    }

    @Override
    public String deleteDepartment(Integer id) {
            departmentRepository.deleteById(id);
            return "Department removed "+id;
    }


}
