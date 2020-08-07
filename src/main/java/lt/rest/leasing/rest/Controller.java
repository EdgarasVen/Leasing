package lt.rest.leasing.rest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lt.rest.leasing.dto.ApplyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


public interface Controller {

    @ApiOperation(
            value = "Create apply to leasing",
            notes = "Creates a apply for leasing with family (List of Persons) , vehicle and how much money asking. ",
            response = ResponseEntity.class)
    ResponseEntity<Map<Object,Object>> addLeasingApply (
            @ApiParam(
                    value = "Apply object , contains family and vehicle",
                    name = "ApplyDto",
                    type = "Object")
                    ApplyDto applyDto);

    @ApiOperation(
            value = "Check apply answer",
            notes = "Searches apply in database by id. ",
            response = ResponseEntity.class)
    ResponseEntity<Map<Object,Object>> getApplyAnswerById(
            @ApiParam(
                    value = "The id of the apply that to check",
                    name = "id",
                    type = "Long")
                    Long id);
}
