package com.example.adam.service;
import com.example.adam.entity.ApprovalModel;
import com.example.adam.entity.Design;
import com.example.adam.entity.User;
import com.example.adam.repository.DesignRepository;
import com.example.adam.repository.ApprovalModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignService {
    @Autowired
    private ApprovalModelRepository approvalModelRepository;

    @Autowired
    private DesignRepository designRepository;

    public void approveDesign(Long designId, User user, int level) {
        ApprovalModel approvalModel = approvalModelRepository.findById(designId).orElseThrow(() -> new RuntimeException("Approval model not found"));

//        if (level == 1) {
//            approvalModel.setApprovedByLevel1(user);
//        } else if (level == 2) {
//            approvalModel.setApprovedByLevel2(user);
//        } else if (level == 3) {
//            approvalModel.setApprovedByLevel3(user);
//        }

//        if (approvalModel.getApprovedByLevel1() != null && approvalModel.getApprovedByLevel2() != null && approvalModel.getApprovedByLevel3() != null) {
//            Design design = designRepository.findById(designId).orElseThrow(() -> new RuntimeException("Design not found"));
//            design.setFullyApproved(true);
//            designRepository.save(design);
//        }

        approvalModelRepository.save(approvalModel);
    }
}
