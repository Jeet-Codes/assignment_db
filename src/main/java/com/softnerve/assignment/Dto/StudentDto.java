package com.softnerve.assignment.Dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDto {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY, description = "Auto-generated ID")
    private String id;

    private String name;

    private String contact;

    private String details;

    private String address;

    private String pincode;

}
