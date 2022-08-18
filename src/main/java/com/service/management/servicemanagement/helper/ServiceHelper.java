package com.service.management.servicemanagement.helper;

import com.service.management.servicemanagement.exception.ExceptionHandler;
import com.service.management.servicemanagement.model.ActivateServiceId;
import com.service.management.servicemanagement.model.Service;
import com.service.management.servicemanagement.service.ServiceNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
import static com.service.management.servicemanagement.constants.Constants.ACTIVATED;
import static com.service.management.servicemanagement.constants.Constants.AVAILABLE;

@Component
public class ServiceHelper {

    @Autowired
    private ServiceNumberRepository repository;

    public List<Service> getAllServiceIds() throws ExceptionHandler {
        try {
            return repository.findAll();
        } catch (Exception ex) {
            throw new ExceptionHandler("500", "Couldn't find service");
        }

    }

    public List<Service> getCustomerServices(String customerId) throws ExceptionHandler {
        try {
            return repository.findAll().stream()
                    .filter(a -> (a.getCustomerId() != null) && a.getCustomerId().equals(customerId))
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            throw new ExceptionHandler("500", "Couldn't find service");
        }
    }


    public Service activateServiceId(ActivateServiceId activateServiceId) throws ExceptionHandler {
        try {
            return repository.findAll().stream()
                    .filter(a -> ((AVAILABLE.equals(a.getStatus())
                            && a.getServiceId().equals(activateServiceId.getServiceId())
                            && a.getCustomerId() == null)))
                    .map(x -> {
                        x.setCustomerId(activateServiceId.getCustomerId());
                        x.setStatus(ACTIVATED);
                        return repository.save(x);
                    }).findFirst()
                    .orElse(null);
        } catch (Exception ex) {
            throw new ExceptionHandler("500", "Couldn't activate service");
        }
    }
}
