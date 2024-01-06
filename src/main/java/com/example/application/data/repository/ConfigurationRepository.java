package com.example.application.data.repository;

import com.example.application.data.entity.Configuration;
import com.example.application.data.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

    @Query("select s from Configuration s " +
            "where lower(s.configurationName) like lower(concat('%', :searchTerm, '%')) " +
            "or lower(s.configurationName) like lower(concat('%', :searchTerm, '%'))")
    List<Configuration> search(@Param("searchTerm") String searchTerm);
}
