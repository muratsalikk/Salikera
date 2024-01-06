package com.example.application.services;

import com.example.application.data.entity.Server;
import com.example.application.data.repository.ServerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {
    private final ServerRepository serverRepository;

    public ServerService(ServerRepository server) {
        this.serverRepository = server;
    }
    public List<Server> findByHostName(String filterText){
        if(filterText == null || filterText.isEmpty()) {
            return serverRepository.findAll();
        } else {
            return serverRepository.search(filterText);
        }
    }

    public long countServers() {
        return serverRepository.count();
    }

    public void deleteServer(Server server) {
        serverRepository.delete(server);
    }

    public void saveServer(Server server){
        if (server == null) {
            System.out.println("Server is null");
            return;
        }
        serverRepository.save(server);
    }
}
