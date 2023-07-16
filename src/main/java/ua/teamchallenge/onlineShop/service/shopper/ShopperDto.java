package ua.teamchallenge.onlineShop.service.shopper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.teamchallenge.onlineShop.service.Product;

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
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopperDto implements Product {
    private UUID id;
    private double prize;
    private String size;
    private String textile;
    private int handles_length;
    private int quantity;
    private String image;
    private String description;
}
