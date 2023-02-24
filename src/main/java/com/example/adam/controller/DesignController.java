package com.example.adam.controller;

import com.example.adam.entity.DesignModel;
import com.example.adam.repository.DesignRepository;
import com.example.adam.service.DesignService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @ApiOperation(value = "Get all Designs", notes = "Returns all designs")
    @GetMapping("/designs")
    public ResponseEntity<List<DesignModel>> getAllDesigns() {
        List<DesignModel> designs = designRepository.findAll();
        return new ResponseEntity<>(designs, HttpStatus.OK);
    }

//    @GetMapping("/designs/{id}")
//    public ResponseEntity<DesignModel> getDesignById(
//            @ApiParam(value = "The ID of the design to retrieve", required = true)
//            @PathVariable("id") Integer id) {
//        DesignModel design = designRepository.findById(id).orElse(null);
//        if (design == null) {
//            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(design, HttpStatus.OK);
//        }
//    }
    @GetMapping("/designs/{id}")
    public ResponseEntity<DesignModel> getDesignById(@PathVariable("id") Integer id) {
        DesignModel design = designRepository.findById(id).orElse(null);
        if (design == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(design, HttpStatus.OK);
        }
    }

    @PostMapping("/designs")
    public ResponseEntity<DesignModel> createDesign(@RequestBody DesignModel design) {
        DesignModel savedDesign = designRepository.save(design);
        return new ResponseEntity<>(savedDesign, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesignModel> updateDesign(@PathVariable("id") Integer id, @RequestBody DesignModel design) {
        DesignModel existingDesign = designRepository.findById(id).orElse(null);
        if (existingDesign == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            existingDesign.setDesignVersion(design.getDesignVersion());
            existingDesign.setDesignName(design.getDesignName());
            existingDesign.setAppImpactId(design.getAppImpactId());
            existingDesign.setAppId(design.getAppId());
            existingDesign.setDesignStatus(design.getDesignStatus());
            existingDesign.setDesignBase(design.getDesignBase());
            existingDesign.setDesignApproval(design.getDesignApproval());
            DesignModel updatedDesign = designRepository.save(existingDesign);
            return new ResponseEntity<>(updatedDesign, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDesign(@PathVariable("id") Integer id) {
        try {
            designRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/designs/approved")
    public List<DesignModel> getApprovedDesigns() {
        return designRepository.findByIsApproved(true);
    }

    @GetMapping("/designs/unapproved")
    public List<DesignModel> getUnapprovedDesigns() {
        return designRepository.findByIsApproved(false);
    }

    @PutMapping("/designs/approve/{id}")
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

}