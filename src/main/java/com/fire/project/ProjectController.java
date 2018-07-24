package com.fire.project;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by syj on 2018/7/24.
 *
 * 项目 Controller
 */
@RestController
public class ProjectController {

    @RequestMapping(value = "/project/detail", method = RequestMethod.GET)
    public String detail(@RequestParam String name){
        return name + ": 设计师";
    }
}
