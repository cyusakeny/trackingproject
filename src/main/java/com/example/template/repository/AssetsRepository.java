package com.example.template.repository;
import com.example.template.enums.EStatus;
import com.example.template.models.Assets;
import com.example.template.models.Location;
import com.example.template.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AssetsRepository  extends JpaRepository<Assets, Integer> {
    public List<Assets> findByLocation(Location location);
    public List<Assets>findByStatusAndLocation(EStatus status,Location location);
    public Assets findAssetsByOwnerAndLocationAndName(User user,Location location,String name);
    public List<Assets>findByOwner(User owner);
}
