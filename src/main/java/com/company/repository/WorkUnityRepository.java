package com.company.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.company.model.WorkUnity;
@Repository
public interface WorkUnityRepository extends CrudRepository<WorkUnity, Integer> {

}
