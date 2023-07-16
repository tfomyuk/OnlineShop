package ua.teamchallenge.onlineShop.service.cup;

import org.springframework.stereotype.Service;
import ua.teamchallenge.onlineShop.service.EntityMapper;

@Service
public class CupMapper implements EntityMapper<CupDto, Cup> {
    @Override
    public CupDto mapToDto(Cup cup) {
        return new CupDto(
                cup.getId(),
                cup.getPrize(),
                cup.getType(),
                cup.getKind(),
                cup.getColor(),
                cup.getSurface(),
                cup.getShape(),
                cup.getMaterial(),
                cup.getCapacity(),
                cup.getDiameter(),
                cup.getImage(),
                cup.getDescription()
        );
    }

@Override
    public Cup mapToDao(CupDto cupDto){
        return new Cup(
                cupDto.getId(),
                cupDto.getPrize(),
                cupDto.getType(),
                cupDto.getKind(),
                cupDto.getColor(),
                cupDto.getSurface(),
                cupDto.getShape(),
                cupDto.getMaterial(),
                cupDto.getCapacity(),
                cupDto.getDiameter(),
                cupDto.getImage(),
                cupDto.getDescription()
        );
    }
}
