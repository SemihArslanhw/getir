package com.getir.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getir.entities.concretes.SuperCategory;

@Repository
public interface SuperCategoryDao extends JpaRepository<SuperCategory, Integer>{

}
