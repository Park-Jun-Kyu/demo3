package com.example.demo.service;

import com.example.demo.PangDto;

import java.util.List;

public interface TestService {

    public List<PangDto> list();

    public PangDto detail(int boardNum);

    public void delete(int boardNum);

    public void write(PangDto pangDto);

    public void hit(PangDto pangDto);

}
