package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Laundry;
import com.example.demo.Repository.Laundryrep;

@RestController
@RequestMapping("/api")
public class Laundrycon {

    @Autowired
    private Laundryrep laundryrep;

    @GetMapping("/laundry/{id}")
    public ResponseEntity<Laundry> getLaundryById(@PathVariable("id") int id){
        Optional<Laundry> laundryData = laundryrep.findById((long) id);

        if (laundryData.isPresent()) {
            return new ResponseEntity<>(laundryData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/laundry")
    public ResponseEntity<Laundry> createLaundry(@RequestBody Laundry laundry) {
        try {
            Laundry laun = new Laundry(laundry.getName(), laundry.getMobileNo(), laundry.getMailId(), laundry.getAddress(), laundry.getServicePackage(), laundry.getPickupDate(), laundry.getPickupTime());
        Laundry sLaundry = laundryrep.save(laun);
        return new ResponseEntity<>(sLaundry, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
    @PutMapping("/laundry/{id}")
    public ResponseEntity<Laundry> updateLaundry(@PathVariable("id") int id, @RequestBody Laundry laundry) {
        Optional<Laundry> laundryData = laundryrep.findById((long) id);

        if (laundryData.isPresent()) {
            Laundry updatedLaundry = laundryData.get();
            updatedLaundry.setName(laundry.getName());
            updatedLaundry.setMobileNo(laundry.getMobileNo());
            updatedLaundry.setMailId(laundry.getMailId());
            updatedLaundry.setAddress(laundry.getAddress());
            updatedLaundry.setServicePackage(laundry.getServicePackage());
            updatedLaundry.setPickupDate(laundry.getPickupDate());
            updatedLaundry.setPickupTime(laundry.getPickupTime());
            return new ResponseEntity<>(laundryrep.save(updatedLaundry), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}
    @DeleteMapping("/laundry/{id}")
    public ResponseEntity<HttpStatus> deleteLaundry(@PathVariable("id") int id) {
        try {
            laundryrep.deleteById((long) id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/laundry")
    public ResponseEntity<HttpStatus> deleteAllLaundry() {
        try {
            laundryrep.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}