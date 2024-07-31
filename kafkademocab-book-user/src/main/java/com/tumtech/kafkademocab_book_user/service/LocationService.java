package com.tumtech.kafkademocab_book_user.service;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
  @KafkaListener(topics = "cab-location", groupId = "user-group" )
  //location is being injected from the producer
  public void cabLocation(String location) {
      System.out.println(location);
    }
}
