package com.gl.companyShare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gl.companyShare.bean.CompanyShare;

@Repository
public interface CompanySharerepository extends JpaRepository<CompanyShare, Long> {
	@Query("select max(companyId) from CompanyShare  ")
	public Long findMaxCompanyId();
}

