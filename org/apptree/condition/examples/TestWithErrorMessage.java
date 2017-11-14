package apptree.condition.examples;

import apptree.condition.Condition;
import apptree.condition.ConditionStatement;
import apptree.condition.Conditional;
import apptree.condition.conditions.BasicCondition;
import apptree.condition.examples.models.WorkOrder;

import java.util.Date;

public class TestWithErrorMessage {

    public static void main(String[] args) {
        final String error_WORK_ORDER_ID = "Work Order ID must be zero on create";
        final String error_START_DATE_NULL = "Start date must not be null";
        final String error_END_DATE_NULL = "End date must not be null";
        final String error_START_DATE_LESS_THAN_CURRENT_DATE =
            "Start date musT be less than current date";
        final String error_END_DATE_LESS_THAN_CURRENT_DATE =
            "END date must not less than current date";
        final String error_LOCATION_MUST_NOT_BE_EMPTY = "Location must not be empty";
        //WORK ORDER VALIDATION
        Date currentDate = new Date();
        Condition<WorkOrder> idMustBeEmpty = BasicCondition
            .withCondition(workOrder -> workOrder.getWorkOrderId() == 0, error_WORK_ORDER_ID);

        Condition<WorkOrder> startDateValidation =
            Conditional.<WorkOrder>create(wo -> wo.getStartDateTime() != null,
                                          error_START_DATE_NULL)
                .and(wo -> wo.getStartDateTime().compareTo(currentDate) < 0,
                     error_START_DATE_LESS_THAN_CURRENT_DATE).build();

        Condition<WorkOrder> endDateValidation =
            Conditional.<WorkOrder>create(workOrder -> workOrder.getEndDateTime() != null,
                                          error_END_DATE_NULL)
                .and(workOrder -> workOrder.getEndDateTime().compareTo(currentDate) < 0,
                     error_END_DATE_LESS_THAN_CURRENT_DATE).build();

        Condition<WorkOrder> locationValidation = BasicCondition
            .withCondition(workOrder -> !workOrder.getLocation().isEmpty(),
                           error_LOCATION_MUST_NOT_BE_EMPTY);

        ConditionStatement<WorkOrder> allConditions =
            new ConditionStatement<WorkOrder>("Yes", idMustBeEmpty, startDateValidation,
                                              endDateValidation, locationValidation);
        WorkOrder order = new WorkOrder();

        order.setWorkOrderId(9);


        if (allConditions.evaluate(order)) {
            System.out.println("true");
        } else {
            allConditions.getMessages().forEach(System.out::println);
        }

    }


}
