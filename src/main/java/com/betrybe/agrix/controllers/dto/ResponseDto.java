package com.betrybe.agrix.controllers.dto;

import com.betrybe.agrix.models.entities.Farm;

/**
 * The type Response dto.
 */
public record ResponseDto<T>(T data) {

}
