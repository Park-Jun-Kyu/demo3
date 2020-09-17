package com.example.demo;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class TestControlelr {

    @Autowired
    TestService testService;


    @RequestMapping("list")
    public String List(Model model,SearchValue sv){
//        PageNationDto pDto = testService.boardPageNation(sv);
//        List<PangDto>list = testService.list(sv);
        List<PangDto>list = testService.searchList(sv);
        PageNationDto pDto =  testService.searchListPageNation(sv);

        model.addAttribute("list",list);
        model.addAttribute("pDto",pDto);
        model.addAttribute("sv",sv);

        return "Test/List";
    }

    @RequestMapping("detail")
    public String detail(Model model,int boardNum,PangDto pangDto){
        model.addAttribute("detail",testService.detail(boardNum));
        testService.hit(pangDto);

        return "Test/Detail";
    }

    @RequestMapping("delete")
    public String delete(int boardNum){

        testService.delete(boardNum);

        return "redirect:/list";
    }

    @RequestMapping("writeView")
    public String writeView(){

        return "Test/writeView";
    }

    @RequestMapping("write")
    public String write(Model model, PangDto pangDto,List<MultipartFile> multi) throws Exception {
        model.addAttribute("boardNum", pangDto.getBoardNum());
        testService.write(pangDto,multi);

        return "redirect:/list";
    }

    @RequestMapping("modifyView")
    public String modifyView(Model model,PangDto pangDto){

        model.addAttribute("detail",testService.detail(pangDto.boardNum));

        return "Test/modify";
    }

    @RequestMapping("modify")
    public String modify(Model model,PangDto pangDto){

        testService.modify(pangDto);

        return "redirect:/detail?boardNum=" + pangDto.boardNum;
    }

    @RequestMapping("windowopen")
    public String windowopen(){

        return "Test/windowopen";
    }



}
