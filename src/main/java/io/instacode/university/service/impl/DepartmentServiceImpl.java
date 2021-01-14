package io.instacode.university.service.impl;

import io.instacode.university.dao.DepartmentRepository;
import io.instacode.university.dto.DepartmentDTO;
import io.instacode.university.mapper.DepartmentMapper;
import io.instacode.university.model.Department;
import io.instacode.university.service.DepartmentService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Department save(Department entity) {
        return repository.save(entity);
    }

    @Override
    public List<Department> save(List<Department> entities) {
        return (List<Department>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id.toString());
    }

    @Override
    public Optional<Department> findById(Long id) {
        return repository.findById(id.toString());
    }

    @Override
    public List<Department> findAll() {
        return (List<Department>) repository.findAll();
    }

    @Override
    public Page<Department> findAll(Pageable pageable) {
        Page<Department> entityPage = repository.findAll(pageable);
        List<Department> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Department update(Department entity, Long id) {
        Optional<Department> optional = findById(id);
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}