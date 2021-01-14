package io.instacode.university.controller.impl;

import io.instacode.university.controller.DepartmentController;
import io.instacode.university.dto.DepartmentDTO;
import io.instacode.university.mapper.DepartmentMapper;
import io.instacode.university.model.Department;
import io.instacode.university.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/department")
public class DepartmentControllerImpl implements DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    public DepartmentControllerImpl(DepartmentService departmentService, DepartmentMapper departmentMapper) {
        this.departmentService = departmentService;
        this.departmentMapper = departmentMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentDTO save(@RequestBody DepartmentDTO departmentDTO) {
        Department department = departmentMapper.asEntity(departmentDTO);
        return departmentMapper.asDTO(departmentService.save(department));
    }

    @GetMapping("/{id}")
    public DepartmentDTO findById(@PathVariable("id") Long id) {
        Department department = departmentService.findById(id).orElse(null);
        return departmentMapper.asDTO(department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        departmentService.deleteById(id);
    }

    @GetMapping
    public List<DepartmentDTO> list() {
        return departmentMapper.asDTOList(departmentService.findAll());
    }

    @GetMapping("/page-query")
    public Page<DepartmentDTO> pageQuery(Pageable pageable) {
        Page<Department> departmentPage = departmentService.findAll(pageable);
        List<DepartmentDTO> dtoList = departmentPage
                .stream()
                .map(departmentMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, departmentPage.getTotalElements());
    }

    @PutMapping("/{id}")
    public DepartmentDTO update(@RequestBody DepartmentDTO departmentDTO, @PathVariable("id") Long id) {
        Department department = departmentMapper.asEntity(departmentDTO);
        return departmentMapper.asDTO(departmentService.update(department, id));
    }
}