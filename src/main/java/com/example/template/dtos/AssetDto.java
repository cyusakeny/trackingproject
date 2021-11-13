package com.example.template.dtos;

import com.example.template.enums.EAssetType;
import com.example.template.enums.EStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AssetDto {
    @NotBlank
    private EAssetType AssetType;
    @NotBlank
    private EStatus status;
    @NotBlank
    private  String name;
}
