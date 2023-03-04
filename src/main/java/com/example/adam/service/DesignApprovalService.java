package com.example.adam.service;

import com.example.adam.entity.ApprovalModel;
import com.example.adam.entity.Design;
import com.example.adam.repository.ApprovalModelRepository;
import com.example.adam.repository.DesignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class DesignApprovalService {

    @Autowired
    private ApprovalModelRepository approvalModelRepository;

    @Autowired
    private DesignRepository designRepository;

    public ApprovalModel createApprovalModel() {
        ApprovalModel approvalModel = new ApprovalModel();
        approvalModel.setFullyApproved(false);
        approvalModel.setLevel1Approval("");
        approvalModel.setLevel2Approval("");
        approvalModel.setLevel3Approval("");

        return approvalModelRepository.save(approvalModel);
    }

    public ApprovalModel approveDesign(Long approvalModelId, String username, int level) {
        ApprovalModel approvalModel = approvalModelRepository.findById(approvalModelId).orElseThrow(() -> new NotFoundException("Approval model not found"));

        if (level < 1 || level > 3) {
            throw new IllegalArgumentException("Invalid approval level");
        }

        switch (level) {
            case 1:
                approvalModel.setLevel1Approval(username);
                break;
            case 2:
                approvalModel.setLevel2Approval(username);
                break;
            case 3:
                approvalModel.setLevel3Approval(username);
                break;
        }

        if (approvalModel.getLevel1Approval() != "" && approvalModel.getLevel2Approval() != "" && approvalModel.getLevel3Approval() != "") {
            approvalModel.setFullyApproved(true);
        }

        approvalModelRepository.save(approvalModel);

        Design design = (Design) designRepository.findByApprovalModelId(approvalModelId);
        design.setApprovalModel(approvalModel);
        designRepository.save(design);

        return approvalModel;
    }


    public void setApprovalModelRepository(ApprovalModelRepository approvalModelRepository) {
    }

    public void setDesignRepository(DesignRepository designRepository) {
    }
}
