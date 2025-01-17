package com.tumtech.kafkademocab_book_driver.controller;

import com.tumtech.kafkademocab_book_driver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    private CabLocationService cabLocationService;

    @Autowired
    public CabLocationController (CabLocationService cabLocationService){
        this.cabLocationService=cabLocationService;
    }
    @PutMapping
public ResponseEntity updateLocaton () throws InterruptedException {
        int range = 100;
        while (range>0){
            cabLocationService.updateLocation(Math.random()+ " , "+ Math.random());
            Thread.sleep(1000); // my data publishes every second
//            System.out.println(Math.random()+ " , "+ Math.random());
            range--;
        }
        return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);
}

}
