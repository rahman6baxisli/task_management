package com.example.task_management.dao.entity;
 import com.example.task_management.dao.enums.Role;
 import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;
    @Enumerated(EnumType.STRING)
    private Role role;
}

