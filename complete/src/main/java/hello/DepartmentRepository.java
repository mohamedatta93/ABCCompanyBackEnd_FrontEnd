package hello;

import java.util.List;

import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

import hello.Department;
public interface DepartmentRepository extends CrudRepository<Department, Integer>{

	
//@Query(value = "SELECT department.name,sum(salary) as TotalSalaries from department,employee"
  //     + " where department.id=employee.department_id group by salary", nativeQuery = true)
   //List<Employee>l;

}
