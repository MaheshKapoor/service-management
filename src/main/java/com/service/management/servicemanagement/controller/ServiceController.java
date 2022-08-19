package com.service.management.servicemanagement.controller;


import com.service.management.servicemanagement.exception.ExceptionHandler;
import com.service.management.servicemanagement.helper.ServiceHelper;
import com.service.management.servicemanagement.model.ActivateServiceId;
import com.service.management.servicemanagement.model.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@RestController
public class ServiceController {

    @Autowired
    ServiceHelper serviceHelper;

    // Get all service numbers
    @GetMapping("/serviceIds")
    List<Service> getServiceIds() throws ExceptionHandler {

        return serviceHelper.getAllServiceIds();
    }

    // Get all service numbers for a customer
    @GetMapping("/customerServiceIds/{customerId}")
    List<Service> getCustomerServices(@PathVariable @NotBlank @Size(min=10 , max = 10) String customerId) throws ExceptionHandler {

        return serviceHelper.getCustomerServices(customerId);
    }

    // Activate a Service for a customer
    @PutMapping("/activateServiceId")
    Service serviceActivation(@RequestBody @Valid ActivateServiceId activateServiceId) throws ExceptionHandler {

        return serviceHelper.activateServiceId(activateServiceId);
    }

}
