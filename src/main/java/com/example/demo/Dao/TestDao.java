package com.example.demo.Dao;

import com.example.demo.PangDto;

import java.util.List;

public interface TestDao {


    public List<PangDto> list();

    public PangDto detail(int boardNum);

    public void delete(int boardNum);

    public void write(PangDto pangDto);

    public void hit(PangDto pangDto);
}
