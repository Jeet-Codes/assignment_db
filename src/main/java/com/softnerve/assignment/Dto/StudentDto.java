package com.softnerve.assignment.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    private String id;

    private String name;

    private String contact;

    private String details;

    private String address;

    private String pincode;

}
