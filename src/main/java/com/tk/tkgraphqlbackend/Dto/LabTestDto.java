package com.tk.tkgraphqlbackend.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabTestDto {
    private Long id;

    private Long testId;

    private String testName;

    private Integer testCost;

    private Integer labCost;

    public LabTestDto(Long id) {
        this.id = id;
    }
}
