package com.example.springboot.requestVO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestBodyVO {

    private String firstName;
    private String lastName;
    private String email;
}


