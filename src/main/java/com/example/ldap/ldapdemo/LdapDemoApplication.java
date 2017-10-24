package com.example.ldap.ldapdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableLdapRepositories
public class LdapDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LdapDemoApplication.class, args);
	}
}
