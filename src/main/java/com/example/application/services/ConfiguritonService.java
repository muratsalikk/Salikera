package com.example.application.services;

import com.example.application.data.entity.Configuration;
import com.example.application.data.entity.ConfigurationCategory;
import com.example.application.data.repository.ConfigurationCategoryRepository;
import com.example.application.data.repository.ConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiguritonService {
    private final ConfigurationRepository configurationRepository;
    private final ConfigurationCategoryRepository configurationCategoryRepository;

    public ConfiguritonService(ConfigurationRepository configurationRepository, ConfigurationCategoryRepository configurationCategoryRepository) {
        this.configurationRepository = configurationRepository;
        this.configurationCategoryRepository = configurationCategoryRepository;
    }
    public List<Configuration> findByConfigurationName(String filterText){
        if(filterText == null || filterText.isEmpty()) {
            return configurationRepository.findAll();
        } else {
            return configurationRepository.search(filterText);
        }
    }

    public List<ConfigurationCategory> findAllCategories(){
        return configurationCategoryRepository.findAll();
    }

}
