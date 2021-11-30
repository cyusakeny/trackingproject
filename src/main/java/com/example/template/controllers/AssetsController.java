package com.example.template.controllers;

import com.example.template.dtos.AssetDto;
import com.example.template.enums.EStatus;
import com.example.template.models.Assets;
import com.example.template.models.Location;
import com.example.template.payload.ApiResponse;
import com.example.template.services.AssetService;
import com.example.template.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/")
public class AssetsController {
    @Autowired
    private AssetService assetService;
    @Autowired
    private UserService userService;
    @PostMapping(path = "/addassets")
    public ResponseEntity<ApiResponse> SaveAsset(@RequestBody AssetDto assetDto){
        Location location = new Location(98.4,87.5,"Paris");
        return ResponseEntity.ok(new ApiResponse(true,"Asset Added",assetService.SaveAsset(assetDto,userService.getLoggedInUser(),location)));
    }
    @GetMapping(path = "/getassetsbylocation/{latitude}/{longitude}/{name}")
    public  ResponseEntity<ApiResponse> GetAssetsByLocation(@PathVariable("latitude") double latitude,@PathVariable("longitude") double longitude,@PathVariable("name")String name){
        Location location = new Location(longitude,latitude,name);
        return ResponseEntity.ok(new ApiResponse(true,"Place found and assets found",assetService.getAssetByLocation(location)));
    }
    @GetMapping(path = "/getassetsbystatusandlocation/{latitude}/{longitude}/{name}/{status}")
    public  ResponseEntity<ApiResponse> GetAssetsByStatusAndLocation(@PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude, @PathVariable("name")String name, @PathVariable("status")EStatus status){
        Location location = new Location(longitude,latitude,name);
        return ResponseEntity.ok(new ApiResponse(true," Assets found by status and location",assetService.getAssetByLocationAndStatus(status,location)));
    }
    @PutMapping("/updateassets/{id}")
    public  ResponseEntity<ApiResponse> UpdateAsset(@PathVariable("latitude") double latitude, @PathVariable("longitude") double longitude, @PathVariable("name")String name, @PathVariable("status")EStatus status){
        Location location = new Location(longitude,latitude,name);
        return ResponseEntity.ok(new ApiResponse(true," Assets found by status and location",assetService.getAssetByLocationAndStatus(status,location)));
    }
}
