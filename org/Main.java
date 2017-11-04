import orozco.condition.Condition;
import orozco.condition.Conditional;
import orozco.condition.conditions.BasicCondition;
import rx.Observable;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        House house = new House();
        house.name = "test";
        house.address1 = "test";
        house.address2 = "testing";


        Condition<House> condition =
            BasicCondition.withCondition(house1 -> house1.address1.equalsIgnoreCase("test"));
        Condition<House> condition1 =
            BasicCondition.withCondition(house1 -> house1.address1.equalsIgnoreCase("test1"));

        boolean result = Conditional.create(condition)
                                    .or(condition1)
                                    .and(condition)
                                    .build()
                                    .evaluate(house);
        System.out.println(result);

    }
}
