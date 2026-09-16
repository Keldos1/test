package org.example.controller;
import io.swagger.v3.oas.annotations.Operation;

import org.example.dto.CompanyCreateDto;
import org.example.dto.CompanyDto;
import org.example.dto.CompanyUpdateDto;
import org.example.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Operation(summary = "Получить все компании")
    @GetMapping
    public List<CompanyDto> findAll(
            @RequestParam(required = false) String name){
        return companyService.findAll(name);
    }
    @Operation(summary = "Получить компании по ID")
    @GetMapping("/{id}")
    public CompanyDto findById(@PathVariable Long id){
        return companyService.findById(id);
    }
    @Operation(summary = "Create company")
    @PostMapping
    public CompanyDto create(@RequestBody CompanyCreateDto dto){
        return companyService.create(dto);
    }

    @Operation(summary = "Update company by ID")
    @PutMapping("/{id}")
    public CompanyDto update(
            @PathVariable Long id,
            @RequestBody CompanyUpdateDto dto){
        return companyService.update(id, dto);
    }

    @Operation(summary = "Delete company by ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        companyService.delete(id);
    }
}
