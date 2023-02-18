package com.tk.tkgraphqlbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "lab_test")
public class LabTest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "test_name")
    private String testName;
    @Column(name = "test_cost")
    private Integer testCost;
    @Column(name = "lab_cost")
    private Integer labCost;

}
