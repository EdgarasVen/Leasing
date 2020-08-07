package lt.rest.leasing.rest;

import lt.rest.leasing.dto.ApplyDto;
import lt.rest.leasing.model.LeasingApply;
import lt.rest.leasing.model.Person;
import lt.rest.leasing.model.Vehicle;
import lt.rest.leasing.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class ControllerV1 implements Controller {
    ApplyService service;

    @Autowired
    public ControllerV1(ApplyService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/apply")
    public ResponseEntity<Map<Object,Object>> addLeasingApply(
            @RequestBody final ApplyDto applyDto
    ) {
        LeasingApply apply = applyDto.toLeasingApply();
        List<Person> list = applyDto.toPersonList();
        Vehicle vehicle=applyDto.toVehicle();
        apply.setFamily(list);
        apply.setVehicle(vehicle);

        service.addLeasingApply(apply);

        Map<Object, Object> response = new HashMap<>();
        response.put("Apply ID",apply.getId());
        response.put("Apply answer",
                service.checkLeasingResultById(apply.getId()));
        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping("/apply/{id}")
    public ResponseEntity<Map<Object,Object>> getApplyAnswerById(
            @PathVariable Long id
    ) {
        boolean answer = service.checkLeasingResultById(id);
        Map<Object, Object> response = new HashMap<>();
        response.put("Apply ID",id);
        response.put("Apply answer", answer);
        return  ResponseEntity.ok(response);
    }

}
