package io.mostafa.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.mostafa.Entity.Employee;
import io.mostafa.Repository.EmployeeReo;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeReo eRepo;
	@GetMapping(value={"/showemployees","/"})
	public ModelAndView showEmployees() {
		ModelAndView mv=new ModelAndView("list-employees");
		List<Employee> employees=eRepo.findAll();
		mv.addObject("employees",employees);
		return mv;
		
		
	}
 
	@GetMapping("/submitform")
	public ModelAndView showAddForm() {
		Employee e=new Employee();
		ModelAndView mv=new ModelAndView("add-employee-form");
		mv.addObject("employee",e);
		return mv;

		
		
	}
	@PostMapping("/saveemployee")
	public void saveEmployee(Employee emp,HttpServletResponse response) throws IOException {
	eRepo.save(emp);
	response.sendRedirect("/");
		
	}
	
	@GetMapping("/updateemployee")
	public ModelAndView updateEmployee(@RequestParam("employeeid") long id) {
		Employee e=eRepo.findById(id).orElse(new Employee());
		ModelAndView mv=new ModelAndView("add-employee-form");
		mv.addObject("employee",e);
		return mv;
		
		
	}
	
	@GetMapping("/deleteemployee")
	public void deleteEmployee(@RequestParam("employeeid") long id ,HttpServletResponse response) throws IOException {
	
		eRepo.deleteById(id);
	response.sendRedirect("/");
		
	}

}
