package com.service.management.servicemanagement.service;

import com.service.management.servicemanagement.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceNumberRepository extends JpaRepository<Service, Long> {

}
