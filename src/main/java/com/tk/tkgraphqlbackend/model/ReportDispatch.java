package com.tk.tkgraphqlbackend.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReportDispatch {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_dispatch_generator")
    @SequenceGenerator(name = "report_dispatch_generator", sequenceName = "report_dispatch_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "is_dispatch")
    private Boolean isDispatch;

}
