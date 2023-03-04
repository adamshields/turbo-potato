package com.example.adam;

import com.example.adam.entity.ApprovalModel;
import com.example.adam.entity.Design;
import com.example.adam.entity.User;
import com.example.adam.repository.DesignRepository;
import com.example.adam.repository.ApprovalModelRepository;
//import com.example.adam.service.ApprovalService;
import com.example.adam.service.DesignService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DesignServiceTest {
    @Autowired
    private DesignService designService;

    @Autowired
    private ApprovalModelRepository approvalModelRepository;

    @Autowired
    private DesignRepository designRepository;

    @Test
    public void testApproveDesign() {
        // Create a new Design object
        Design design = new Design();
        design.setDesignName("Test Design");
        design.setDesignVersion("initial");
        design.setIsEditable(true);

        // Save the Design object to the database
        design = designRepository.save(design);

        // Create a new ApprovalModel object
        ApprovalModel approvalModel = new ApprovalModel();
        approvalModel.setDesign(design);
        approvalModelRepository.save(approvalModel);

        // Create three User objects
        User user1 = new User();
        user1.setFirstName("User 1");
        User user2 = new User();
        user2.setFirstName("User 2");
        User user3 = new User();
        user3.setFirstName("User 3");

        // Approve the design at level 1
        designService.approveDesign(design.getDesignId(), user1, 1);

        // Retrieve the ApprovalModel object from the database
        approvalModel = approvalModelRepository.findById(design.getDesignId()).orElseThrow(() -> new RuntimeException("Approval model not found"));

        // Verify that the ApprovalModel object has the correct user at level 1
        assertEquals(user1, approvalModel.getApprovedByLevel1());
        assertNull(approvalModel.getApprovedByLevel2());
        assertNull(approvalModel.getApprovedByLevel3());
        assertFalse(design.isFullyApproved());

        // Approve the design at level 2
        designService.approveDesign(design.getDesignId(), user2, 2);

        // Retrieve the ApprovalModel object from the database
        approvalModel = approvalModelRepository.findById(design.getDesignId()).orElseThrow(() -> new RuntimeException("Approval model not found"));

        // Verify that the ApprovalModel object has the correct users at levels 1 and 2
        assertEquals(user1, approvalModel.getApprovedByLevel1());
        assertEquals(user2, approvalModel.getApprovedByLevel2());
        assertNull(approvalModel.getApprovedByLevel3());
        assertFalse(design.isFullyApproved());

        // Approve the design at level 3
        designService.approveDesign(design.getDesignId(), user3, 3);

        // Retrieve the ApprovalModel object from the database
        approvalModel = approvalModelRepository.findById(design.getDesignId()).orElseThrow(() -> new RuntimeException("Approval model not found"));

        // Retrieve the Design object from the database
        design = designRepository.findById(design.getDesignId()).orElseThrow(() -> new RuntimeException("Design not found"));

        // Verify that the ApprovalModel object has the correct users at levels 1, 2, and 3
        assertEquals(user1, approvalModel.getApprovedByLevel1());
        assertEquals(user2, approvalModel.getApprovedByLevel2());
        assertEquals(user3, approvalModel.getApprovedByLevel3());

        // Verify that the Design object is fully approved
        assertTrue(design.isFullyApproved());
    }
}
