package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringRunner {
    public static void main(String[] args) {

        var applicationContext = SpringApplication.run(SpringRunner.class, args);
//        CompanyRepository companyRepo = applicationContext.getBean(CompanyRepository.class);
//        Pageable pageable = PageRequest.of(0,3, Sort.by(direction, "name"));
//        Page<Company> page = companyRepo.findAll(pageable);
//        List<Company> companies = companyRepo.findAll();
//        page.forEach(company -> System.out.println(company.getName()));
//        System.out.println("_______________________________________");
//        companies.forEach(company -> System.out.println(company.getName()));


    }

}