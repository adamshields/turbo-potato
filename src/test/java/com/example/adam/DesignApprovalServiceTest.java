//package com.example.adam;
//
//import com.example.adam.entity.ApprovalModel;
//import com.example.adam.entity.Design;
//import com.example.adam.repository.ApprovalModelRepository;
//import com.example.adam.repository.DesignRepository;
//import com.example.adam.service.DesignApprovalService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.Mockito.when;
//
//
//@DataJpaTest
//public class DesignApprovalServiceTest {
//
//    private DesignApprovalService designApprovalService;
//
//    @Mock
//    private ApprovalModelRepository approvalModelRepository;
//
//    @Mock
//    private DesignRepository designRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        designApprovalService = new DesignApprovalService();
//        designApprovalService.setApprovalModelRepository(approvalModelRepository);
//        designApprovalService.setDesignRepository(designRepository);
//    }
//
//    @Test
//    public void testCreateApprovalModel() {
//        ApprovalModel approvalModel = new ApprovalModel();
//        approvalModel.setId(1L);
//        approvalModel.setFullyApproved(false);
//        approvalModel.setLevel1Approval("");
//        approvalModel.setLevel2Approval("");
//        approvalModel.setLevel3Approval("");
//
//        when(approvalModelRepository.save(approvalModel)).thenReturn(approvalModel);
//
//        ApprovalModel savedApprovalModel = designApprovalService.createApprovalModel();
//
//        assertThat(savedApprovalModel).isNotNull();
//        assertThat(savedApprovalModel.getId()).isEqualTo(1L);
//        assertThat(savedApprovalModel.getFullyApproved()).isFalse();
//        assertThat(savedApprovalModel.getLevel1Approval()).isEmpty();
//        assertThat(savedApprovalModel.getLevel2Approval()).isEmpty();
//        assertThat(savedApprovalModel.getLevel3Approval()).isEmpty();
//    }
//
//    @Test
//    public void testApproveDesign() {
//        ApprovalModel approvalModel = new ApprovalModel();
//        approvalModel.setId(1L);
//        approvalModel.setFullyApproved(false);
//        approvalModel.setLevel1Approval("");
//        approvalModel.setLevel2Approval("");
//        approvalModel.setLevel3Approval("");
//
//        Design design = new Design();
//        design.setDesignName("MyDesign");
//        design.setDesignVersion("1.0");
//        design.setApprovalModel(approvalModel);
//
//        when(approvalModelRepository.findById(approvalModel.getId())).thenReturn(Optional.of(approvalModel));
//        when(designRepository.save(design)).thenReturn(design);
//        when(approvalModelRepository.save(approvalModel)).thenReturn(approvalModel);
//
//        ApprovalModel updatedApprovalModel = designApprovalService.approveDesign(1L, "user1", 1);
//
//        assertThat(updatedApprovalModel).isNotNull();
//        assertThat(updatedApprovalModel.getId()).isEqualTo(1L);
//        assertThat(updatedApprovalModel.getLevel1Approval()).isEqualTo("user1");
//        assertThat(updatedApprovalModel.getFullyApproved()).isFalse();
//
//        updatedApprovalModel = designApprovalService.approveDesign(1L, "user2", 2);
//
//        assertThat(updatedApprovalModel).isNotNull();
//        assertThat(updatedApprovalModel.getId()).isEqualTo(1L);
//        assertThat(updatedApprovalModel.getLevel2Approval()).isEqualTo("user2");
//        assertThat(updatedApprovalModel.getFullyApproved()).isFalse();
//
//        updatedApprovalModel = designApprovalService.approveDesign(1L, "user3", 3);
//
//        assertThat(updatedApprovalModel).isNotNull();
//        assertThat(updatedApprovalModel.getId()).isEqualTo(1L);
//        assertThat(updatedApprovalModel.getLevel3Approval()).isEqualTo("user3");
//        assertThat(updatedApprovalModel.getFullyApproved()).isTrue();
//
//        assertThat(design.getApprovalModel()).isEqualTo(approvalModel);
//    }
//}