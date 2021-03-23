package com.demo.spring;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController
@RequestMapping("/emp")
public class EmpDataResource {

	@Autowired
	private EmpRepository repo;

	// @RequestMapping(path="/find/{id}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(path = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Emp findEmpById(@PathVariable("id") int id) {
		Optional<Emp> op = repo.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new RuntimeException("Emp with id " + id + " not found");
		}
	}

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String save(@RequestBody Emp e) {
		if (!repo.existsById(e.getEmpId())) {
			repo.save(e);
			return "Emp Saved";
			
		} else {
			return "Emp already exists..";
		}
	}
	
	@PostMapping(path = "/save1", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String save1(@RequestBody Emp e) {
		if (!repo.existsById(e.getEmpId())) {
			repo.saveEmp(e.getEmpId(), e.getName(), e.getCity(), e.getSalary());
			return "Emp Saved";
			
		} else {
			return "Emp already exists..";
		}
	}
	
	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String update(@RequestBody Emp e) {
			repo.save(e);
			return "Emp updated..";
	
	}
	
}
