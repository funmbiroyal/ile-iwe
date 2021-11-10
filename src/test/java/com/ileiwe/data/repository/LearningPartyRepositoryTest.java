package com.ileiwe.data.repository;

import com.ileiwe.data.model.Authority;
import com.ileiwe.data.model.LearningParty;
import com.ileiwe.data.model.Role;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
@Slf4j
@Sql(scripts = {"/db/insert.sql"})
class LearningPartyRepositoryTest {

    @Autowired
    LearningPartyRepository learningPartyRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void createLearningPartingTest(){
//        LearningParty learningUser = LearningParty.builder()
//                                    .email("gracie@gmail.com")
//        er                             .password("pass1234").build();
LearningParty learningUser =new  LearningParty("gracie@gmail.com","pass123",
        new Authority(Role.ROLE_STUDENT));

        learningPartyRepository.save(learningUser);
        assertThat(learningUser.getId()).isNotNull();
        assertThat(learningUser.getEmail()).isEqualTo("gracie@gmail.com");
        assertThat(learningUser.getAuthorities().get(0).getAuthority()).isEqualTo(Role.ROLE_STUDENT);
        log.info("After saving {}",learningUser);


    }
@Test
void createLearningPartyUniqueEmailsTest(){
        //create learning party
    LearningParty user1 =new  LearningParty("gracie@gmail.com","pass123", new Authority(Role.ROLE_STUDENT));
    // save to dba
    learningPartyRepository.save(user1);
    assertThat(user1.getEmail()).isEqualTo("gracie@gmail.com");
    //assert that exception was thrown
    assertThat(user1.getId()).isNotNull();
    // create another learning party
    LearningParty user2 =new  LearningParty("gracie@gmail.com","pass123",
            new Authority(Role.ROLE_STUDENT));
    assertThrows(DataIntegrityViolationException.class,()-> learningPartyRepository.save(user2));
}
@Test
void learningPartyWithNullValues(){

    LearningParty user2 =new  LearningParty(null,null,
            new Authority(Role.ROLE_STUDENT));
    assertThrows(DataIntegrityViolationException.class,()-> learningPartyRepository.save(user2));

}
@Test
void learningPartyWithEmptyValues(){
    LearningParty user =new  LearningParty("","",
            new Authority(Role.ROLE_STUDENT));
    assertThrows(ConstraintViolationException.class, ()->learningPartyRepository.save(user));
}
@Test
void findByEmailTest(){
        LearningParty learningParty = learningPartyRepository.findByEmail("gracie@gmail.com");
        assertThat(learningParty).isNotNull();
        assertThat(learningParty.getEmail()).isEqualTo("gracie@gmail.com");
        log.info("Learning party object --> {}",learningParty);
}


    @AfterEach
    void tearDown() {
    }
}