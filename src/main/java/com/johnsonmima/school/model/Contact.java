package com.johnsonmima.school.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Contact{
    @NotBlank(message = "Required")
    @Size(min = 3, message = "Must be greater than 3 characters")
    private String firstName;
    @NotBlank(message = "Required")
    @Size(min = 3, message = "Must be greater than 3 characters")
    private String lastName;
    @NotBlank(message = "Required")
    @Pattern(regexp = "^$|[0-9]{10}", message = "Enter Valid Email")
    private String email;
    @NotBlank(message = "Required")
    @Size(min = 3, message = "Must be greater than 3 characters")
    private String subject;
    @NotBlank(message = "Required")
    @Size(min = 3, message = "Must be greater than 3 characters")
    private String message;
    

    

}