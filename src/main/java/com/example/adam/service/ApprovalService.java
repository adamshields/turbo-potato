package com.example.adam.service;

import com.example.adam.entity.ApprovalModel;
import com.example.adam.entity.Design;
import com.example.adam.repository.ApprovalModelRepository;
import com.example.adam.repository.DesignRepository;
import com.example.adam.repository.UsersModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApprovalService {
    @Autowired
    private ApprovalModelRepository approvalRepo;

    @Autowired
    private DesignRepository designRepo;

    @Autowired
    private UsersModelRepository userRepo;

    public void approveDesign(Long designId, String approval, String userName) {
        Optional<Design> designOptional = designRepo.findById(designId);
        if (designOptional.isPresent()) {
            Design design = designOptional.get();
            ApprovalModel approvalModel = design.getApprovalModel();
            if (approvalModel == null) {
                approvalModel = new ApprovalModel();
                design.setApprovalModel(approvalModel);
            }
            if (approvalModel.getLevel1Approval() == null) {
                approvalModel.setLevel1Approval(userName);
            } else if (approvalModel.getLevel2Approval() == null) {
                approvalModel.setLevel2Approval(userName);
            } else if (approvalModel.getLevel3Approval() == null) {
                approvalModel.setLevel3Approval(userName);
                approvalModel.setFullyApproved(true);
                design.setIsEditable(false);
            }
            approvalRepo.save(approvalModel);
            designRepo.save(design);
        }
    }
}

