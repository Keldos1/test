package org.example.service;


import org.example.repository.CompanyRepository;
import org.example.dto.CompanyCreateDto;
import org.example.dto.CompanyDto;
import org.example.dto.CompanyUpdateDto;
import org.example.entity.Company;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Transactional(readOnly = true)
    public List<CompanyDto> findAll(String name) {
        List<Company> companies;
        if(name == null){
            companies = companyRepository.findAll();
        } else {
            companies = companyRepository.findByName(name);
        }
        return companies.stream()
                .map(company -> new CompanyDto(
                        company.getId(),
                        company.getName()
                )).toList();
    }

    @Transactional(readOnly = true)
    public CompanyDto findById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        return new CompanyDto(
                company.getId(),
                company.getName()
        );
    }

    @Transactional
    public CompanyDto create(CompanyCreateDto dto) {
        Company company = new Company();
        company.setName(dto.name());
        company.setCountry(dto.country());
        Company saveCompany = companyRepository.save(company);
        return new CompanyDto(saveCompany.getId(), saveCompany.getName());
    }

    @Transactional
    public CompanyDto update(Long id, CompanyUpdateDto dto) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        company.setName(dto.name());
        company.setCountry(dto.country());
        Company saveCompany = companyRepository.save(company);
        return new CompanyDto(
                saveCompany.getId(),
                saveCompany.getName()
        );
    }

    @Transactional
    public void delete(Long id) {
        if(!companyRepository.existsById(id)){
            throw new RuntimeException("Company not found");
        }
        companyRepository.deleteById(id);
    }
}