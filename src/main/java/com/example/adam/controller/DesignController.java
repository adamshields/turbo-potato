package com.example.adam.controller;
import com.example.adam.entity.User;
import com.example.adam.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//
//import com.example.adam.dto.DesignDTO;
//import com.example.adam.entity.Design;
//import com.example.adam.repository.DesignRepository;
//import io.swagger.v3.oas.annotations.Operation;
//import org.modelmapper.ModelMapper;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("v1")
@RequestMapping("v1")
@RestController
public class DesignController {
    @Autowired
    private DesignService designService;

    @PostMapping("/design/{id}/approve/{level}")
    public ResponseEntity<?> approveDesign(@PathVariable("id") Long designId,
                                           @PathVariable("level") int level,
                                           @RequestBody User user) {
        designService.approveDesign(designId, user, level);
        return ResponseEntity.ok().build();
    }
}


//public class DesignController {
//    private final DesignRepository designRepository;
//    private final ModelMapper modelMapper;
//
//    public DesignController(DesignRepository designRepository, ModelMapper modelMapper) {
//        this.designRepository = designRepository;
//        this.modelMapper = modelMapper;
//    }
//
//    @GetMapping("/designs")
//    @Operation(summary = "Get all Design", description = "Returns all designs")
//    public ResponseEntity<List<DesignDTO>> getAllDesigns() {
//        List<Design> designs = designRepository.findAll();
//        List<DesignDTO> designDtos = designs.stream()
//                .map(design -> modelMapper.map(design, DesignDTO.class))
//                .collect(Collectors.toList());
//        return new ResponseEntity<>(designDtos, HttpStatus.OK);
//    }
//
//    @GetMapping("/designs/{id}")
//    @Operation(summary = "Get design by ID", description = "Returns a design with the specified ID.")
//    public ResponseEntity<DesignDTO> getDesignById(@PathVariable("id") Integer id) {
//        Optional<Design> designOptional = designRepository.findById(id);
//        if (designOptional.isPresent()) {
//            Design design = designOptional.get();
//            DesignDTO designDto = modelMapper.map(design, DesignDTO.class);
//            return new ResponseEntity<>(designDto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//    @PostMapping("/designs")
//    @Operation(summary = "Create a design", description = "Creates a new design.")
//    public ResponseEntity<DesignDTO> createDesign(@RequestBody @Valid DesignDTO designDto) {
//        Design design = modelMapper.map(designDto, Design.class);
//        Design savedDesign = designRepository.save(design);
//        DesignDTO savedDesignDto = modelMapper.map(savedDesign, DesignDTO.class);
//        return new ResponseEntity<>(savedDesignDto, HttpStatus.CREATED);
//    }
//
//
//    @PutMapping("/designs/{id}")
//    @Operation(summary = "Updates the design", description = "Updates the design PUT full body required")
//    public ResponseEntity<DesignDTO> updateDesign(@PathVariable("id") Integer id, @RequestBody DesignDTO designDto) {
//        Optional<Design> designOptional = designRepository.findById(id);
//        if (designOptional.isPresent()) {
//            Design existingDesign = designOptional.get();
//            // Update the existing design with the values from the updated design
//            modelMapper.map(designDto, existingDesign);
//            Design updatedDesign = designRepository.save(existingDesign);
//            DesignDTO updatedDesignDto = modelMapper.map(updatedDesign, DesignDTO.class);
//            return new ResponseEntity<>(updatedDesignDto, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/designs/{id}")
//    @Operation(summary = "Deletes the design", description = "Deletes the design with the specified ID.")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteDesign(@PathVariable("id") Integer id) {
//        designRepository.deleteById(id);
//    }
//
//    @GetMapping("/designs/approved")
//    @Operation(summary = "Gets all Approved designs by isApproved")
//    public List<Design> getApprovedDesigns() {
//        return designRepository.findByIsApproved(true);
//    }
//
//    @GetMapping("/designs/unapproved")
//    @Operation(summary = "Gets all unapproved designs by isApproved")
//    public List<Design> getUnapprovedDesigns() {
//        return designRepository.findByIsApproved(false);
//    }
//
//    @PutMapping("/designs/approve/{id}")
//    @Operation(summary = "Approves Design by id")
//    public ResponseEntity<?> approveDesign(@PathVariable(value = "id") int designId) {
//        Optional<Design> designOptional = designRepository.findById(designId);
//        if (designOptional.isPresent()) {
//            Design design = designOptional.get();
//            design.setIsApproved(true);
//            designRepository.save(design);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PutMapping("/designs/unapprove/{id}")
//    @Operation(summary = "Removes approvals on a design by id")
//    public ResponseEntity<?> unapproveDesign(@PathVariable(value = "id") int designId) {
//        Optional<Design> designOptional = designRepository.findById(designId);
//        if (designOptional.isPresent()) {
//            Design design = designOptional.get();
//            design.setIsApproved(false);
//            designRepository.save(design);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/designs/level1-approve/{id}")
//    @Operation(summary = "Adds Level 1 approvals on a design by id")
//    public ResponseEntity<?> level1Approve(@PathVariable("id") int designId) {
//        Optional<Design> designOptional = designRepository.findById(designId);
//        if (designOptional.isPresent()) {
//            Design design = designOptional.get();
//            if (!design.getLevel1Approval()) {
//                design.setLevel1Approval(true);
//                designRepository.save(design);
//                return ResponseEntity.ok().build();
//            } else {
//                return ResponseEntity.badRequest().body("Level 1 approval already granted");
//            }
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/designs/level2-approve/{id}")
//    @Operation(summary = "Adds Level 2 approvals on a design by id")
//    public ResponseEntity<?> level2Approve(@PathVariable("id") int designId) {
//        Optional<Design> designOptional = designRepository.findById(designId);
//        if (designOptional.isPresent()) {
//            Design design = designOptional.get();
//            if (design.getLevel1Approval() && !design.getLevel2Approval()) {
//                design.setLevel2Approval(true);
//                designRepository.save(design);
//                return ResponseEntity.ok().build();
//            } else {
//                return ResponseEntity.badRequest().body("Cannot approve level 2 without level 1 approval or level 2 approval already granted");
//            }
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping("/designs/level3-approve/{id}")
//    @Operation(summary = "Adds Level 3 approvals on a design by id and marks the design approved")
//    public ResponseEntity<?> level3Approve(@PathVariable("id") int designId) {
//        Optional<Design> designOptional = designRepository.findById(designId);
//        if (designOptional.isPresent()) {
//            Design design = designOptional.get();
//            if (design.getLevel1Approval() && design.getLevel2Approval() && !design.getLevel3Approval()) {
//                design.setLevel3Approval(true);
//                designRepository.save(design);
//                design.setDesignApproval("Approved");
//                designRepository.save(design);
//                return ResponseEntity.ok().build();
//            } else {
//                return ResponseEntity.badRequest().body("Cannot approve level 3 without level 1 and 2 approval or level 3 approval already granted");
//            }
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
//    @PostMapping("/designs/super-approve/{id}")
//    @Operation(summary = "Fast Track Super Approvals")
//    public ResponseEntity<?> superApprove(@PathVariable("id") int designId) {
//        Optional<Design> designOptional = designRepository.findById(designId);
//        if (designOptional.isPresent()) {
//            Design design = designOptional.get();
//            design.setDesignApproval("Approved");
//            designRepository.save(design);
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//}
