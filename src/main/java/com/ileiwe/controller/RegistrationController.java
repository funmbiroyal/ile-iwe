package com.ileiwe.controller;

import com.ileiwe.data.dto.InstructorPartyDto;
import com.ileiwe.service.UserAlreadyExistException;
import com.ileiwe.service.instructorService.InstructorServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Slf4j
public class RegistrationController {
    @Autowired
    InstructorServiceImpl instructorService;

    @PostMapping("/instructor")
    public ResponseEntity<?>
    registerAsInstructor(@RequestBody
                                 InstructorPartyDto
                                 instructorPartyDto)  {
        log.info("instructor object --> {}", instructorPartyDto);

        try {
            return
                    ResponseEntity.ok()
                            .body(instructorService.save(instructorPartyDto));
        } catch (UserAlreadyExistException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
