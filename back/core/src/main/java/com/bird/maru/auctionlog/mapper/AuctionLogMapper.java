package com.bird.maru.auctionlog.mapper;

import com.bird.maru.auctionlog.controller.dto.AuctionLogResponseDto;
import com.bird.maru.domain.model.entity.AuctionLog;
import java.util.List;
import java.util.stream.Collectors;

public class AuctionLogMapper {
    public static AuctionLogResponseDto toAuctionResponseDto(AuctionLog auctionLog) {
        return AuctionLogResponseDto.builder()
                                    .price(auctionLog.getPrice())
                                    .build();
    }

    public static List<AuctionLogResponseDto> toAuctionResponseDto(List<AuctionLog> auctionLogs) {
        return auctionLogs.stream().map(
                l -> toAuctionResponseDto(l)
        ).collect(Collectors.toList());
    }

}