//package com.example.adam.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/v1/servers")
//public class ServerController {
//
//    @Autowired
//    private ServerService serverService;
//
//    @GetMapping("")
//    public List<Server> getAllServers() {
//        return serverService.getAllServers();
//    }
//
//    @PostMapping("")
//    public Server createServer(@RequestBody ServerModel serverModel) {
//        Server server = convertToEntity(serverModel);
//        return serverService.createServer(server);
//    }
//
//    @PutMapping("/{id}")
//    public Server updateServer(@PathVariable Long id, @RequestBody ServerModel serverModel) {
//        Server server = convertToEntity(serverModel);
//        server.setId(id);
//        return serverService.updateServer(server);
//    }
//
//    @PatchMapping("/{id}")
//    public Server partialUpdateServer(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
//        return serverService.partialUpdateServer(id, updates);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteServer(@PathVariable Long id) {
//        serverService.deleteServer(id);
//    }
//
//    @GetMapping("/{id}/designs")
//    public List<ServerDesignDTO> getDesignsForServer(@PathVariable Long id) {
//        return serverService.getDesignsForServer(id);
//    }
//
//    @PostMapping("/{id}/designs")
//    public void addServerToDesign(@PathVariable Long id, @RequestBody ServerDesignModel serverDesignModel) {
//        ServerDesign serverDesign = convertToEntity(serverDesignModel);
//        serverDesign.setServerId(id);
//        serverService.addServerToDesign(serverDesign);
//    }
//
//    @DeleteMapping("/{id}/designs/{designId}")
//    public void removeServerFromDesign(@PathVariable Long id, @PathVariable Long designId) {
//        serverService.removeServerFromDesign(id, designId);
//    }
//
//    private Server convertToEntity(ServerModel serverModel) {
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(serverModel, Server.class);
//    }
//
//    private ServerDesign convertToEntity(ServerDesignModel serverDesignModel) {
//        ModelMapper modelMapper = new ModelMapper();
//        return modelMapper.map(serverDesignModel, ServerDesign.class);
//    }
//}
