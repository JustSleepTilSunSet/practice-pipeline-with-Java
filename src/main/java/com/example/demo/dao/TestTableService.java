package com.example.demo.dao;

import com.example.demo.repository.TestTableRepository;
import com.example.demo.models.TestTable;
import com.example.demo.models.TestTableRepoImpl;
import com.example.demo.vo.StatusObject;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTableService {
    @Autowired
    TestTableRepository testRepo;
    @Autowired
    TestTableRepoImpl testRepoImp;

    public List<TestTable> findAll() {
        return testRepo.findAll();
    }

    public Long getCurrId() {
        return testRepo.getMaxId();
    }

    public StatusObject insert(StatusObject comingData) {
        TestTable insertData = new TestTable();
        Long id = Integer.toUnsignedLong(1);
        if (getCurrId() != null) {
            id = getCurrId() + 1;
        }
        insertData.setMessage(comingData.getMessage());
        insertData.setStatus(comingData.getStatus());
        insertData.setId(id);
        // FIXME: Need to set a DTO.
        testRepo.save(insertData);
        return new StatusObject()
                .setId(Integer.parseInt(id + ""))
                .setMessage(comingData.getMessage())
                .setStatus(comingData.getStatus());
    }

    public void update(StatusObject updatedInfo) {
        // FIXME: Need to set a DTO.
        int queryId = updatedInfo.getId();
        TestTable obj = testRepoImp.findOneById(Long.valueOf(queryId + ""));
        TestTable newOne = new TestTable();
        // TODO: when not found
        String status =  updatedInfo.getStatus().length()>0? updatedInfo.getStatus(): obj.getStatus();
        String messgae = updatedInfo.getMessage().length()>0? updatedInfo.getMessage(): obj.getMessage();
        Long id = Long.valueOf(queryId + "");
        testRepoImp.updateTestObjById(status, messgae, id);
        System.out.println(status + "," + messgae);
        // Long id = Integer.toUnsignedLong(queryId);
        // TestTable originalData = testRepo.findOne(id);
        // System.out.println("before: " + originalData.getMessage());
        // testRepo.setTestInfoById(updatedInfo.getMessage(), updatedInfo.getStatus(),
        // id);
        // TestTable afterData = testRepo.findOne(id);
        // System.out.println("after: " + afterData.getMessage());
        // Long id = Integer.toUnsignedLong(1);
        // if(getCurrId() != null){
        // id = getCurrId()+1;
        // }
        // insertData.setMessage(comingData.getMessage());
        // insertData.setStatus(comingData.getStatus());
        // insertData.setId(id);
        // testRepo.save(insertData);
        return;
    }
}
