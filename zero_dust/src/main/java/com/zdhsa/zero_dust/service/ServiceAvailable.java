package com.zdhsa.zero_dust.service;

import com.zdhsa.zero_dust.entity.ServiceEntity;
import com.zdhsa.zero_dust.repository.ServiceAvailableRepo;

import java.util.List;

public interface ServiceAvailable {
    ServiceEntity getServiceById(Long id);
    ServiceEntity getServiceByName(String serviceName);
    ServiceEntity save(ServiceEntity service);
    ServiceEntity update(ServiceEntity service);

    Boolean deleteServiceById(Long id);
}
