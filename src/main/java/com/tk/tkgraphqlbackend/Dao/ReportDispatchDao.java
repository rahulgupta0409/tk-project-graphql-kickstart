package com.tk.tkgraphqlbackend.Dao;

import com.tk.tkgraphqlbackend.model.ReportDispatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportDispatchDao extends JpaRepository<ReportDispatch,Long> {

    @Query(nativeQuery = true, value = "select *  from report_dispatch rd where rd.first_name like %:firstName% and  rd.phone_number like %:phoneNumber%")
    List<ReportDispatch> getAllByNamePhoneNumber(String firstName, String phoneNumber);

    @Query(nativeQuery = true, value = "select * from report_dispatch rd where rd.id =?1")
    ReportDispatch getById(Long id);

}
