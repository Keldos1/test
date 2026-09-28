package org.example.repository;

import jdk.dynalink.linker.LinkerServices;
import org.apache.catalina.User;
import org.example.entity.Company;
import org.example.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findAll();
    Optional<Users> findByUserName(String userName);

}
