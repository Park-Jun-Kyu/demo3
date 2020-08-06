package com.example.demo;

import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestControlelr {

    @Autowired
    TestService testService;


    @RequestMapping("list")
    public String List(Model model ){
         model.addAttribute("list", testService.list());

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
    public String write(Model model, PangDto pangDto){
        model.addAttribute("boardNum", pangDto.getBoardNum());
        testService.write(pangDto);

        return "redirect:/list";
    }


}
