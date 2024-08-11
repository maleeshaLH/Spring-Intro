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

    @GetMapping(value = "/patternRegex/{id:C\\d{3}}")
    public String pathvariableWithRegex(@PathVariable("id") String id) {
        return "DemoController run perfectly with :"+id;
    }
    @GetMapping(params = "text-all")
    public String param(){
        return "All are tested";
    }

}
