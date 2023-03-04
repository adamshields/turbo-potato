//package com.example.adam.service;
//
//import com.example.adam.dto.ApplicationDTO;
//import com.example.adam.entity.Application;
//import com.example.adam.repository.ApplicationRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//@Service
//public class ApplicationService {
////
//    private final ApplicationRepository applicationRepository;
//    private final ModelMapper modelMapper;
//
//    @Autowired
//    public ApplicationService(ApplicationRepository applicationRepository, ModelMapper modelMapper) {
//        this.applicationRepository = applicationRepository;
//        this.modelMapper = modelMapper;
//    }
////
////    public ApplicationDTO createApplication(ApplicationDTO applicationDTO) {
////        Application application = modelMapper.map(applicationDTO, Application.class);
////        Application savedApplication = applicationRepository.save(application);
////        return modelMapper.map(savedApplication, ApplicationDTO.class);
////    }
////
////    public ApplicationDTO updateApplication(Long id, ApplicationDTO applicationDTO) {
////        Application applicationToUpdate = applicationRepository.findById(id)
////                .orElseThrow(() -> new ResourceNotFoundException());
////        modelMapper.map(applicationDTO, applicationToUpdate);
////        Application updatedApplication = applicationRepository.save(applicationToUpdate);
////        return modelMapper.map(updatedApplication, ApplicationDTO.class);
////    }
////
////    public void deleteApplication(Long id) {
////        Application applicationToDelete = applicationRepository.findById(id)
////                .orElseThrow(() -> new ResourceNotFoundException());
////        applicationRepository.delete(applicationToDelete);
////    }
////
////    public List<Application> getAllApplications() {
////        List<Application> applications = applicationRepository.findAll();
////        return applications.stream()
////                .map(application -> modelMapper.map(application, ApplicationDTO.class))
////                .collect(Collectors.toList());
////    }
////
////    public ApplicationDTO getApplicationById(Long id) {
////        Application application = applicationRepository.findById(id)
////                .orElseThrow(() -> new ResourceNotFoundException("Application", "id", id));
////        return modelMapper.map(application, ApplicationDTO.class);
////    }
//}
