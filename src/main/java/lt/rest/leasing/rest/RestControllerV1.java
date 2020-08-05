package lt.rest.leasing.rest;

import lt.rest.leasing.dto.ApplyDto;
import lt.rest.leasing.model.LeasingApply;
import lt.rest.leasing.model.Person;
import lt.rest.leasing.model.Vehicle;
import lt.rest.leasing.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class RestControllerV1 {
    ApplyService service;

    @Autowired
    public RestControllerV1(ApplyService service) {
        this.service = service;
    }

    @PostMapping("/apply")
    public ResponseEntity<Map<Object,Object>> addLeasingApply (
            @RequestBody final ApplyDto applyDto) {

        LeasingApply apply=applyDto.toLeasingApply();
        List<Person> list= applyDto.toPersonList();
        Vehicle vehicle=applyDto.toVehicle();
        apply.setFamily(list);
        apply.setVehicle(vehicle);

        service.addLeasingApply(apply);

        Map<Object, Object> response = new HashMap<>();
        response.put("Apply ID",apply.getId());
        response.put("Apply answer",true);
        return ResponseEntity.ok(response);
    }
}
