package ua.teamchallenge.onlineShop.service.shopper;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.teamchallenge.onlineShop.service.Product;
import ua.teamchallenge.onlineShop.service.cup.Cup;

import java.util.Objects;
import java.util.UUID;

/*
3)Shopper(Шопери (екосумка))_________________________________________________________________________________________
|_type_______________|_name___________________________|__example____________________________________________________|
| UUID				 | id							  | 3335badd-60a7-4307-9009-514cc63238f1						|
| int				 | price						  | 250 грн														|
| Size(enum)|String  | size(Розмір)					  |	35x41														|
| String			 | textile(Тканина)				  |	невибілена бавовна , бязь, 135 г/кв.м						|
| int				 | handles_length(Довжина ручок)  |	60 см														|
| int				 | quantity(Кількість в упаковці) |	50 шт.														|
| String 			 | image(фото)					  |	http:\\img.server.com\some-image.jpg						|
| String			 | description(Опис)			  |	Детальний опис											    |
---------------------------------------------------------------------------------------------------------------------
*/
@Entity
@Table(name = "shoppers")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Shopper implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    @Getter
    private UUID id;

    @Getter
    @Column(name = "prize", nullable = false)
    @JdbcTypeCode(SqlTypes.DOUBLE)
    private double prize;

    @Getter
    @Column(name = "size", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String size;

    @Getter
    @Column(name = "textile", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String textile;

    @Getter
    @Column(name = "handles_length", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int handles_length;

    @Getter
    @Column(name = "quantity", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int quantity;

    @Getter
    @Column(name = "image", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String image;

    @Getter
    @Column(name = "description", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Hibernate.getClass(this) != Hibernate.getClass(obj)) {
            return false;
        }
        Shopper shopper = (Shopper) obj;
        return id != null && Objects.equals(id, shopper.id);
    }
}
