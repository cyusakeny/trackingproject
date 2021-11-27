package com.example.template.services;

import com.example.template.dtos.AssetDto;
import com.example.template.dtos.AssetUpdateDto;
import com.example.template.enums.EStatus;
import com.example.template.exceptions.ApiRequestException;
import com.example.template.models.Assets;
import com.example.template.models.Location;
import com.example.template.models.User;
import com.example.template.repository.AssetsRepository;
import com.example.template.repository.RoleRepository;
import com.example.template.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class AssetService {
@Autowired
    private AssetsRepository repository;

public List<Assets> getAssetByLocation(Location location){
    return repository.findByLocation(location);
}
public  List<Assets> getAssetByLocationAndStatus(EStatus status,Location location){
    return repository.findByStatusAndLocation(status,location);
}
public Assets SaveAsset(AssetDto assetData,User user){
    Assets assets = new Assets();
    Location location = new Location();

    assets.setDate_created(new Date());
    assets.setLocation(location);
    assets.setOwner(user);
    assets.setName(assetData.getName());
    assets.setStatus(assetData.getStatus());
    assets.setType(assetData.getAssetType());
    return  repository.save(assets);
}
public  Assets UpdateAsset(AssetUpdateDto updateDto,User user){
    Location location = new Location();
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
