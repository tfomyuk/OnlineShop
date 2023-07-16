package ua.teamchallenge.onlineShop.service.cup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.teamchallenge.onlineShop.service.Product;

import java.util.UUID;

/*
2)Cup(кружки)________________________________________________________________________________________________________																													    		|
|_type_______________|_name___________________________|__example____________________________________________________|
| UUID				 | id							  | 3335badd-60a7-4307-9009-514cc63238f1						|
| int				 | price						  | 250 грн														|
| String			 | type(тип)					  |	Хамелеон													|
| String			 | kind(вид)			 	      |	Чашка														|
| Color(enum)|String | color(колір)		 		  	  |	Чорний														|
| String			 | surface(поверхня)		  	  |	Матова														|
| String			 | shape(форма)		 		  	  |	Циліндрична													|
| String			 | material(матеріал) 		  	  |	Кераміка													|
| int				 | capacity(об'єм)	 		  	  |	330 мл														|
| int			     | diameter(діаметер) 		  	  |	8 см														|
| String 			 | image(фото)					  |	http:\\img.server.com\some-image.jpg						|
| String 		     | description(детальний опис)	  |	Детальний опис											    |
---------------------------------------------------------------------------------------------------------------------
*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CupDto implements Product {
    private UUID id;
    private double prize;
    private String type;
    private String kind;
    private String color;
    private String surface;
    private String shape;
    private String material;
    private int capacity;
    private int diameter;
    private String image;
    private String description;
}
