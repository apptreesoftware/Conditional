package apptree.condition;

import apptree.condition.examples.models.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Condition<Car> desiredCar = Conditional.<Car>start(car -> car.color.equalsIgnoreCase("red") ||
                                                                  car.color.equalsIgnoreCase("blue"))
            .and(car -> car.year > 2015)
            .with(car -> car.mpg > 30, car -> car.topSpeed > 100, Operator.AND)
            .orWith(car -> car.mpg > 45 , car -> car.topSpeed < 80, Operator.AND)
            .build();

        Car dreamCar = new Car();
        dreamCar.topSpeed = 150;
        dreamCar.mpg = 55;
        dreamCar.color = "blue";
        dreamCar.year = 2020;

        if(desiredCar.evaluate(dreamCar)) {
            buy(dreamCar);
        }

        List<Car> dealerShipList = getDealerShipCarList();
        List<Car> carOptions = new ArrayList<>();
        for(Car car: dealerShipList) {
            if(desiredCar.evaluate(car)){
                carOptions.add(car);
            }
        }

        considerPurchasing(carOptions);
    }


}
