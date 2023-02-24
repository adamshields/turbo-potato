package com.example.adam.controller;

import com.example.adam.entity.DesignModel;
import com.example.adam.repository.DesignRepository;


import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1")
public class DesignController {
    private final DesignRepository designRepository;

    @Autowired
    public DesignController(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }
    private ModelMapper modelMapper = new ModelMapper();


    // GET ALL
    @GetMapping("/designs")
    @Operation(summary = "Get all Designs", description = "Returns all design")
    public ResponseEntity<List<DesignModel>> getAllDesigns() {
        List<DesignModel> designs = designRepository.findAll();
        return new ResponseEntity<>(designs, HttpStatus.OK);
    }


    @GetMapping("/designs/{id}")
    @Operation(summary = "Get design by ID", description = "Returns a design with the specified ID.")
    public ResponseEntity<DesignModel> getDesignById(@PathVariable("id") Integer id) {
        DesignModel design = designRepository.findById(id).orElse(null);
        if (design == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(design, HttpStatus.OK);
        }
    }

    @PostMapping("/designs")
    @Operation(summary = "Create a design", description = "Creates a new design.")
    public ResponseEntity<DesignModel> createDesign(@RequestBody @Valid DesignModel design) {
        DesignModel savedDesign = designRepository.save(design);
        return new ResponseEntity<>(savedDesign, HttpStatus.CREATED);
    }

    @PutMapping("/designs/{id}")
    @Operation(summary = "Updates the design", description = "Updates the design PUT full body required")
    public ResponseEntity<DesignModel> updateDesign(@PathVariable("id") Integer id, @RequestBody DesignModel designModel) {
        DesignModel existingDesign = designRepository.findById(id).orElse(null);
        if (existingDesign == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        modelMapper.map(designModel, existingDesign);
        DesignModel updatedDesign = designRepository.save(existingDesign);
        return new ResponseEntity<>(modelMapper.map(updatedDesign, DesignModel.class), HttpStatus.OK);
    }

    @DeleteMapping("/designs/{id}")
    @Operation(summary = "Deletes the design", description = "Delete the design")
    public ResponseEntity<HttpStatus> deleteDesign(@PathVariable("id") Integer id) {
        try {
            designRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/designs/approved")
    @Operation(summary = "Gets all Approved designs by isApproved")
    public List<DesignModel> getApprovedDesigns() {
        return designRepository.findByIsApproved(true);
    }

    @GetMapping("/designs/unapproved")
    @Operation(summary = "Gets all unapproved designs by isApproved")
    public List<DesignModel> getUnapprovedDesigns() {
        return designRepository.findByIsApproved(false);
    }

    @PutMapping("/designs/approve/{id}")
    @Operation(summary = "Approves Design by id")
    public ResponseEntity<?> approveDesign(@PathVariable(value = "id") int designId) {
        Optional<DesignModel> designOptional = designRepository.findById(designId);
        if (designOptional.isPresent()) {
            DesignModel design = designOptional.get();
            design.setIsApproved(true);
            designRepository.save(design);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/designs/unapprove/{id}")
    @Operation(summary = "removes approvals on a design by id")
    public ResponseEntity<?> unapproveDesign(@PathVariable(value = "id") int designId) {
        Optional<DesignModel> designOptional = designRepository.findById(designId);
        if (designOptional.isPresent()) {
            DesignModel design = designOptional.get();
            design.setIsApproved(false);
            designRepository.save(design);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/designs/level1-approve/{id}")
    @Operation(summary = "Adds Level 1 approvals on a design by id")
    public ResponseEntity<?> level1Approve(@PathVariable("id") int designId) {
        Optional<DesignModel> design = designRepository.findById(designId);
        if (design.isPresent()) {
            DesignModel existingDesign = design.get();
            existingDesign.setLevel1Approval(true);
            designRepository.save(existingDesign);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/designs/level2-approve/{id}")
    @Operation(summary = "Adds Level 2 approvals on a design by id")
    public ResponseEntity<?> level2Approve(@PathVariable("id") int designId) {
        Optional<DesignModel> design = designRepository.findById(designId);
        if (design.isPresent()) {
            DesignModel existingDesign = design.get();
            existingDesign.setLevel1Approval(true);
            designRepository.save(existingDesign);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/designs/level3-approve/{id}")
    @Operation(summary = "Adds Level 3 approvals on a design by id and marks the design approved")
    public ResponseEntity<?> level3Approve(@PathVariable("id") int designId) {
        Optional<DesignModel> design = designRepository.findById(designId);
        if (design.isPresent()) {
            DesignModel existingDesign = design.get();
            existingDesign.setLevel3Approval(true);
            designRepository.save(existingDesign);
            if (existingDesign.getLevel1Approval() && existingDesign.getLevel2Approval() && existingDesign.getLevel3Approval()) {
                existingDesign.setDesignApproval("Approved");
                designRepository.save(existingDesign);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/designs/super-approve/{id}")
    @Operation(summary = "Fast Track Super Approvals")
    public ResponseEntity<?> superApprove(@PathVariable("id") int designId) {
        Optional<DesignModel> design = designRepository.findById(designId);
        if (design.isPresent()) {
            DesignModel existingDesign = design.get();
            existingDesign.setDesignApproval("Approved");
            designRepository.save(existingDesign);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}