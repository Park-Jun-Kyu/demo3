package com.example.demo.service;

import com.example.demo.PageNationDto;
import com.example.demo.PangDto;
import com.example.demo.SearchValue;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TestService {

    public List<PangDto> list(SearchValue sv);

    public PangDto detail(int boardNum);

    public void delete(int boardNum);

    public void write(PangDto pangDto, List<MultipartFile> multi) throws Exception;

    public void hit(PangDto pangDto);

    public PageNationDto boardPageNation(SearchValue sv);

    public void modify(PangDto pangDto);

    public List<PangDto> searchList(SearchValue sv);

    public PageNationDto searchListPageNation(SearchValue sv);
}
