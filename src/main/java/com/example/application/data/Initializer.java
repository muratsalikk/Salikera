package com.example.application.data;

import com.example.application.data.entity.Configuration;
import com.example.application.data.entity.ConfigurationCategory;
import com.example.application.data.entity.Server;
import com.example.application.data.repository.ConfigurationCategoryRepository;
import com.example.application.data.repository.ConfigurationRepository;
import com.example.application.data.repository.ServerRepository;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
public class Initializer {


    @Bean
    public String loadData(ServerRepository serverRepository, ConfigurationCategoryRepository configurationCategoryRepository, ConfigurationRepository configurationRepository) {
        if (serverRepository.count() != 0L) {
            System.out.println("Using existing configuration");
            return "";
        }
        CreateConfigurationCategoryRepository(configurationCategoryRepository);
        System.out.println("dddddddddddddddd: " + configurationCategoryRepository.count());

        CreateConfigurationRepository(configurationRepository, configurationCategoryRepository);
        CreateServerRepository(serverRepository);



            return "";
    }



    private void CreateConfigurationCategoryRepository(ConfigurationCategoryRepository repo) {
//        ConfigurationCategory configurationCategory = new ConfigurationCategory();
//        configurationCategory.setCategoryName("General");
//        configurationCategory.setId(1L);
//        repo.save(configurationCategory);
//        configurationCategory.setCategoryName("Memory Management");
//        configurationCategory.setId(2L);
//        repo.save(configurationCategory);
//        configurationCategory.setCategoryName("Spilling");
//        configurationCategory.setId(3L);
//        repo.save(configurationCategory);
//        configurationCategory.setCategoryName("Exchange");
//        configurationCategory.setId(4L);
//        repo.save(configurationCategory);
//        configurationCategory.setCategoryName("Task");
//        configurationCategory.setId(5L);
//        repo.save(configurationCategory);
//        configurationCategory.setCategoryName("Node Scheduler");
//        configurationCategory.setId(6L);
//        repo.save(configurationCategory);
//        configurationCategory.setCategoryName("Optimizer");
//        configurationCategory.setId(7L);
//        repo.save(configurationCategory);
//        configurationCategory.setCategoryName("Miscellaneous");
//        configurationCategory.setId(8L);
//        repo.save(configurationCategory);
    }
    private void CreateConfigurationRepository(ConfigurationRepository repo, ConfigurationCategoryRepository configurationCategoryRepository) {
        ConfigurationCategory generalCategory = new ConfigurationCategory();

        List<ConfigurationCategory> categoryList = configurationCategoryRepository.findAll();
        for (ConfigurationCategory category : categoryList ) {
            if (category.getCategoryName().equals("General"))  generalCategory = category;
        }


        Configuration configuration = new Configuration();
        Configuration configuration2 = new Configuration();
        Configuration configuration3 = new Configuration();
        Configuration configuration4 = new Configuration();
        configuration.setConfigurationName("installation-directory");
        configuration.setConfigurationCategory(generalCategory);
        configuration.setcValueType("Path");
        configuration.setcValueAllowed("");
        configuration.setcValueDefault("");
        configuration.setcValue("/hdlog/Presto/presto_0.283");
        configuration.setTimeStamp();
        configuration.setToolTip("Installation directory");
        repo.save(configuration);


        configuration2.setConfigurationName("data-directory");
        configuration2.setConfigurationCategory(generalCategory);
        configuration2.setcValueType("Path");
        configuration2.setcValueAllowed("");
        configuration2.setcValueDefault("");
        configuration2.setcValue("/hdlog/Presto/data");
        configuration2.setTimeStamp();
        configuration2.setToolTip("Data directory for logs and spilling");
        repo.save(configuration2);

        configuration3.setConfigurationName("join-distribution-type");
        configuration3.setConfigurationCategory(generalCategory);
        configuration3.setcValueType("string");
        configuration3.setcValueAllowed("AUTOMATIC, PARTITIONED, BROADCAST");
        configuration3.setcValueDefault("AUTOMATIC");
        configuration3.setcValue("AUTOMATIC");
        configuration3.setTimeStamp();
        configuration3.setToolTip("The type of distributed join to use.");
        repo.save(configuration3);

        configuration4.setConfigurationName("redistribute-writes");
        configuration4.setConfigurationCategory(generalCategory);
        configuration4.setcValueType("boolean");
        configuration4.setcValueAllowed("");
        configuration4.setcValueDefault("true");
        configuration4.setcValue("true");
        configuration4.setTimeStamp();
        configuration4.setToolTip("This property enables redistribution of data before writing.");
        repo.save(configuration4);


    }

    private void CreateServerRepository(ServerRepository repo) {
        Server server = new Server();
        server.setCoordinator(1);
        server.setIp("10.25.207.80");
        server.setNodeId("303030-32jdfks-dfskajf-kdfs");
        server.setHostName("frdapppd");
        server.setUserName("fmsdev");
        server.setCpuCores(48L);
        server.setCpuUsage(17L);
        server.setCpuUsagePresto(9L);
        server.setThreadCount(600L);
        server.setThreadCountPresto(150L);
        server.setMemory(320000L);
        server.setMemoryUsage(290000L);
        server.setMemoryUsagePresto(180000L);
        server.setPrestoBinDirectory("/hdlog/Presto/presto_01");
        server.setPrestoDataDirectory("/hdlog/Presto/data");
        server.setPrestoDataDiskUsage(200L);
        server.setPrestoDataDiskUsagePresto(39384L);
        server.setJavaVersion("1.8_201");
        server.setOSVersion("Redhat Maipo 7.9");
        server.setPrestoVersion("0.280.8");
        server.setLastUpdateTime(System.nanoTime());
        server.setStatus("Running");
        //server.setId(1L);
        repo.save(server);

    }
}
