package com.example.application.data.repository;

import com.example.application.data.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServerRepository extends JpaRepository<Server, Long>{

    @Query("select s from Server s " +
            "where lower(s.hostName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(s.hostName) like lower(concat('%', :searchTerm, '%'))")

    List<Server> search(@Param("searchTerm") String searchTerm);
}
