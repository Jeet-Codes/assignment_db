package com.softnerve.assignment.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    private String id;

    private String name;

    private String contact;

    private String details;

    private String address;

    private String pincode;
}
