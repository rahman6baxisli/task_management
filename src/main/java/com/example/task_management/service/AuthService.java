package com.example.task_management.service;
import com.example.task_management.dao.dto.RegisterDTO;
import com.example.task_management.dao.entity.Organization;
import com.example.task_management.dao.entity.User;
import com.example.task_management.dao.enums.Role;
import com.example.task_management.dao.repository.OrganizationRepository;
import com.example.task_management.dao.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final OrganizationRepository organizationRepository;
    private final PasswordEncoder passwordEncoder;

    private final String jwtSecret = "YourJWTSecretKey";
    private final long jwtExpirationMs = 864_000_000;

    public String register(RegisterDTO registerDTO) {
        Organization organization = new Organization();
        organization.setName(registerDTO.getOrganization().getName());
        organization.setContactNumber(registerDTO.getOrganization().getContactNumber());
        organization.setAddress(registerDTO.getOrganization().getAddress());
        Organization savedOrganization = organizationRepository.save(organization);

        User user = new User();
        user.setName(registerDTO.getName());
        user.setSurname(registerDTO.getSurname());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        user.setRole(registerDTO.getRole() != null ? registerDTO.getRole() : Role.USER);
        user.setOrganization(savedOrganization);
        User savedUser = userRepository.save(user);

        return generateToken(savedUser.getEmail());
    }

    private String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
