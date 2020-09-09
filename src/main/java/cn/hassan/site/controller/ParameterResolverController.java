package cn.hassan.site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: hassan
 * Date: 2020/9/9 22:25
 * Description:
 */
@Controller
@RequestMapping("parameter")
public class ParameterResolverController {

    @RequestMapping("requestOne")
    public String one(Integer number) {
        System.out.println(number);
        return "success";
    }
}
