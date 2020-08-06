package com.example.demo.service;

import com.example.demo.Dao.TestDao;
import com.example.demo.PangDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public List<PangDto> list( ) {
        return testDao.list();
    }

    @Override
    public PangDto detail(int boardNum) {
        return testDao.detail(boardNum);
    }

    @Override
    public void delete(int boardNum) {
        testDao.delete(boardNum);
    }

    @Override
    public void write(PangDto pangDto) {

        testDao.write(pangDto);
    }

    @Override
    public void hit(PangDto pangDto) {

        testDao.hit(pangDto);
    }


}
