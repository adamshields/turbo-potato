package com.example.adam.repository;
import com.example.adam.entity.DesignModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface DesignRepository extends JpaRepository<DesignModel, Integer> {
    List<DesignModel> findByDesignStatus(String designStatus);
    List<DesignModel> findByAppId(Integer appId);
    List<DesignModel> findByIsApproved(boolean isApproved);
//    @Modifying
//    @Query("UPDATE DesignModel d SET d.isApproved = :isApproved WHERE d.designId = :designId")
//    void updateApprovalStatus(@Param("designId") int designId, @Param("isApproved") boolean isApproved);


}