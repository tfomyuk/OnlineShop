package ua.teamchallenge.onlineShop.service.cart;

import org.springframework.stereotype.Service;
import ua.teamchallenge.onlineShop.service.EntityMapper;

@Service
public class CartMapper implements EntityMapper<CartDto, Cart> {

    @Override
    public CartDto mapToDto(Cart cart) {
        return new CartDto(
                cart.getOrderId(),
                cart.getDatePlaced(),
                cart.getOrderStatus(),
                cart.getProductList()
        );
    }

    @Override
    public Cart mapToDao(CartDto cartDto) {
        return new Cart(
                cartDto.getOrderId(),
                cartDto.getDatePlaced(),
                cartDto.getOrderStatus(),
                cartDto.getProductList()
        );
    }
}
