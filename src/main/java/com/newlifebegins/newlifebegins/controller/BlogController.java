package com.newlifebegins.newlifebegins.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * blog控制器
 * @auth wangwei
 * @time 2019/12/7
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
    @GetMapping
    public String listBlogs(@RequestParam(value = "order",required = false,defaultValue = "new") String order,@RequestParam(value = "keyword",required = false,defaultValue = "") Long keyword) {
        System.out.println("order:"+order+";keyword:"+keyword);
        return "redirect:/index?order="+order+"&keyword="+keyword;
    }
}
