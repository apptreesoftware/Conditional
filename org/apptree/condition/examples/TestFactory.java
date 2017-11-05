package apptree.condition.examples;

import apptree.condition.Condition;
import apptree.condition.ConditionClause;
import apptree.condition.Operator;
import apptree.condition.conditions.BasicCondition;
import apptree.condition.examples.models.Car;


public class TestFactory {


    public static void main(String[] args) {
        Car sportsCar = new Car();
        sportsCar.setColor("red");
        sportsCar.setTopSpeed(130);
        sportsCar.setDurability(20);
        sportsCar.setName("Mazda");

        Car sportsCar1 = new Car();
        sportsCar1.setColor("blue");
        sportsCar1.setTopSpeed(130);
        sportsCar1.setDurability(20);
        sportsCar1.setName("Mazda");


        Car commuter = new Car();
        commuter.setColor("red");
        commuter.setTopSpeed(50);
        commuter.setDurability(100);
        commuter.setMpg(50);
        commuter.setName("Mazda");

        Car commuter1 = new Car();
        commuter1.setColor("blue");
        commuter1.setTopSpeed(60);
        commuter1.setDurability(100);
        commuter1.setMpg(45);
        commuter1.setName("Volvo");


        if (redSportsCar().evaluate(sportsCar)) {
            System.out.println("Red sports car");
        }

        if (commuterCar().evaluate(sportsCar)) {
            System.out.println("Red sports car");
        }

    }

    public static Condition<Car> redSportsCar() {
        Condition<Car> speedCondition = getSpeedCondition(50);
        Condition<Car> colorCondition = getColorCondition("red");
        return new ConditionClause<>(speedCondition, colorCondition, Operator.AND);
    }


    public static Condition<Car> commuterCar() {
        Condition<Car> mpgCondition = getMPGCondition(30);
        Condition<Car> durabilityCondition = getDurabilityCondition(50);
        return new ConditionClause<>(durabilityCondition, mpgCondition, Operator.AND);
    }


    public static Condition<Car> getSpeedCondition(int topSpeed) {
        return BasicCondition.withCondition(car -> car.getTopSpeed() > topSpeed);

    }

    public static Condition<Car> getColorCondition(String color) {
        return BasicCondition.withCondition(car -> car.getColor().equalsIgnoreCase(color));
    }


    public static Condition<Car> getDurabilityCondition(int durability) {
        return BasicCondition.withCondition(car -> car.getDurability() > durability);
    }


    public static Condition<Car> getMPGCondition(int mpg) {
        return BasicCondition.withCondition(car -> car.getMpg() > mpg);
    }
}
