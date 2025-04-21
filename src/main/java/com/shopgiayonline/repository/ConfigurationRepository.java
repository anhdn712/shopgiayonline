package com.shopgiayonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopgiayonline.entity.Configuration;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {
}
