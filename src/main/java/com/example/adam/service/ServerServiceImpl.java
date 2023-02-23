//package com.example.adam.service;
//
//import com.example.adam.dto.ServerDTO;
//import com.example.adam.entity.Server;
//import com.example.adam.repository.ServerRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//public class ServerServiceImpl implements ServerService {
//    @Autowired
//    private ServerRepository serverRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    @Override
//    public ServerDTO getServerById(Long id) {
//        Server server = serverRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException());
//        return modelMapper.map(server, ServerDTO.class);
//    }
//}
////@Service
////public class ServerServiceImpl implements ServerService {
////
////    private final ServerRepository serverRepository;
////    private final ModelMapper modelMapper;
////
////    public ServerServiceImpl(ServerRepository serverRepository, ModelMapper modelMapper) {
////        this.serverRepository = serverRepository;
////        this.modelMapper = modelMapper;
////    }}
////
////    @Override
////    public ServerDTO createServer(ServerDTO serverDTO) {
////        Server server = modelMapper.map(serverDTO, Server.class);
////        server = serverRepository.save(server);
////        return modelMapper.map(server, ServerDTO.class);
////    }
////
////    @Override
////    public ServerDTO getServerById(Long id) {
////        Optional<Server> optionalServer = serverRepository.findById(id);
////        return optionalServer.map(server -> modelMapper.map(server, ServerDTO.class)).orElse(null);
////    }
////
////    @Override
////    public ServerDTO updateServer(Long id, ServerDTO serverDTO) {
////        Optional<Server> optionalServer = serverRepository.findById(id);
////        if (optionalServer.isPresent()) {
////            Server server = optionalServer.get();
////            server.setName(serverDTO.getName());
////            server.setHost(serverDTO.getHost());
////            server.setPort(serverDTO.getPort());
////            serverRepository.save(server);
////            return modelMapper.map(server, ServerDTO.class);
////        } else {
////            return null;
////        }
////    }
////
////    @Override
////    public void deleteServer(Long id) {
////        serverRepository.deleteById(id);
////    }
////
////}
