# Conditional
Conditional is a java library for creating and composing conditions
 to be validated against a given object.

 
 The target use case for this library is object validation.
 
 The first example will be object validation for the attributes of a car.
 
 
 ```java
public class Car {
    public int topSpeed;
    public String color;
    public int mpg;
}
 
 ```
 
 
 This example contains simple straight forward conditions

 ```java
 package apptree.condition;
 
 import apptree.condition.conditions.BasicCondition;
 import apptree.condition.examples.models.Car;
 
 public class Main {
 
     public static void main(String[] args) {
         Car carOne = new Car();
         carOne.color = "yellow";
         carOne.topSpeed = 30;
         carOne.mpg = 55;
 
         Car carTwo = new Car();
         carTwo.color = "red";
         carTwo.topSpeed = 150;
         carTwo.mpg = 15;
 
         if(isRed().evaluate(carOne)) {
             System.out.println("Car one is red");
         }
 
         if(commuterCar().evaluate(carTwo)) {
             System.out.println("Car two has high miles per gallon");
         }
 
         if(sportsCar().evaluate(carTwo)) {
             System.out.println("Car two is a sports car");
         }
 
     }
 
     public static Condition<Car> isRed(){
         return BasicCondition.withCondition(car -> car.color.equalsIgnoreCase("red"));
     }
 
     public static Condition<Car> commuterCar(){
         return BasicCondition.withCondition(car -> car.mpg > 35);
     }
 
     public static Condition<Car> sportsCar() {
         Condition<Car> fastCar = BasicCondition.withCondition(car -> car.topSpeed > 120);
         return new ConditionClause<Car>(isRed(), fastCar, Operator.AND);
     }
 
 
 }
 ```
 
 
 **Builder Example**
 
 
 ```java
public class Main {

    public static void main(String[] args) {
        Condition<Car> desiredCar = Conditional.<Car>start(car -> car.color.equalsIgnoreCase("red") ||
                                                                  car.color.equalsIgnoreCase("blue"))
            .and(car -> car.year > 2015)
            .with(car -> car.mpg > 30, car -> car.topSpeed > 100, Operator.AND)
            .orWith(car -> car.mpg > 45 , car -> car.topSpeed < 80, Operator.AND)
            .or(car -> car.year == 2017)
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
```
 
 
  
