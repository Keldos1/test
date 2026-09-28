package org.example;

import org.example.controller.CompanyController;
import org.example.dto.CompanyDto;
import org.example.dto.CompanyMainDto;
import org.example.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private CompanyService service;

    @Test
    void createCompany_shouldReturnCreated() throws Exception {
        ArgumentCaptor<CompanyMainDto> captor = ArgumentCaptor.forClass(CompanyMainDto.class);
        when(service.create(any(CompanyMainDto.class))).thenReturn(new CompanyDto(10L, "Apple"));
        mockMvc.perform(post("/app/v1/companies").contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "name": "Apple"
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.name").value("Apple"));

        verify(service).create(captor.capture());
        CompanyMainDto actualDto = captor.getValue();
        assertEquals("Apple", actualDto.name());
    }
}
