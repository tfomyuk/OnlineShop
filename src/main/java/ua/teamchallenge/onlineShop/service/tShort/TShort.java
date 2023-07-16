package ua.teamchallenge.onlineShop.service.tShort;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.teamchallenge.onlineShop.service.Product;
import ua.teamchallenge.onlineShop.service.Size;

import java.util.UUID;
/*
1)T-shirt(футболки)_____________________________________________________________________________________________________
|_type_______________|_name___________________________|__example_______________________________________________________|
| UUID				 | id							  | 3335badd-60a7-4307-9009-514cc63238f1						   |
| int				 | price						  | 250 грн														   |
| String 			 | material(матеріал)			  |	100% бавовна кільцевого прядіння; GYH - 85% бавовна,15% віскоза|
| int 				 | density(щільнічть)			  |	155 г/м²													   |
| String 			 | style(покрій)				  |	Casual Fit													   |
| Size(enum) 		 | size(розміри)   				  |	2XS-XS-S-M-L-XL-XXL-3XL-4XL-5XL								   |
| int 				 | quantity(штук в коробці)		  |	96 / коробка (2XS-XS 48; 3-5XL 24)							   |
| int 				 | temperature(температура прання)|	40°C														   |
| Color(enum)|String | color(колір)					  |	Білий														   |
| String 			 | image(фото)					  |	http:\\img.server.com\some-image.jpg						   |
| String 			 | description(детальний опис)    |	Детальний опис												   |
------------------------------------------------------------------------------------------------------------------------
*/
@Entity
@Table(name = "tshorts")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TShort implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JdbcTypeCode(SqlTypes.UUID)
    @Getter
    private UUID id;

    @Getter
    @Column(name = "prize", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int prize;

    @Getter
    @Column(name = "material", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String material;

    @Getter
    @Column(name = "density", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int density;

    @Getter
    @Column(name = "style", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String style;

    @Getter
    @Column(name = "size", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String size;

    @Getter
    @Column(name = "quantity", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int quantity;

    @Getter
    @Column(name = "temperature", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int temperature;
    @Getter
    @Column(name = "color", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String color;

    @Getter
    @Column(name = "image", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String image;

    @Getter
    @Column(name = "description", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String description;
}
