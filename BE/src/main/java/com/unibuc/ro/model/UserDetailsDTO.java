package com.unibuc.ro.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDetailsDTO {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
