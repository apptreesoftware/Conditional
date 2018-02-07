package apptree.condition.examples

import apptree.condition.Condition
import apptree.condition.ConditionStatement
import apptree.condition.Conditional
import apptree.condition.Operator
import apptree.condition.conditions.BasicCondition
import apptree.condition.examples.models.Car
import apptree.condition.messenger.ListMessenger
import apptree.condition.messenger.Messenger

import java.util.ArrayList

object TestBuilder {


    @JvmStatic
    fun main(args: Array<String>) {
        val messenger = ListMessenger()
        val car = Car()
        car.color = "red"
        val blueCondition = BasicCondition.withCondition<Car>({ car1 -> car1.color == "Blue" }, "Color is not blue")
        val greenCondition = BasicCondition.withCondition<Car>({ car1 -> car1.color == "Green" }, "Color is not green")
        val redCondition = BasicCondition.withCondition<Car>({ car1 -> car1.color == "red" }, "Color is not red")
        val conditionList = ArrayList<Condition<Car>>()
        conditionList.add(blueCondition)
        conditionList.add(greenCondition)
        conditionList.add(redCondition)
        val carCondition = ConditionStatement(conditionList)
        carCondition.evaluate(car, messenger)
        for (message in messenger.messages) {
            println(message)
        }
    }
}
