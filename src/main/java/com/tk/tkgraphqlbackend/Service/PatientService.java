package com.tk.tkgraphqlbackend.Service;

import com.tk.tkgraphqlbackend.Dto.PatientInputDto;
import com.tk.tkgraphqlbackend.OutputDto.PatientOutputDto;
import com.tk.tkgraphqlbackend.model.Patient;
import com.tk.tkgraphqlbackend.response.GenericResponse;
import java.util.List;

public interface PatientService {
    Patient getById(Long id);
    List<Patient> getAllPatient(Integer offset, Integer pageSize);
    GenericResponse createPatient(PatientInputDto patientDto);
    List<Patient> getAllPatientByName(String firstName, Integer offset, Integer pageSize);

}
