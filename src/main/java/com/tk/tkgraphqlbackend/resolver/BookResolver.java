package com.tk.tkgraphqlbackend.resolver;

import com.tk.tkgraphqlbackend.Dto.PatientDto;
import com.tk.tkgraphqlbackend.Service.PatientService;
import com.tk.tkgraphqlbackend.model.Book;
import com.tk.tkgraphqlbackend.model.Patient;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookResolver implements GraphQLQueryResolver {

    @Autowired
    private PatientService patientService;

    public Book getBook(String isbn){
        return new Book("Learn Graphql", "39842989824");
    }

    public Patient getById(Integer id){
        return patientService.getById(id);
    }

    public List<Patient> getAllPatient(Integer offset, Integer pageSize){
        return patientService.getAllPatient(offset, pageSize);
    }


}
