//package com.example.adam.service;
//
//import com.example.adam.dto.DesignDTO;
//import com.example.adam.entity.Design;
//import com.example.adam.repository.DesignRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class DesignServiceImpl implements DesignService {
//
//    private final DesignRepository designRepository;
//    private final ModelMapper modelMapper;
//
//    @Override
//    public DesignDTO getDesignById(Long id) {
//        Design design = designRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException());
//        return modelMapper.map(design, DesignDTO.class);
//    }
//}
////    @Override
////    public DesignDTO createDesign(DesignDTO designDTO) {
////        Design design = modelMapper.map(designDTO, Design.class);
////        design = designRepository.save(design);
////        return modelMapper.map(design, DesignDTO.class);
////    }
////
////    @Override
////    public DesignDTO getDesignById(Long id) {
////        Optional<Design> optionalDesign = designRepository.findById(id);
////        return optionalDesign.map(design -> modelMapper.map(design, DesignDTO.class)).orElse(null);
////    }
////
////    @Override
////    public DesignDTO updateDesign(Long id, DesignDTO designDTO) {
////        Optional<Design> optionalDesign = designRepository.findById(id);
////        if (optionalDesign.isPresent()) {
////            Design design = optionalDesign.get();
////            design.setName(designDTO.getName());
////            design.setVersion(designDTO.getVersion());
////            designRepository.save(design);
////            return modelMapper.map(design, DesignDTO.class);
////        } else {
////            return null;
////        }
////    }
////
////    @Override
////    public void deleteDesign(Long id) {
////        designRepository.deleteById(id);
////    }
////
////}
