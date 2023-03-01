package com.example.adam.controller;

import com.example.adam.dto.ServerDTO;
import com.example.adam.entity.Server;
import com.example.adam.repository.ServerRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1")
public class ServerController {

    private final ServerRepository serverRepository;
    private final ModelMapper modelMapper;

    public ServerController(ServerRepository serverRepository, ModelMapper modelMapper) {
        this.serverRepository = serverRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/servers")
    @Operation(summary = "Get all servers", description = "Returns all servers")
    public ResponseEntity<List<ServerDTO>> getAllServers() {
        List<Server> servers = serverRepository.findAll();
        List<ServerDTO> serverDTOs = servers.stream().map(this::convertToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(serverDTOs, HttpStatus.OK);
    }

    @GetMapping("/servers/{id}")
    @Operation(summary = "Get server by ID", description = "Returns a server with the specified ID.")
    public ResponseEntity<ServerDTO> getServerById(@PathVariable("id") Long id) {
        Optional<Server> serverOptional = serverRepository.findById(id);
        if (serverOptional.isPresent()) {
            Server server = serverOptional.get();
            return new ResponseEntity<>(convertToDTO(server), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/servers")
    @Operation(summary = "Create a server", description = "Creates a new server.")
    public ResponseEntity<ServerDTO> createServer(@RequestBody @Valid ServerDTO serverDTO) {
        Server server = convertToEntity(serverDTO);
        Server savedServer = serverRepository.save(server);
        return new ResponseEntity<>(convertToDTO(savedServer), HttpStatus.CREATED);
    }

    @PutMapping("/servers/{id}")
    @Operation(summary = "Updates the server", description = "Updates the server PUT full body required")
    public ResponseEntity<ServerDTO> updateServer(@PathVariable("id") Long id, @RequestBody ServerDTO serverDTO) {
        Optional<Server> serverOptional = serverRepository.findById(id);
        if (serverOptional.isPresent()) {
            Server existingServer = serverOptional.get();
            // Update the existing server with the values from the updated server
            modelMapper.map(serverDTO, existingServer);
            Server updatedServer = serverRepository.save(existingServer);
            return new ResponseEntity<>(convertToDTO(updatedServer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/servers/{id}")
    @Operation(summary = "Deletes the server", description = "Deletes the server with the specified ID.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteServer(@PathVariable("id") Long id) {
        serverRepository.deleteById(id);
    }

    private ServerDTO convertToDTO(Server server) {
        return modelMapper.map(server, ServerDTO.class);
    }

    private Server convertToEntity(ServerDTO serverDTO) {
        return modelMapper.map(serverDTO, Server.class);
    }
}
