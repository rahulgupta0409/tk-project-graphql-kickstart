package com.tk.tkgraphqlbackend.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientInputDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String patientGender;

    private String dataOfBirth;

    private Integer age;

    private String createdDate;

    private String drReferral;

    private Integer totalCost;

    private Boolean isDiscount;

    private Integer due;

    private Integer discount;

    private String phoneNumber;

    private String emailId;

    private String createdBy;

    private String createdOn;

    private String updatedBy;

    private String updatedOn;

    private Integer paidAmount;

    public PatientInputDto(Long id) {
        this.id = id;
    }
}
