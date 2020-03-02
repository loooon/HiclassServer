package site.hiclass.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping(value = {"", "index"})
    public String test() {
        return "hello, I am home";
    }
}
