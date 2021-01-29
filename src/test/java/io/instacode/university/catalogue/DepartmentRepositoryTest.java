package io.instacode.university.catalogue;

import io.instacode.university.dao.DepartmentRepository;
import io.instacode.university.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = new Department();
        department.setDepartmentCode("MATH");
        department.setDepartmentName("Mathematics");
        testEntityManager.persist(department);
    }
    
    @Test
    void testFindByDepartmentCode(){
        Department math = departmentRepository.findByDepartmentCode("MATH").get();
        assertThat(math.getDepartmentCode()).isEqualTo("MATH");
        assertThat(math.getDepartmentName()).isEqualTo("Mathematics");
    }

}