package io.instacode.university.mapper;

import io.instacode.university.dto.DepartmentDTO;
import io.instacode.university.model.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface DepartmentMapper extends GenericMapper<Department, DepartmentDTO> {

    @Override
    @Mapping(target = "id")
    Department asEntity(DepartmentDTO dto);
}