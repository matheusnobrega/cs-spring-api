package com.example.springboot.controllers;

import com.example.springboot.dtos.MapRecordDto;
import com.example.springboot.models.MapModel;
import com.example.springboot.repositories.MapRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    @Autowired
    MapRepository mapRepository;

    @PostMapping("/maps")
    public ResponseEntity<MapModel> saveMap(@RequestBody @Valid MapRecordDto mapRecordDto) {
        var mapModel = new MapModel();
        BeanUtils.copyProperties(mapRecordDto, mapModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapRepository.save(mapModel));
    }

}
