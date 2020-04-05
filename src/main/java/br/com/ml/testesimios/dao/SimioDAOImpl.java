package br.com.ml.testesimios.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ml.testesimios.model.Simian;

@Repository
@Transactional
public interface SimioDAOImpl extends JpaRepository<Simian, Long> {
	
	@Query("select count(*) from Simian where isSimian = 'S'")
	public Long getTotalSimios();
	
	@Query("select count(*) from Simian where isSimian = 'N'")
	public Long getTotalHumanos();
}
