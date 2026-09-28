package org.example;

import org.example.entity.Company;
import org.example.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CompanyRepositoryTestWithH2 {
    @Autowired
    private CompanyRepository repository;
    @Test
    void findCompanyByIdTesting(){
        Company company = new Company();
        company.setName("T.bank");
        company.setCountry("Rus");
        repository.save(company);
        Optional<Company> result = repository.findByName("T.bank");
        assertTrue(result.isPresent());
    }
}
