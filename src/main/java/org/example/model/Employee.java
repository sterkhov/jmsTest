package org.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private Integer age;
    private String hometown;
    private String birthdate;
}