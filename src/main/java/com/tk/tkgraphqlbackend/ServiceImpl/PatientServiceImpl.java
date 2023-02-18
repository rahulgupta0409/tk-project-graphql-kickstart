package com.tk.tkgraphqlbackend.ServiceImpl;

import com.tk.tkgraphqlbackend.Dao.PatientDao;
import com.tk.tkgraphqlbackend.Dto.PatientInputDto;
import com.tk.tkgraphqlbackend.Service.PatientService;
import com.tk.tkgraphqlbackend.model.Patient;
import com.tk.tkgraphqlbackend.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientRepository;

    private final String phoneNumberRegex = "^(\\(\\d{3}\\)|\\d{3})-?\\d{3}-?\\d{4}$";

    private final String emailRegex = "~/(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,9})/";

    @Override
    public Patient getById(Integer id) {
        long startTime = System.currentTimeMillis();
        Patient patient = new Patient();
        patient = patientRepository.getPatientById(id);
        System.out.println(patient);
        log.info("<<<<get the Patient Record by Id {}, Total time taken by the Api {} ms", id,
                System.currentTimeMillis()-startTime);
        return patient;
    }

    @Override
    public List<Patient> getAllPatient(Integer offset, Integer pageSize) {
        long startTime = System.currentTimeMillis();
        if(offset == null || offset<0 || pageSize == null || pageSize<1){
            offset = 0;
            pageSize = 1000;
        }
        List<Patient> patientList = new ArrayList<>();
        patientList = patientRepository.getAllPatients(offset, pageSize);
        log.info("<<<<get all Patient Record , Total time taken by the Api {} ms",
                System.currentTimeMillis()-startTime);
        return patientList;
    }

    @Override
    public GenericResponse createPatient(PatientInputDto patientDto) {
        long startTime = System.currentTimeMillis();
        Patient patient = new Patient();
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setDataOfBirth(patientDto.getDataOfBirth());
        patient.setAge(patientDto.getAge());
        patient.setCreatedDate(patientDto.getCreatedDate());
        patient.setDrReferral(patientDto.getDrReferral());
        patient.setTotalCost(patientDto.getTotalCost());
        patient.setIsDue(patientDto.getIsDue());
        if(patientDto.getIsDue() == true){
            patient.setDue(patientDto.getDue());
            patient.setDiscount(patientDto.getDiscount());
        }
        if(patientDto.getPhoneNumber() != null && patientDto.getPhoneNumber()
                .matches(phoneNumberRegex)) {
            patient.setPhoneNumber(patientDto.getPhoneNumber());
        }
        if(patientDto.getEmailId()!=null && patientDto.getEmailId().matches(emailRegex)) {
            patient.setEmailId(patientDto.getEmailId());
        }
        patient.setCreatedBy(patientDto.getCreatedBy());
        patient.setCreatedOn(String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
        patientRepository.save(patient);
        log.info("<<<<creating new patient {} at {}, Total time taken by the Api is {} ms ", patientDto.getFirstName(),
                LocalDateTime.now(), System.currentTimeMillis()-startTime);
        return new GenericResponse("SUCCESS","Successfully created",null,null);
    }
}
