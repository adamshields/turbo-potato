package com.example.adam.repository;

import com.example.adam.entity.ApprovalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalModelRepository extends JpaRepository<ApprovalModel, Long> {
}