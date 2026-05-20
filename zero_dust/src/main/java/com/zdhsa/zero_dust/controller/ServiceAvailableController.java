package com.zdhsa.zero_dust.controller;


import com.zdhsa.zero_dust.entity.ServiceEntity;
import com.zdhsa.zero_dust.service.ServiceAvailableServiceImpl;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ServiceAvailable")
public class ServiceAvailableController {

    @Autowired
    ServiceAvailableServiceImpl ServiceAvailable;

    @GetMapping("/{id}")
    public ServiceEntity getServiceEntityById(@PathVariable("id") Long id){
       return ServiceAvailable.getServiceById(id);
    }



    @PostMapping(consumes = "application/json", produces = "application/json")
    public ServiceEntity createService(@RequestBody ServiceEntity services){
        return ServiceAvailable.save(services);
    }

    @PutMapping("/")
    public ServiceEntity updateService(@RequestBody ServiceEntity services){
        return ServiceAvailable.update(services);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteServiceById(@PathVariable("id") Long id){
        return ServiceAvailable.deleteServiceById(id);
    }

}
