package com.spring.userdept.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.userdept.dto.DepartmentDTO;
import com.spring.userdept.model.Department;
import com.spring.userdept.service.DepartmentService;

// Novas importações para o Spring Boot 3
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/api/v1")
@Tag(name = "Department", description = "API Rest User/Department")
@CrossOrigin(origins = "*")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    @Operation(summary = "Retorna uma lista de departamentos")
    public List<DepartmentDTO> listAll() {
        return departmentService.findAll();
    }

    @GetMapping("/departments/{id}")
    @Operation(summary = "Busca um departamento pelo id")
    public Department findById(@PathVariable(value = "id") Long id) {
        Department result = departmentService.findById(id);
        return result;
    }

	

	@ResponseStatus(HttpStatus.CREATED)
	@Operation(summary ="Salva um deparatamento no banco")
	@PostMapping("/departments")
	public Department insertDepartment(@RequestBody Department department) {
		return departmentService.insertDepartment(department);
	}
	
	
	@PutMapping("/departments")
	@Operation(summary ="Atualiza um produto completo")
	public Department updateDepartment(@RequestBody Department department) {
		return departmentService.updateDepartment(department);
	}
	
	@DeleteMapping("/departments/{id}")
	@Operation(summary ="Delta um departamento pelo id")
	public void deleteDepartment(@PathVariable Long id) {
		departmentService.deleteDepartment(id);
	}
	
	
}
