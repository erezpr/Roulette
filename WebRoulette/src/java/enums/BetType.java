package enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;



@XmlType(name = "betType")
@XmlEnum
public enum BetType {
 
    STRAIGHT("STRAIGHT"),
    SPLIT("SPLIT"),
    STREET("STREET"),
    SIX_LINE("SIX_LINE"),
    TRIO("TRIO"),
    TOP_LINE("TOP_LINE"),
    MANQUE("MANQUE"),
    PASSE("PASSE"),
    ROUGE("ROUGE"),
    NOIR("NOIR"),
    PAIR("PAIR"),
    IMPAIR("IMPAIR"),
    PREMIERE_DOUZAINE("PREMIERE_DOUZAINE"),
    MOYENNE_DOUZAINE("MOYENNE_DOUZAINE"),
    DERNIERE_DOUZAINE("DERNIERE_DOUZAINE"),
    CORNER("CORNER"),
    BASKET("BASKET"),
    COLUMN_1("COLUMN1"),
    COLUMN_2("COLUMN2"),
    COLUMN_3("COLUMN3"),
    SNAKE("SNAKE");
    
    String name;
    private BetType (String name)
    {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
    public static BetType fromValue(String v) {
        for (BetType c: BetType.values()) {
            if (c.toString().equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
