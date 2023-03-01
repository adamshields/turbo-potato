package com.example.adam.controller;

import com.example.adam.entity.Application;
import com.example.adam.entity.Design;
import com.example.adam.repository.ApplicationRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1")
public class ApplicationController {
    private final ApplicationRepository applicationRepository;

    public ApplicationController(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping("/applications")
    @Operation(summary = "Get all Applications", description = "Returns all applications")
    public ResponseEntity<List<Application>> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    @GetMapping("/applications/{id}")
    @Operation(summary = "Get application by ID", description = "Returns an application with the specified ID.")
    public ResponseEntity<Application> getApplicationById(@PathVariable("id") Long id) {
        Optional<Application> applicationOptional = applicationRepository.findById(id);
        if (applicationOptional.isPresent()) {
            Application application = applicationOptional.get();
            return new ResponseEntity<>(application, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/applications")
    @Operation(summary = "Create an application", description = "Creates a new application.")
    public ResponseEntity<Application> createApplication(@RequestBody @Valid Application application) {
        Application savedApplication = applicationRepository.save(application);
        return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
    }

    @PutMapping("/applications/{id}")
    @Operation(summary = "Updates the application", description = "Updates the application with the specified ID.")
    public ResponseEntity<Application> updateApplication(@PathVariable("id") Long id, @RequestBody Application updatedApplication) {
        Optional<Application> applicationOptional = applicationRepository.findById(id);
        if (applicationOptional.isPresent()) {
            Application existingApplication = applicationOptional.get();
            // Update the existing application with the values from the updated application
            existingApplication.setName(updatedApplication.getName());
            existingApplication.setAit(updatedApplication.getAit());
            existingApplication.setDescription(updatedApplication.getDescription());
            Application updatedApplicationResult = applicationRepository.save(existingApplication);
            return new ResponseEntity<>(updatedApplicationResult, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/applications/{id}")
    @Operation(summary = "Deletes the application", description = "Deletes the application with the specified ID.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteApplication(@PathVariable("id") Long id) {
        applicationRepository.deleteById(id);
    }

    @GetMapping("/applications/{id}/designs")
    public ResponseEntity<List<Design>> getDesignsByApplicationId(@PathVariable("id") Long applicationId) {
        Optional<Application> applicationOptional = applicationRepository.findById(applicationId);
        if (applicationOptional.isPresent()) {
            Application application = applicationOptional.get();
            List<Design> designs = application.getDesigns();
            return new ResponseEntity<>(designs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
