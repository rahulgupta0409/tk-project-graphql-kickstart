package com.tk.tkgraphqlbackend.Dao;

import com.tk.tkgraphqlbackend.model.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabTestDao extends JpaRepository<LabTest,Long> {

    @Query(nativeQuery = true, value = "select * from lab_test_new ltn offset ?1 limit ?2")
    List<LabTest> getAllLabTests(Integer offset, Integer pageSize);


}
