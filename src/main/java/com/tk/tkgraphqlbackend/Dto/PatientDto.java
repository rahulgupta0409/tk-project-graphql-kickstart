package com.tk.tkgraphqlbackend.Dto;


import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String patientGender;

    private String dataOfBirth;

    private Integer age;

    private String createdDate;

    private String drReferral;

    private Integer totalCost;

    private Boolean isDue;

    private Integer due;

    private Integer discount;

    private String phoneNumber;

    private String emailId;

    private String createdBy;

    private String createdOn;

    private String updatedBy;

    private String updatedOn;

    private Integer paidAmount;

    public PatientDto(Long id) {
        this.id = id;
    }
}
