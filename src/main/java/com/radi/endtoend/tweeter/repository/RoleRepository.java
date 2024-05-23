package com.radi.endtoend.tweeter.repository;

import com.radi.endtoend.tweeter.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
