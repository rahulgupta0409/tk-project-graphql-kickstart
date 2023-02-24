package com.tk.tkgraphqlbackend.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "patient_table_new_new")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "patient_new_new_generator")
    @SequenceGenerator(name = "patient_new_new_generator", sequenceName = "patient_table_new_new_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "patient_gender")
    private String patientGender;
    @Column(name = "date_of_birth")
    private String dataOfBirth;
    @Column(name = "age")
    private Integer age;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "dr_referral")
    private String drReferral;
    @Column(name = "total_cost")
    private Integer totalCost;
    @Column(name = "is_discount")
    private Boolean isDiscount;
    @Column(name = "due")
    private Integer due;
    @Column(name = "discount")
    private Integer discount;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_on")
    private String createdOn;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_on")
    private String updatedOn;
    @Column(name = "paid_amount")
    private Integer paidAmount;

}
