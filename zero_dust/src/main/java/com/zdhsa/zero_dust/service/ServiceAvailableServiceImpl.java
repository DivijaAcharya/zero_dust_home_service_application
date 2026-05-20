package com.zdhsa.zero_dust.service;

import com.zdhsa.zero_dust.entity.ServiceEntity;
import com.zdhsa.zero_dust.repository.ServiceAvailableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ServiceAvailableServiceImpl implements ServiceAvailable {

    @Autowired
    ServiceAvailableRepo serviceAvailable;

    @Override
    public ServiceEntity getServiceById(Long id) {
        return serviceAvailable.getServiceEntityById(id);
    }

    @Override
    public ServiceEntity getServiceByName(String serviceName) {
        return serviceAvailable.getServiceEntityByServiceName(serviceName);
    }

    public ServiceEntity save(ServiceEntity service) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setServiceName(service.getServiceName());
        serviceEntity.setDescription(service.getDescription());
        return serviceAvailable.save(serviceEntity);
    }

    public ServiceEntity update(ServiceEntity service) {
        ServiceEntity serviceEntity = new ServiceEntity();
        serviceEntity.setId(service.getId());
        serviceEntity.setServiceName(service.getServiceName());
        serviceEntity.setDescription(service.getDescription());
        return serviceAvailable.save(serviceEntity);
    }

    @Override
    public Boolean deleteServiceById(Long id) {
        try {
           ServiceEntity s = serviceAvailable.getServiceEntityById(id);
           if(s.getId()!=null) {
               serviceAvailable.deleteById(id);
               return true;
           }
           else
           {
               System.out.println("Entity trying to delete does not exist");
               return false;
           }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
