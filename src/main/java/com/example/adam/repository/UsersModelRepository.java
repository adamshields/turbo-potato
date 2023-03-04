package com.example.adam.repository;

import com.example.adam.entity.User;
import com.example.adam.entity.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersModelRepository extends JpaRepository<UsersModel, Long> {
}