package com.example.adam.repository;
import com.example.adam.entity.Design;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface DesignRepository extends JpaRepository<Design, Integer> {
    List<Design> findByDesignStatus(String designStatus);
    List<Design> findByAppId(Integer appId);
    List<Design> findByIsApproved(boolean isApproved);
//    @Modifying
//    @Query("UPDATE Design d SET d.isApproved = :isApproved WHERE d.designId = :designId")
//    void updateApprovalStatus(@Param("designId") int designId, @Param("isApproved") boolean isApproved);


}