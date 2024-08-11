package lk.ijse.controller;

import jakarta.servlet.http.HttpServlet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/demo")
public class DemoController{
    @GetMapping(value = "/health/{name}")
    public String healthCheck(@PathVariable("name")String name){
        return "DemoController run Prefectiy  :"+name;

    }

}
