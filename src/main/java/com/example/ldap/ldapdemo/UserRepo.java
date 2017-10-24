package com.example.ldap.ldapdemo;

import org.springframework.data.ldap.repository.LdapRepository;

import java.util.List;

public interface UserRepo extends LdapRepository<User> {

    User findByEmployeeNumber(String employeeNumber);
    List<User> findByFullNameContains(String name);
    
}
