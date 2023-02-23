//package com.example.adam.controller;
//
//import com.example.adam.dto.ApplicationDTO;
//import com.example.adam.entity.Application;
//import com.example.adam.service.ApplicationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/applications")
//public class ApplicationController {
//
//    @Autowired
//    private ApplicationService applicationService;
//
//    @GetMapping
//    public List<ApplicationDTO> getAllApplications() {
//        List<Application> applications = applicationService.getAllApplications();
//        return applications.stream()
//                .map(application -> convertToDto(application))
//                .collect(Collectors.toList());
//    }
//
//    @PostMapping
//    public ApplicationDTO createApplication(@RequestBody ApplicationDTO applicationDto) {
//        Application application = convertToEntity(applicationDto);
//        Application savedApplication = applicationService.saveApplication(application);
//        return convertToDto(savedApplication);
//    }
//
////    @PutMapping("/{id}")
////    public ApplicationDTO updateApplication(@PathVariable Long id, @RequestBody ApplicationDTO applicationDto) {
////        Application application = convertToEntity(applicationDto);
////        application.setId(id);
////        Application updatedApplication = applicationService.updateApplication(application);
////        return convertToDto(updatedApplication);
////    }
//
////    @DeleteMapping("/{id}")
////    public void deleteApplication(@PathVariable Long id) {
////        applicationService.deleteApplication(id);
////    }
//
////    private ApplicationDTO convertToDto(Application application) {
////        return modelMapper.map(application, ApplicationDTO.class);
////    }
////
////    private Application convertToEntity(ApplicationDTO applicationDto) {
////        return modelMapper.map(applicationDto, Application.class);
////    }
//}
