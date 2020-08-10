package com.example.demo.service;

import com.example.demo.Dao.TestDao;
import com.example.demo.PageNationDto;
import com.example.demo.PangDto;
import com.example.demo.SearchValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestDao testDao;

    @Override
    public List<PangDto> list(SearchValue sv) {
        return testDao.list(sv);
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

    @Override
    public PageNationDto boardPageNation(SearchValue sv) {
        PageNationDto pDto = testDao.boardPageNation(sv);
        pDto.setPage_cnt(pDto.getListCnt()); // 페이지 수 저장
        pDto.setRange_cnt(pDto.getPage_cnt()); // 블럭 수 저장
        pDto.setCurPage(sv.getCurPage()); // 현재 페이지 위치
        pDto.setCur_range(sv.getCurPage()); // 현재 블럭 위치
        pDto.prevnext(sv.getCurPage()); // 이전 블럭, 다음 블럭 설정
        System.out.println("게시글 갯수 : " + pDto.getListCnt());
        System.out.println("페이지 갯수 : " + pDto.getPage_cnt());
        System.out.println("블록 갯수 :  " + pDto.getCur_range());
        System.out.println("현재 블록 끝 페이지 : " + pDto.getEnd_page());
        System.out.println("게시글에 담을 갯수 :"+pDto.getPage_size());
        pDto.setStart_page(pDto.getCur_range(), pDto.getRange_size()); // 현재 블럭 시작 페이지
        pDto.setEnd_page(pDto.getCur_range(), pDto.getRange_cnt()); // 현재 블럭 끝
        return pDto;
    }

    @Override
    public void modify(PangDto pangDto) {

        testDao.modify(pangDto);
    }

    @Override
    public List<PangDto> searchList(SearchValue sv) {
        return testDao.searchList(sv);
    }

    @Override
    public PageNationDto searchListPageNation(SearchValue sv) {
        PageNationDto pDto = testDao.searchListPageNation(sv);
        pDto.setPage_cnt(pDto.getListCnt()); // 페이지 수 저장
        pDto.setRange_cnt(pDto.getPage_cnt()); // 블럭 수 저장
        pDto.setCurPage(sv.getCurPage()); // 현재 페이지 위치
        pDto.setCur_range(sv.getCurPage()); // 현재 블럭 위치
        pDto.prevnext(sv.getCurPage()); // 이전 블럭, 다음 블럭 설정
        System.out.println("게시글 갯수 : " + pDto.getListCnt());
        System.out.println("페이지 갯수 : " + pDto.getPage_cnt());
        System.out.println("블록 갯수 :  " + pDto.getCur_range());
        System.out.println("현재 블록 끝 페이지 : " + pDto.getEnd_page());
        System.out.println("게시글에 담을 갯수 :"+pDto.getPage_size());
        pDto.setStart_page(pDto.getCur_range(), pDto.getRange_size()); // 현재 블럭 시작 페이지
        pDto.setEnd_page(pDto.getCur_range(), pDto.getRange_cnt()); // 현재 블럭 끝
        return pDto;
    }


}
