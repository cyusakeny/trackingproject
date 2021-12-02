package com.example.template.controllers;

import com.example.template.dtos.AssetDto;
import com.example.template.dtos.AssetUpdateDto;
import com.example.template.enums.EStatus;
import com.example.template.models.Location;
import com.example.template.payload.ApiResponse;
import com.example.template.services.AssetService;
import com.example.template.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @PutMapping("/updateasset/{id}")
    public  ResponseEntity<ApiResponse> UpdateAsset(@PathVariable("id") int id, @RequestBody AssetUpdateDto assetUpdateDto){
        return ResponseEntity.ok(new ApiResponse(true," Asset Updated",assetService.UpdateAsset(assetUpdateDto,id)));
    }
    @DeleteMapping("/deleteasset/{id}")
    public  ResponseEntity<ApiResponse> DeleteAsset(@PathVariable("id") int id){
        return ResponseEntity.ok(new ApiResponse(true," Asset Deleted",assetService.DeleteAsset(id)));
    }
   @GetMapping("/getmyassets")
   public  ResponseEntity<ApiResponse> Myassets(){
       return ResponseEntity.ok(new ApiResponse(true,"Your assets",assetService.MyAssets(userService.getLoggedInUser().getId())));
   }
}
