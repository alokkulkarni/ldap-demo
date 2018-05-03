package com.example.ldap.ldapdemo;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.security.ldap.userdetails.PersonContextMapper;
import org.springframework.stereotype.Service;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import java.util.List;

import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service
public class UserServcie {

    private UserRepo userRepo;
    private LdapTemplate ldapTemplate;


    public UserServcie(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> searchByNameName(String lastName) {
        return userRepo.findByFullNameContains(lastName);
    }

    public List<String> findAll() {
        LdapQuery query = query()
                .base("dc=springframework,dc=org")
                .attributes("cn","sn")
                .where("ou").is("people");
        return ldapTemplate.search(query,
                (AttributesMapper<String>) attributes -> (String) attributes.get("cn").get());
    }

    public List<String> findUser(String lastname) {
        LdapQuery query = query()
                .base("dc=springframework,dc=org")
                .attributes("cn","sn")
                .where("ou").is("people")
                .and("sn").is(lastname);
        return ldapTemplate.search(query,
                (AttributesMapper<String>) attributes -> (String) attributes.get("cn").get());
    }

    public List<String> findUserBySN(String lastname) {
        LdapQuery query = query()
                .base("dc=springframework,dc=org")
                .attributes("cn","sn")
                .where("ou").is("people")
                .and("sn").is(lastname);
        return ldapTemplate.search(query, (AttributesMapper<String>) attributes -> (String) attributes.get("cn").get());
    }

//    public LdapName toAbsoluteDn(Name relativeName) {
//        return LdapNameBuilder.newInstance(baseLdapPath)
//                .add(relativeName)
//                .build();
//    }

}
