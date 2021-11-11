package com.example.template.locating;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GeoLocating {
    {
        File database = new File("/home/keny/Desktop/GeoLite2-City_20211109/GeoLite2-City.mmdb");
        DatabaseReader reader = null;
        try {
            reader = new DatabaseReader.Builder(database).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InetAddress ipAddress = null;
        try {
            ipAddress = InetAddress.getByName("197.243.61.202");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        CityResponse response = null;
        try {
            response = reader.city(ipAddress);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GeoIp2Exception e) {
            e.printStackTrace();
        }
        assert response != null;
        Country country = response.getCountry();
        System.out.println(country.getIsoCode());
        System.out.println(country.getName());
        City city = response.getCity();
        System.out.println(city.getName());
    }
}
