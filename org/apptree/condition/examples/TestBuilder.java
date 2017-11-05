package apptree.condition.examples;

import apptree.condition.Condition;
import apptree.condition.Conditional;
import apptree.condition.Operator;
import apptree.condition.conditions.BasicCondition;
import apptree.condition.examples.models.Car;

public class TestBuilder {


    public static void main(String[] args) {
        Condition<Car> carBuilder = Conditional.<Car>start(car -> car.getMpg() > 20)
            .and(car -> car.getColor().equalsIgnoreCase("green"))
            .or(car -> car.getColor().equalsIgnoreCase("red"))
            .build();


        Car carOne = new Car();
        carOne.setMpg(30);
        carOne.setDurability(100);
        carOne.setColor("green");

        Car carTwo = new Car();
        carTwo.setMpg(30);
        carTwo.setColor("red");


        if (carBuilder.evaluate(carOne)) {
            System.out.println("Car One");
        }

        if (carBuilder.evaluate(carTwo)) {
            System.out.println("Car Two");
        }


        boolean last = Conditional
            .<Car>start(car -> car.getColor().equalsIgnoreCase("green"))
            .with(car -> car.getDurability() > 100,
                  car -> car.getName().equalsIgnoreCase("green"), Operator.OR)
            .build().evaluate(carOne);

        System.out.println(last);
    }
}
