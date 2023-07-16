package ua.teamchallenge.onlineShop.service.cup;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ua.teamchallenge.onlineShop.service.Product;

import java.util.Objects;
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
| String 		     | description(детальний опис)	  |	Детальний опис											    |
---------------------------------------------------------------------------------------------------------------------
*/
@Entity
@Table(name = "cups")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cup implements Product {
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
    @Column(name = "type", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String type;

    @Getter
    @Column(name = "kind", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String kind;

    @Getter
    @Column(name = "color", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String color;

    @Getter
    @Column(name = "surface", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String surface;

    @Getter
    @Column(name = "shape", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String shape;

    @Getter
    @Column(name = "material", nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String material;

    @Getter
    @Column(name = "capacity", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int capacity;

    @Getter
    @Column(name = "diameter", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int diameter;

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
        Cup cup = (Cup) obj;
        return id != null && Objects.equals(id, cup.id);
    }
}
