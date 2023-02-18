package com.tk.tkgraphqlbackend.Service;

import com.tk.tkgraphqlbackend.Dto.LabTestDto;
import com.tk.tkgraphqlbackend.response.GenericResponse;

public interface LabTestService {

    GenericResponse createLabTest(LabTestDto labTestDto);
}
