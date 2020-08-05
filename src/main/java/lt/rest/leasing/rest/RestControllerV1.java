package lt.rest.leasing.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class RestControllerV1 {

    @GetMapping("test")
    public String test(){
        return "test";
    }
}
