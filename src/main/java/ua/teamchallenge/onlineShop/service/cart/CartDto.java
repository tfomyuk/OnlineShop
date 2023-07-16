package ua.teamchallenge.onlineShop.service.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.teamchallenge.onlineShop.service.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartDto {
    private UUID orderId;
    private LocalDateTime datePlaced;
    private String orderStatus;
    private double totalAmount;
    private List<Product> productList;

    public CartDto(UUID orderId, LocalDateTime datePlaced, String orderStatus, List<Product> productList) {
        this.orderId = orderId;
        this.datePlaced = datePlaced;
        this.orderStatus = orderStatus;
        this.totalAmount = calculateTotalAmount(productList);
        this.productList = productList;
    }

    private static double calculateTotalAmount(List<Product> productList) {
        return productList.stream()
                .mapToDouble(Product::getPrize)
                .sum();
    }

    private double calculateTotalAmount() {
        return calculateTotalAmount(this.productList);
    }

}
