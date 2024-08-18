package lk.ijse.controller;

import jakarta.servlet.http.HttpServlet;
import lk.ijse.dto.Customer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/path-variable/{id:c\\d{3}+}", headers = "X-Request-Id")
    public String pathVariableWithRegexCustomHeader(@PathVariable("id") String id, @RequestHeader("X-Request-Id") int requestId) {
        return "Demo Controller Running With: " + id + " and Request Id: " + requestId;
    }
    @GetMapping(params = "text-all")
    public String param(){
        return "All are tested";
    }

    @GetMapping(params = "test-all")
    public String params(){
        return "All are tested";
    }

    @PostMapping(params = {"name" , "quantity"})
    public String paramsData(@RequestParam ("name")String param1, @RequestParam ("quantity")String param2){
        return "All are tested"+param1+"  and  "+param2;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String jsonBody() {
        return "Json Body";
    }

    @PostMapping("/dynamic/{value:\\d{2}+}")
    public ResponseEntity<String> dynamicPath(@PathVariable("value") int value){
        if (value % 2 == 0){
            return ResponseEntity.ok("Even Number");
        } else {
            return ResponseEntity.badRequest().body("Odd Number");
        }
    }
    @PostMapping(value = "/multimapparams", params = {"id","desc"})
    public String handleMultiMaps(@RequestParam ("id") String id, @RequestParam ("desc")String desc, @RequestParam MultiValueMap<String,String> params){
        System.out.println(params);
        return "Handle Maps with params "+params;
    }
    @PostMapping(value = "/customer",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String JSONToDTO( @RequestBody Customer customer){
        System.out.println(customer.getId());
        System.out.println(customer.getName());
        System.out.println(customer.getEmail());
        return "Customer Success";
    }
}
