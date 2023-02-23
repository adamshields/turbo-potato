package com.example.adam.controller;

import com.example.adam.entity.Design;
import com.example.adam.entity.DesignModel;
import com.example.adam.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/designs")
public class DesignController {

    @Autowired
    private DesignService designService;

    @GetMapping("")
    public List<Design> getAllDesigns(@RequestParam(required = false) Long appId) {
        if (appId == null) {
            return designService.getAllDesigns();
        } else {
            return designService.getDesignsForApplication(appId);
        }
    }

    @PostMapping("")
    public Design createDesign(@RequestBody DesignModel designModel) {
        Design design = convertToEntity(designModel);
        return designService.createDesign(design);
    }

    @PutMapping("/{id}")
    public Design updateDesign(@PathVariable Long id, @RequestBody DesignModel designModel) {
        Design design = convertToEntity(designModel);
        design.setId(id);
        return designService.updateDesign(design);
    }

    @PatchMapping("/{id}")
    public Design partialUpdateDesign(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return designService.partialUpdateDesign(id, updates);
    }

    @DeleteMapping("/{id}")
    public void deleteDesign(@PathVariable Long id) {
        designService.deleteDesign(id);
    }

    @GetMapping("/{designId}/servers")
    public List<ServerDesignDTO> getServersForDesign(@PathVariable Long designId) {
        return designService.getServersForDesign(designId);
    }

    @PostMapping("/{designId}/servers")
    public void
}