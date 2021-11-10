package com.ileiwe.service.instructorService;

import com.ileiwe.data.dto.InstructorPartyDto;
import com.ileiwe.data.model.Authority;
import com.ileiwe.data.model.Instructor;
import com.ileiwe.data.model.LearningParty;
import com.ileiwe.data.model.Role;
import com.ileiwe.data.repository.InstructorRepository;
import com.ileiwe.data.repository.LearningPartyRepository;
import com.ileiwe.service.UserAlreadyExistException;
import com.ileiwe.service.event.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService {
    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    LearningPartyRepository learningPartyRepository;
    @Autowired
    ApplicationEventPublisher eventPublisher;
//    BCryptPasswordEncoder;


    @Override
    public Instructor save(InstructorPartyDto instructorDto) throws UserAlreadyExistException {
        if (instructorDto == null) {
            throw new NullPointerException("Instructor can not be null");
        }
        if (learningPartyRepository.findByEmail(instructorDto.getEmail()) == null) {

            LearningParty learningParty = new LearningParty(instructorDto.getEmail(),
                    instructorDto.getPassword(),
                    new Authority(Role.ROLE_INSTRUCTOR));

            Instructor instructor = Instructor.builder().lastname(instructorDto.getLastname())
                    .firstname(instructorDto.getLastname()).learningParty(learningParty).build();

            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(learningParty));

            return instructorRepository.save(instructor);

        } else {
            throw new UserAlreadyExistException(
                    "user with email " + instructorDto.getEmail() + " already exist"
            );
        }
    }
}
