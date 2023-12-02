package com.loginManagement.repo;

import com.loginManagement.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
}
