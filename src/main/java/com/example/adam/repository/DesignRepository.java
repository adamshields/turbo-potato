package com.example.adam.repository;
import com.example.adam.entity.Design;
import com.example.adam.entity.DesignModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DesignRepository extends JpaRepository<DesignModel, Integer> {
    List<DesignModel> findByDesignStatus(String designStatus);
    List<DesignModel> findByAppId(Integer appId);
}