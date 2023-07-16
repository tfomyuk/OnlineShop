package ua.teamchallenge.onlineShop.service.tShort;

import org.springframework.stereotype.Service;
import ua.teamchallenge.onlineShop.service.EntityMapper;

@Service
public class TShortMapper implements EntityMapper<TShortDto, TShort> {
    @Override
    public TShortDto mapToDto(TShort tShort) {
        return new TShortDto(
                tShort.getId(),
                tShort.getPrize(),
                tShort.getMaterial(),
                tShort.getDensity(),
                tShort.getStyle(),
                tShort.getSize(),
                tShort.getQuantity(),
                tShort.getTemperature(),
                tShort.getColor(),
                tShort.getImage(),
                tShort.getDescription()
        );
    }

    @Override
    public TShort mapToDao(TShortDto tShortDto) {
        return new TShort(
                tShortDto.getId(),
                tShortDto.getPrize(),
                tShortDto.getMaterial(),
                tShortDto.getDensity(),
                tShortDto.getStyle(),
                tShortDto.getSize(),
                tShortDto.getQuantity(),
                tShortDto.getTemperature(),
                tShortDto.getColor(),
                tShortDto.getImage(),
                tShortDto.getDescription()
        );
    }
}
