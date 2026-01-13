# basic-springboot-security
Spring boot security with basic implemetation


Core Concepts and Architecture

Q.1 What is Spring Security?

Spring Security is a comprehensive and customizable framework for securing Java applications, offering features for authentication, authorization, and protection against common web vulnerabilities.

Q.2Explain the Spring Security Filter Chain.

Spring Security utilizes a chain of Servlet filters. Key filters include SecurityContextPersistenceFilter, UsernamePasswordAuthenticationFilter, ExceptionTranslationFilter, and FilterSecurityInterceptor.

Q.3What is the difference between Authentication and Authorization?

Authentication verifies identity ("Who are you?"), while authorization determines permissions for an authenticated user ("Are you allowed to do this?").
What is UserDetailsService and GrantedAuthority?
UserDetailsService retrieves user details from a data source, and GrantedAuthority represents permissions or roles used for authorization. 
Configuration and Implementation
How do you configure Spring Security in a Spring Boot application?
Configuration involves adding the security starter dependency and defining security rules and components using configuration classes.
How does Spring Security handle password hashing?
Spring Security uses the PasswordEncoder interface with implementations like BCryptPasswordEncoder to securely hash and verify passwords.
What are @PreAuthorize and @PostAuthorize annotations?
These annotations provide method-level security using SpEL. @PreAuthorize checks permissions before execution, while @PostAuthorize checks them after. 
Advanced Topics
What is CSRF protection in Spring Security?
Spring Security includes built-in Cross-Site Request Forgery (CSRF) protection to prevent malicious actions, using unique tokens to validate requests.
Explain OAuth2 in Spring Security.
OAuth2 is an authorization framework enabling limited third-party access without credential sharing. Spring Security supports implementing both authorization and resource server roles for OAuth2.
What is JWT and how is it used with Spring Security?
JSON Web Tokens (JWT) are used to represent claims. In stateless APIs, a JWT obtained after authentication is sent in subsequent requests and validated by Spring Security to establish a stateless security context. 
