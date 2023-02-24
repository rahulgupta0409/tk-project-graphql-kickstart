package com.tk.tkgraphqlbackend.Dao;

import com.tk.tkgraphqlbackend.OutputDto.PatientOutputDto;
import com.tk.tkgraphqlbackend.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface PatientDao extends JpaRepository<Patient,Long> {

    @Query(nativeQuery = true, value= "select * from patient_table_new_new ptnn where ptnn.id =?1")
    Patient getPatientById(Long id);

    @Query(nativeQuery = true, value = "select * from patient_table_new_new ptnn offset ?1 limit ?2")
    List<Patient> getAllPatients(Integer offset, Integer pageSize);

    @Query(nativeQuery = true, value = "select * from patient_table_new_new ptnn where ptnn.first_name like %:firstName%  offset :offset  limit :pageSize")
    List<Patient> getPatientsByName(String firstName, Integer offset, Integer pageSize);

//    @Modifying
//    @Query(nativeQuery = true, value = "update patient_table_new_new  set first_name = :firstName last_name = :lastName date_of_birth= :dateOfBirth   where id = :id")
//    public void updatePatient(String firstName, String lastName, String dateOfBirth, Long id);
}
