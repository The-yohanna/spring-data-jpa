package com.johanna.springjpaecommerce.repository;

import com.johanna.springjpaecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
