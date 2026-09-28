package org.example;

import org.example.repository.CompanyRepository;
import org.example.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class CompanyServiceTest {
    @Mock
    private CompanyRepository repository;

    @InjectMocks
    private CompanyService service;

    @Test
    void findByIdCompanyTesting() {
        service.findCompanyTwice(1l);
        verify(repository, times(2)).findById(1L);
    }

}
