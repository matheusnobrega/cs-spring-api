package com.example.springboot.controllers;

import com.example.springboot.dtos.MapRecordDto;
import com.example.springboot.models.MapModel;
import com.example.springboot.repositories.MapRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @GetMapping("/maps")
    public ResponseEntity<List<MapModel>> getAllMaps() {
        return ResponseEntity.status(HttpStatus.OK).body(mapRepository.findAll());
    }

    @GetMapping("/maps/{id}")
    public ResponseEntity<Object> getOneMap(@PathVariable(value="id") UUID id) {
        Optional<MapModel> map0 = mapRepository.findById(id);

        if (map0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Map not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(map0.get());
    }


}
