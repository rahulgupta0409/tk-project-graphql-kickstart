package com.tk.tkgraphqlbackend.Dao;

import com.tk.tkgraphqlbackend.model.LabTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTestDao extends JpaRepository<LabTest,Long> {

}
