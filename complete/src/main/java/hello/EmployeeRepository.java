package hello;

import javax.persistence.EntityManager;

import org.springframework.data.repository.CrudRepository;
import hello.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
}
