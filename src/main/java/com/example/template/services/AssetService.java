package com.example.template.services;

import com.example.template.dtos.AssetDto;
import com.example.template.dtos.AssetUpdateDto;
import com.example.template.enums.EStatus;
import com.example.template.models.Assets;
import com.example.template.models.Location;
import com.example.template.models.User;
import com.example.template.repository.AssetsRepository;
import com.example.template.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class AssetService {
@Autowired
    private AssetsRepository repository;
@Autowired
  private LocationRepository locationRepository;

public List<Assets> getAssetByLocation(Location location){
Optional<Location> location1 = locationRepository.findByLatitudeAndAndLongitudeAndLocationName(location.getLatitude(), location.getLongitude(), location.getLocationName());
    return location1.map(value -> repository.findByLocation(value)).orElse(null);
}
public  List<Assets> getAssetByLocationAndStatus(EStatus status,Location location){
    Optional<Location> location1 = locationRepository.findByLatitudeAndAndLongitudeAndLocationName(location.getLatitude(), location.getLongitude(), location.getLocationName());
    return location1.map(value -> repository.findByStatusAndLocation(status, value)).orElse(null);
}
public Assets SaveAsset(AssetDto assetData,User user,Location location){
    Optional<Location> location1 = locationRepository.findByLatitudeAndAndLongitudeAndLocationName(location.getLatitude(), location.getLongitude(), location.getLocationName());
    Assets assets = new Assets();
    if (location1.isEmpty()){
        System.out.println("Location  not found");
      locationRepository.save(location);
        assets.setLocation(location);
    }
    else {
        assets.setLocation(location1.get());
    }
    System.out.println("Location found");

    assets.setDate_created(new Date());

    assets.setOwner(user);
    assets.setName(assetData.getName());
    assets.setStatus(assetData.getStatus());
    assets.setType(assetData.getAssetType());
    return  repository.save(assets);
}
public  Assets UpdateAsset(AssetUpdateDto updateDto,User user,Location location){
Assets asset= repository.findAssetsByOwnerAndLocationAndName(user, location, updateDto.getName());
asset.setStatus(updateDto.getStatus());
return  repository.save(asset);
};
public  Assets DeleteAsset(Assets assets){
Optional<Assets> FindAsset = repository.findById(assets.getId());
if (FindAsset.isPresent()){
    repository.delete(FindAsset.get());
    return FindAsset.get();
}
return null;
};
}
