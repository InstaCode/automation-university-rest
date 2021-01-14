package io.instacode.university.catalogue;

import io.instacode.university.model.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class DepartmentTest extends BaseDatabaseUnitTest {

    @Autowired
    private TestEntityManager testEntityManager;


    @Test
    void testDepartmentCodeUniqueError() {
        Department department = new Department();
        department.setDepartmentCode("MATH");
        department.setDepartmentName("Mathematics");
        testEntityManager.persist(department);
        department.setDepartmentName("Mathematics - Duplicate");
        testEntityManager.persist(department);
    }
}