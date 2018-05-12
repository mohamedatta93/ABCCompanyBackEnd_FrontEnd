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
@RequestMapping(path = "/Department")
public class DepartmentController {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@DeleteMapping(path = "/")
	public @ResponseBody String deleteDepartment(@RequestParam Integer id)
	{
		
		departmentRepository.deleteById(id);
		
	return "Deleted";
	}

	@PutMapping(path = "/")
	public @ResponseBody String addNewDepartment(@RequestBody Department d) {

		departmentRepository.save(d);

		return "Saved";
	}
	@PatchMapping(path="/")
	public @ResponseBody String updateDepartment(@RequestBody Department d)
	{
		
		departmentRepository.save(d);
		return "Updated";
		
	}

	@GetMapping(path = "/")
	public @ResponseBody Iterable<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	@GetMapping(path = "/{id}")
	public @ResponseBody Optional<Department> getDepartment(@PathVariable Integer id) {
		return departmentRepository.findById(id);
	}

	
}
