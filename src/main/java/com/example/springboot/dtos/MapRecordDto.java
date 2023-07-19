package com.example.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record MapRecordDto(@NotBlank String name,
                           @NotBlank String country,
                           @NotNull Date dateAdded,
                           @NotNull boolean activePool) {

}
