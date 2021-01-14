package io.instacode.university.controller;

import io.instacode.university.dto.DepartmentDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Department API")
public interface DepartmentController {
    @ApiOperation("Add new data")
    DepartmentDTO save(@RequestBody DepartmentDTO department);

    @ApiOperation("Find by Id")
    DepartmentDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    List<DepartmentDTO> list();

    @ApiOperation("Pagination request")
    Page<DepartmentDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    DepartmentDTO update(@RequestBody DepartmentDTO dto, @PathVariable("id") Long id);
}