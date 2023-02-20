package com.tk.tkgraphqlbackend.Service;

import com.tk.tkgraphqlbackend.Dto.ReportDispatchDto;
import com.tk.tkgraphqlbackend.model.ReportDispatch;
import com.tk.tkgraphqlbackend.response.GenericResponse;

import java.util.List;

public interface ReportDispatchService {
    GenericResponse addDispatchReportTemp(ReportDispatchDto reportDispatchDto);

    List<ReportDispatch> getAllDispatched(String firstName, String phoneNumber);

    ReportDispatch getAllDispatchedReportById(Long id);
}
