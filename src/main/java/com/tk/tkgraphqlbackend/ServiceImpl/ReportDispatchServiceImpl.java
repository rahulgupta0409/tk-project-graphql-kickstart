package com.tk.tkgraphqlbackend.ServiceImpl;

import com.tk.tkgraphqlbackend.Dao.ReportDispatchDao;
import com.tk.tkgraphqlbackend.Dto.ReportDispatchDto;
import com.tk.tkgraphqlbackend.Service.ReportDispatchService;
import com.tk.tkgraphqlbackend.model.ReportDispatch;
import com.tk.tkgraphqlbackend.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ReportDispatchServiceImpl implements ReportDispatchService {
    @Autowired
    private ReportDispatchDao reportDispatchDao;

    @Override
    public GenericResponse addDispatchReportTemp(ReportDispatchDto reportDispatchDto) {
        ReportDispatch reportDispatch = new ReportDispatch();
        reportDispatch.setFirstName(reportDispatchDto.getFirstName());
        reportDispatch.setPhoneNumber(reportDispatchDto.getPhoneNumber());
        reportDispatch.setIsDispatch(reportDispatchDto.getIsDispatch());
        reportDispatchDao.save(reportDispatch);
        return new GenericResponse("Success", "Successfully Created Report Dispatch",
                null, null);
    }

    @Override
    public List<ReportDispatch> getAllDispatched(String firstName, String phoneNumber) {
        List<ReportDispatch> reportDispatchList = reportDispatchDao.
                getAllByNamePhoneNumber(firstName, phoneNumber);
        return reportDispatchList;
    }

    @Override
    public ReportDispatch getAllDispatchedReportById(Long id) {
        long startTime = System.currentTimeMillis();
        ReportDispatch reportDispatch = new ReportDispatch();
        reportDispatch = reportDispatchDao.getById(id);
        log.info("<<<<get dispatched report by id {} , Total time taken by the Api {} ms",
                id, System.currentTimeMillis()-startTime);
        return reportDispatch;
    }
}
