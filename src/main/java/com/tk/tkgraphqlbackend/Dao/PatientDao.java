package com.tk.tkgraphqlbackend.Dao;

import com.tk.tkgraphqlbackend.Dto.PatientDto;
import com.tk.tkgraphqlbackend.model.Patient;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientDao extends JpaRepository<Patient,Long> {

    @Query(nativeQuery = true, value= "select * from patient_table_new_new ptnn where ptnn.id =?1")
    Patient getPatientById(Integer id);

    @Query(nativeQuery = true, value = "select * from patient_table_new_new ptnn offset ?1 limit ?2")
    List<Patient> getAllPatients(Integer offset, Integer pageSize);
}
