package com.cloudbox.emsservice.Repository;

import com.cloudbox.models_service.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmpRepository extends JpaRepository<Employee,Integer> {
}
