package com.service.management.servicemanagement;

import com.service.management.servicemanagement.model.Service;
import com.service.management.servicemanagement.service.ServiceNumberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServiceManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(ServiceNumberRepository serviceRepo) {
        return args -> {
            serviceRepo.save(new Service("0426017701", "Actived", "2050878561"));
            serviceRepo.save(new Service("0426017702", "Actived", "2050878561"));
            serviceRepo.save(new Service("0426017703", "Actived", "2050878562"));
            serviceRepo.save(new Service("0426017704", "Actived", "2050878562"));
            serviceRepo.save(new Service("0426017705", "Available", null));
            serviceRepo.save(new Service("0426017706", "Available", null));
            serviceRepo.save(new Service("0426017707", "Available", null));
            serviceRepo.save(new Service("0426017708", "Reserved", null));
        };
    }

}
