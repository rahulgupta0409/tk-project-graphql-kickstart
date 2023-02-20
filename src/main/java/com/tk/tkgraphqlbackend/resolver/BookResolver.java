package com.tk.tkgraphqlbackend.resolver;

import com.tk.tkgraphqlbackend.Service.LabTestService;
import com.tk.tkgraphqlbackend.Service.PatientService;
import com.tk.tkgraphqlbackend.Service.ReportDispatchService;
import com.tk.tkgraphqlbackend.model.Book;
import com.tk.tkgraphqlbackend.model.LabTest;
import com.tk.tkgraphqlbackend.model.Patient;
import com.tk.tkgraphqlbackend.model.ReportDispatch;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class BookResolver implements GraphQLQueryResolver {

    @Autowired
    private PatientService patientService;

    @Autowired
    private LabTestService labTestService;

    @Autowired
    private ReportDispatchService reportDispatchService;

    public Book getBook(String isbn){
        log.info("<<<<Default query Run");
        return new Book("Learn Graphql", "39842989824");
    }

    public Patient getById(Integer id){
        return patientService.getById(id);
    }

    public List<Patient> getAllPatient(Integer offset, Integer pageSize){
        return patientService.getAllPatient(offset, pageSize);
    }

    public List<LabTest> getAllTests(Integer offset, Integer pageSize){
        return labTestService.getAllTests(offset, pageSize);
    }

    public List<ReportDispatch> getAllDispatched(String firstName, String phoneNumber){
        return reportDispatchService.getAllDispatched(firstName, phoneNumber);
    }

}
