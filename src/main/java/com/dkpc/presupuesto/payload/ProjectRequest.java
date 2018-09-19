package com.dkpc.presupuesto.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProjectRequest {

    @NotBlank
    @Size(max = 140)
    private String projects;


}
