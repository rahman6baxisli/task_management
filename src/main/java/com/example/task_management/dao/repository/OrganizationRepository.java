package com.example.task_management.dao.repository;

import com.example.task_management.dao.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
