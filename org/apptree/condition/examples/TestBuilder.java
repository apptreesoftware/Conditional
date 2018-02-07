package apptree.condition.examples;

import apptree.condition.Condition;
import apptree.condition.ConditionStatement;
import apptree.condition.conditions.BasicCondition;
import apptree.condition.examples.models.Car;
import apptree.condition.messenger.ListMessenger;
import apptree.condition.messenger.Messenger;

import java.util.ArrayList;
import java.util.List;

public class TestBuilder {


    public static void main(String[] args) {
        Messenger messenger = new ListMessenger();
        Car car = new Car();
        car.color = "red";
        Condition<Car> blueCondition = BasicCondition.withCondition(car1 -> car1.color.equals("Blue"), "Color is not blue");
        Condition<Car> greenCondition = BasicCondition.withCondition(car1 -> car1.color.equals("Green"), "Color is not green");
        Condition<Car> redCondition = BasicCondition.withCondition(car1 -> car1.color.equals("red"), "Color is not red");
        List<Condition<Car>> conditionList = new ArrayList<>();
        conditionList.add(blueCondition);
        conditionList.add(greenCondition);
        conditionList.add(redCondition);
        Condition<Car> carCondition = new ConditionStatement<Car>(conditionList);
        carCondition.evaluate(car, messenger);
        for(String message:messenger.getMessages()) {
            System.out.println(message);
        }
    }
}
