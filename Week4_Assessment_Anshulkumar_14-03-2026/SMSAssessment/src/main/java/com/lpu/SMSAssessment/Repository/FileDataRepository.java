package com.lpu.SMSAssessment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.SMSAssessment.Entity.FileData;

public interface FileDataRepository extends JpaRepository<FileData, Long>{
	
}
