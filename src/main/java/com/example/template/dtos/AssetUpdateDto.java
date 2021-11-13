package com.example.template.dtos;

import com.example.template.enums.EStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class AssetUpdateDto {
    @NotBlank
    private  String name;
    @NotBlank
    private EStatus status;
}
