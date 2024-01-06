package com.example.application.data.repository;

import com.example.application.data.entity.ConfigurationCategory;
import com.example.application.data.entity.Server;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ConfigurationCategoryRepository extends JpaRepository<ConfigurationCategory, Long> {

}