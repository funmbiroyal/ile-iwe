package com.ileiwe.service.instructorService;

import com.ileiwe.data.dto.InstructorPartyDto;
import com.ileiwe.data.model.Instructor;
import com.ileiwe.service.UserAlreadyExistException;

public interface InstructorService {
    Instructor save(InstructorPartyDto dto) throws UserAlreadyExistException;
}
