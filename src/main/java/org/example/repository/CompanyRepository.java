package org.example.repository;

import org.example.entity.Company;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    List<Company> findAll();
//    List<Company> findByName(String name);
    Optional<Company> findByName(String name);

    List<Company> findByName(String name, Sort sort);

    @Override
    Optional<Company> findById(Long aLong);
}
