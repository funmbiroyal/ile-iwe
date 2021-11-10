package com.ileiwe.data.dto;

import lombok.Data;
import org.springframework.context.annotation.Bean;


@Data
public class InstructorPartyDto {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
}
