package com.example.template.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class ReviewDto {
    @NotBlank
   private String message;
}
