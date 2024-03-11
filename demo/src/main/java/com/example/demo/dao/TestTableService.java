package com.example.demo.dao;

import com.example.demo.repository.TestTableRepository;
import com.example.demo.models.TestTable;
import com.example.demo.vo.StatusObject;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestTableService {
    @Autowired
    TestTableRepository testRepo;

    public List<TestTable> findAll() {
        return testRepo.findAll();
    }

    public Long getCurrId() {
        return testRepo.getMaxId();
    }

    public void insert(StatusObject comingData) {
        TestTable insertData = new TestTable();
        Long id = Integer.toUnsignedLong(1);
        if(getCurrId() != null){
            id = getCurrId()+1;
        }
        insertData.setMessage(comingData.getMessage());
        insertData.setStatus(comingData.getStatus());
        insertData.setId(id);
        testRepo.save(insertData);
        return;
    }
}
