package com.bird.maru.spot.service.dto;

import com.bird.maru.domain.model.type.Coordinate;
import com.bird.maru.domain.model.type.Image;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class SpotImage {

    private Coordinate coordinate;

    private Image image;

}
