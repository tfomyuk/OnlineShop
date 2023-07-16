package ua.teamchallenge.onlineShop.service.tShort;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TShortDto implements Product {
    private UUID id;
    private int prize;
    private String material;
    private int density;
    private String style;
    private String size;
    private int quantity;
    private int temperature;
    private String color;
    private String image;
    private String description;
}
