package com.tk.tkgraphqlbackend.ServiceImpl;

import com.tk.tkgraphqlbackend.Dao.LabTestDao;
import com.tk.tkgraphqlbackend.Dto.LabTestDto;
import com.tk.tkgraphqlbackend.Service.LabTestService;
import com.tk.tkgraphqlbackend.model.LabTest;
import com.tk.tkgraphqlbackend.response.GenericResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@Slf4j
public class LabTestServiceImpl implements LabTestService {
    @Autowired
    private LabTestDao labTestDao;

    @Override
    public GenericResponse createLabTest(LabTestDto labTestDto) {
        long startTime = System.currentTimeMillis();
        LabTest labTest = new LabTest();
        labTest.setTestName(labTestDto.getTestName());
        labTest.setLabCost(labTestDto.getLabCost());
        labTest.setTestCost(labTestDto.getTestCost());
        labTestDao.save(labTest);
        log.info("<<<<create test, Total time taken by the Api {} ms",
                System.currentTimeMillis()-startTime);
        return new GenericResponse("Success", "Successfully created Lab test",
                null, null);
    }

    @Override
    public List<LabTest> getAllTests(Integer offset, Integer pageSize) {
        long startTime = System.currentTimeMillis();
        if(offset == null || offset<0 || pageSize == null || pageSize<1){
            offset = 0;
            pageSize = 1000;
        }
        List<LabTest> labTestList = new ArrayList<>();
        labTestList = labTestDao.getAllLabTests(offset, pageSize);
        log.info("<<<<get all Lab Test Record , Total time taken by the Api {} ms",
                System.currentTimeMillis()-startTime);
        return labTestList;
    }
}
