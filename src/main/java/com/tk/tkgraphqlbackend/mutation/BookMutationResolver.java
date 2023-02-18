package com.tk.tkgraphqlbackend.mutation;

import com.tk.tkgraphqlbackend.Dto.LabTestDto;
import com.tk.tkgraphqlbackend.Dto.PatientInputDto;
import com.tk.tkgraphqlbackend.Service.LabTestService;
import com.tk.tkgraphqlbackend.Service.PatientService;
import com.tk.tkgraphqlbackend.model.Book;
import com.tk.tkgraphqlbackend.model.BookWrapper;
import com.tk.tkgraphqlbackend.model.Patient;
import com.tk.tkgraphqlbackend.response.GenericResponse;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class BookMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private PatientService patientService;

    @Autowired
    private LabTestService labTestService;

    public Book createBook(BookWrapper bookWrapper){
        return new Book(bookWrapper.getTitle(), bookWrapper.getIsbn());
    }

    public GenericResponse createPatient(PatientInputDto patientDto){
        return patientService.createPatient(patientDto);
    }

    GenericResponse createLabTest(LabTestDto labTestDto){
        return labTestService.createLabTest(labTestDto);
    }
}
