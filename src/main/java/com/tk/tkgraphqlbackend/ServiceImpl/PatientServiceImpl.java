package com.tk.tkgraphqlbackend.ServiceImpl;

import com.tk.tkgraphqlbackend.Dao.PatientDao;
import com.tk.tkgraphqlbackend.Dto.PatientInputDto;
import com.tk.tkgraphqlbackend.OutputDto.PatientOutputDto;
import com.tk.tkgraphqlbackend.Service.PatientService;
import com.tk.tkgraphqlbackend.model.Patient;
import com.tk.tkgraphqlbackend.response.GenericResponse;
import graphql.kickstart.tools.GraphQLSubscriptionResolver;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static com.tk.tkgraphqlbackend.util.Constants.OFFSET;
import static com.tk.tkgraphqlbackend.util.Constants.PAGE_SIZE;

@Service
@Transactional
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientRepository;

    private final String phoneNumberRegex = "^(\\(\\d{3}\\)|\\d{3})-?\\d{3}-?\\d{4}$";

    private final String emailRegex = "~/(\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,9})/";

    @Override
    public Patient getById(Long id) {
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
            offset = OFFSET;
            pageSize = PAGE_SIZE;
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
        patient.setPatientGender(patientDto.getPatientGender());
        patient.setDataOfBirth(patientDto.getDataOfBirth());
        patient.setAge(patientDto.getAge());
        patient.setCreatedDate(patientDto.getCreatedDate());
        patient.setDrReferral(patientDto.getDrReferral());
        patient.setTotalCost(patientDto.getTotalCost());
        patient.setDiscount(patientDto.getDiscount());
        patient.setPaidAmount(patientDto.getPaidAmount());
        patient.setIsDiscount(patientDto.getIsDiscount());
        if(patientDto.getIsDiscount() == true){
            patient.setDue(patientDto.getTotalCost()-(patientDto.getPaidAmount()+patientDto.getDiscount()));
        }else{
            patient.setDue(patientDto.getTotalCost()-patientDto.getPaidAmount());
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

    @Override
    public Patient updatePatient(PatientInputDto patientInputDto) {
        long startTime = System.currentTimeMillis();
        Patient patient = patientRepository.getPatientById(patientInputDto.getId());
        patient.setFirstName(patientInputDto.getFirstName());
        patient.setLastName(patientInputDto.getLastName());
        patient.setPatientGender(patientInputDto.getPatientGender());
        patient.setDataOfBirth(patientInputDto.getDataOfBirth());
        patient.setAge(patientInputDto.getAge());
        patient.setCreatedDate(patientInputDto.getCreatedDate());
        patient.setDrReferral(patientInputDto.getDrReferral());
        patient.setTotalCost(patientInputDto.getTotalCost());
        patient.setDiscount(patientInputDto.getDiscount());
        patient.setPaidAmount(patientInputDto.getPaidAmount());
        patient.setIsDiscount(patientInputDto.getIsDiscount());
        if(patientInputDto.getIsDiscount() == true){
            patient.setDue(patientInputDto.getTotalCost()-(patientInputDto.getPaidAmount()+patientInputDto.getDiscount()));
        }else{
            patient.setDue(patientInputDto.getTotalCost()-patientInputDto.getPaidAmount());
        }
        if(patientInputDto.getPhoneNumber() != null && patientInputDto.getPhoneNumber()
                .matches(phoneNumberRegex)) {
            patient.setPhoneNumber(patientInputDto.getPhoneNumber());
        }
        if(patientInputDto.getEmailId()!=null && patientInputDto.getEmailId().matches(emailRegex)) {
            patient.setEmailId(patientInputDto.getEmailId());
        }
        patient.setCreatedBy(patient.getCreatedBy());
        patient.setCreatedOn(patient.getCreatedOn());
        patient.setUpdatedBy(patientInputDto.getUpdatedBy());
        patient.setUpdatedOn(String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
        patientRepository.save(patient);
        log.info("<<<<updating new patient {} at {}, Total time taken by the Api is {} ms ", patientInputDto.getFirstName(),
                LocalDateTime.now(), System.currentTimeMillis()-startTime);
        return patient;
    }


    @Override
    public List<Patient> getAllPatientByName(String firstName, Integer offset, Integer pageSize) {
        long startTime = System.currentTimeMillis();
        if(offset == null || offset<0 || pageSize == null || pageSize<1){
            offset = OFFSET;
            pageSize = PAGE_SIZE;
        }
        List<Patient> patientList = patientRepository.getPatientsByName(firstName, offset, pageSize);
        log.info("<<<<get Patient informantion by name {} at {}, Total time taken by the Api is {} ms ", firstName ,
                LocalDateTime.now(), System.currentTimeMillis()-startTime);
        return patientList;
    }

}
