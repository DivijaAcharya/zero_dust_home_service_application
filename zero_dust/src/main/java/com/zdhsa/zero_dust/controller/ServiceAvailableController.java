package com.zdhsa.zero_dust.controller;


import com.zdhsa.zero_dust.ResponseHandler.ResponseHandler;
import com.zdhsa.zero_dust.entity.ServiceEntity;
import com.zdhsa.zero_dust.service.ServiceAvailableServiceImpl;
import jakarta.websocket.server.PathParam;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ServiceAvailable",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)

public class ServiceAvailableController {

    @Autowired
    ServiceAvailableServiceImpl ServiceAvailable;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getServiceEntityById(@PathVariable("id") Long id) throws Exception {
        try {
            ServiceEntity service = ServiceAvailable.getServiceById(id);
            return getObjectResponseEntity(service);
        } catch (Exception e) {
            throw new Exception("something went wrong");
        }
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ServiceEntity createService(@RequestBody ServiceEntity services) {
        return ServiceAvailable.save(services);
    }

    @PutMapping("/")
    public ServiceEntity updateService(@RequestBody ServiceEntity services) {
        return ServiceAvailable.update(services);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteServiceById(@PathVariable("id") Long id) {
        return ServiceAvailable.deleteServiceById(id);
    }

    private static @NonNull ResponseEntity<Object> getObjectResponseEntity(ServiceEntity service) {
        if (service != null) {
            return ResponseHandler.generateResponse("Successfull !", HttpStatus.OK, service, service.getServiceName().length());
        } else {
            return ResponseHandler.generateResponse("Entity trying to access does not exist", HttpStatus.BAD_REQUEST, null, 0);
        }
    }

}
