package com.betrybe.agrix.controllers;

import com.betrybe.agrix.controllers.dto.ResponseDto;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */

@RestController
@RequestMapping("/farms")
public class FarmController {
  private final FarmService farmService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   */
  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Create farm response entity.
   *
   * @param farm the farm
   * @return the response entity
   */
  @PostMapping()
  public ResponseEntity<Farm> createFarm(@RequestBody Farm farm) {
    Farm newFarm = farmService.insertFarm(farm);
    ResponseDto<Farm> responseDto = new ResponseDto<>(newFarm);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto.data());
  }

  @GetMapping()
  public ResponseEntity<List<Farm>> getAllFarms() {
    List<Farm> newFarm = farmService.getAllFarms();
    ResponseDto<List<Farm>> responseDto = new ResponseDto<>(newFarm);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }
}
