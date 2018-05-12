package hello;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/Employee")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PutMapping(path = "/")
	public @ResponseBody String addNewEmployee(@RequestBody Employee e) {

		employeeRepository.save(e);

		return "Saved";
	}
	@DeleteMapping(path = "/")
	public @ResponseBody String deleteEmployee(@RequestParam Integer id)
	{
		
		employeeRepository.deleteById(id);
		
	return "Deleted";
	}
	@PatchMapping(path="/")
	public @ResponseBody String updateEmployee(@RequestBody Employee e)
	{
		
		employeeRepository.save(e);
return "Updated";		
	}

	@GetMapping(path = "/")
	public @ResponseBody Iterable<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Employee> getEmployee(@PathVariable Integer id) {
		return employeeRepository.findById(id);
		
	}

	
}
