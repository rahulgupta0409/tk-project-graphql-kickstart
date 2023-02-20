package com.tk.tkgraphqlbackend.Service;

import com.tk.tkgraphqlbackend.Dto.LabTestDto;
import com.tk.tkgraphqlbackend.model.LabTest;
import com.tk.tkgraphqlbackend.response.GenericResponse;

import java.util.List;

public interface LabTestService {

    GenericResponse createLabTest(LabTestDto labTestDto);

    List<LabTest> getAllTests(Integer offset, Integer pageSize);
}
