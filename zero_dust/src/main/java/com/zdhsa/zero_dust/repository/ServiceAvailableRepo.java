package com.zdhsa.zero_dust.repository;

import com.zdhsa.zero_dust.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceAvailableRepo  extends JpaRepository<ServiceEntity, Long> {

    ServiceEntity getServiceEntityById(Long id);

    ServiceEntity getServiceEntityByServiceName(String serviceName);

}
