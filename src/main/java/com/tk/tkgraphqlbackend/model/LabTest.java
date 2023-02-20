package com.tk.tkgraphqlbackend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "lab_test_new")
public class LabTest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "lab_test_generator")
    @SequenceGenerator(name = "lab_test_generator", sequenceName = "lab_test_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_cost")
    private Integer testCost;

    @Column(name = "lab_cost")
    private Integer labCost;
}
