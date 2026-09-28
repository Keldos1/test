package org.example;

import org.example.entity.Company;
import org.example.repository.CompanyRepository;
import org.example.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Testing {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompanyRepository repository;

    @Test
    void finalTesting() throws Exception{
        Company company = new Company();
        company.setName("Google");
        company.setCountry("USA");
        repository.save(company);
        mockMvc.perform(get("/app/v1/companies/1" + company.getId())).andExpect(status().isOk()).
                andExpect(jsonPath("$.id").value(company.getId()))
                .andExpect(jsonPath("$.name").value("Google"));


    }
}
