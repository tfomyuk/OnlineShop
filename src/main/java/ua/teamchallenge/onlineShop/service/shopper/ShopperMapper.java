package ua.teamchallenge.onlineShop.service.shopper;

import org.springframework.stereotype.Service;
import ua.teamchallenge.onlineShop.service.EntityMapper;

@Service
public class ShopperMapper implements EntityMapper<ShopperDto, Shopper> {
    @Override
    public ShopperDto mapToDto(Shopper shopper) {
        return new ShopperDto(
                shopper.getId(),
                shopper.getPrize(),
                shopper.getSize(),
                shopper.getTextile(),
                shopper.getHandles_length(),
                shopper.getQuantity(),
                shopper.getDescription()
        );
    }

    @Override
    public Shopper mapToDao(ShopperDto shopperDto){
        return new Shopper(
                shopperDto.getId(),
                shopperDto.getPrize(),
                shopperDto.getSize(),
                shopperDto.getTextile(),
                shopperDto.getHandles_length(),
                shopperDto.getQuantity(),
                shopperDto.getDescription());
    }
}
