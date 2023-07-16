package ua.teamchallenge.onlineShop.service.cart;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.teamchallenge.onlineShop.service.Product;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carts")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    @Getter
    private UUID orderId;

    @Getter
    @Column(name = "date_placed", nullable = false)
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private LocalDateTime datePlaced;

    @Getter
    @Column(name = "order_status", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String orderStatus;

    @Getter
    @Column(name = "products", nullable = false)
    @JdbcTypeCode(SqlTypes.ARRAY)
    private List<Product> productList;
}
