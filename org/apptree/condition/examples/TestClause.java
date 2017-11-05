package apptree.condition.examples;

import apptree.condition.Condition;
import apptree.condition.ConditionClause;
import apptree.condition.examples.models.House;
import apptree.condition.Operator;
import apptree.condition.conditions.BasicCondition;

import java.util.ArrayList;
import java.util.List;

public class TestClause {


    public static void main(String[] args) {
        Condition<House> roomCondition =
            BasicCondition.withCondition(tempHouse -> tempHouse.getRooms() % 2 == 0);

        Condition<House> cityCondition =
            BasicCondition
                .withCondition(tempHouse -> tempHouse.getCity().equalsIgnoreCase("portland"));

        Condition<House> mediumClause =
            new ConditionClause<>(cityCondition, roomCondition, Operator.OR);

        Condition<House> largeClause =
            new ConditionClause<>(cityCondition, roomCondition, Operator.AND);

        Condition<House> combinedClause =
            new ConditionClause<>(mediumClause, largeClause, Operator.AND);


        List<House> largeList = new ArrayList<>();
        List<House> mediumList = new ArrayList<>();
        List<House> combinedList = new ArrayList<>();
        boolean citySwitch = true;
        for (int i = 0; i < 100; i++) {
            House tempHouse = new House();
            tempHouse.setCity((citySwitch) ? "Portland" : "Chicago");
            tempHouse.setRooms(i);
            citySwitch = !citySwitch;
            if (mediumClause.evaluate(tempHouse)) {
                mediumList.add(tempHouse);
            }
            if (largeClause.evaluate(tempHouse)) {
                largeList.add(tempHouse);
            }
            if (combinedClause.evaluate(tempHouse)) {
                combinedList.add(tempHouse);
            }
        }


        for (House house1 : largeList) {
            System.out.println(house1);
        }

        for (House house1 : mediumList) {
            System.out.println(house1);
        }

        for (House house1 : combinedList) {
            System.out.println(house1);
        }


    }


}
