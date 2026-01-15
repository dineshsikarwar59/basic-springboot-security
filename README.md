# basic-springboot-security

**Q.1 What is Spring Security?**

Spring Security is a comprehensive and customizable framework for securing Java applications, offering features for authentication, authorization, and protection against common web vulnerabilities.

**Q.3 What is the difference between Authentication and Authorization?**

Authentication verifies identity ("Who are you?"), while authorization determines permissions for an authenticated user ("Are you allowed to do this?").

**Q.4 What is UserDetailsService and GrantedAuthority?**

UserDetailsService retrieves user details from a data source, and GrantedAuthority represents permissions or roles used for authorization.

**Q.6 How does Spring Security handle password hashing?**

Spring Security uses the PasswordEncoder interface with implementations like BCryptPasswordEncoder to securely hash and verify passwords.

**Q.7 What are @PreAuthorize and @PostAuthorize annotations?**

These annotations provide method-level security using SpEL. @PreAuthorize checks permissions before execution, while @PostAuthorize checks them after. 

**Q.8 What is CSRF protection in Spring Security?**

Spring Security includes built-in Cross-Site Request Forgery (CSRF) protection to prevent malicious actions, using unique tokens to validate requests.

CSRF (Cross-Site Request Forgery) is an attack where a user is tricked into performing unintended actions on a web application they are authenticated to. Spring Security provides protection against CSRF attacks by requiring a CSRF token for sensitive requests (like POST, PUT, DELETE), which ensures the request is coming from the legitimate user.

How CSRF Protection Works:

Spring Security generates a CSRF token for each session.
The client must send this token in each sensitive request.
If the token doesn't match the server's stored token, the request is rejected.

Disabling CSRF Protection:

For stateless applications (e.g., APIs using JWT), you can disable CSRF as it's not necessary. You can disable it with the following configuration:

@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/public/**").permitAll()
        .anyRequest().authenticated();
}

When to Disable CSRF:

When Using stateless authentication (like JWT) or APIs.
Not needed if you're not using session-based authentication.

