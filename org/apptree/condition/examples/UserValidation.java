package apptree.condition.examples;

import apptree.condition.Condition;
import apptree.condition.Conditional;
import apptree.condition.examples.models.User;

public class UserValidation {

    public static void main(String[] args) {
        User user = new User();

    }

    private Condition<User> getValidUserCondition() {
        return Conditional.<User>start(user -> isUserNameUnique(user.getUserName()))
            .and(user -> user.getFirstName() != null && user.getLastName() != null)
            .and(user -> !user.getFirstName().isEmpty() && !user.getLastName().isEmpty())
            .or(user -> isEmailUnique(user.getEmail()))
            .build();
    }


    private boolean isUserNameUnique(String username) {
        return true;
    }


    private boolean isEmailUnique(String email) {
        return true;
    }
}
