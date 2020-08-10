package com.example.demo.Dao;

import com.example.demo.PageNationDto;
import com.example.demo.PangDto;
import com.example.demo.SearchValue;

import java.util.List;

public interface TestDao {


    public List<PangDto> list(SearchValue sv);

    public PangDto detail(int boardNum);

    public void delete(int boardNum);

    public void write(PangDto pangDto);

    public void hit(PangDto pangDto);

    public PageNationDto boardPageNation(SearchValue sv);

    public void modify(PangDto pangDto);

    public List<PangDto> searchList(SearchValue sv);

    public PageNationDto searchListPageNation(SearchValue sv);
}
