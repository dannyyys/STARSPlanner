public class LoginPageView {
    public void welcomeScreen() {
        System.out.println("Welcome to STARS Planner");
        System.out.println("1: login");
        System.out.println("2: exit");
    }

    public void inputOutOfBoundError() {
        System.out.println("input is not one of the options, please try again");
    }

    public void nonNumericInputError() {
        System.out.println("input is not numerical, please try again");
    }

    public void exitScreen() {
        System.out.println("exiting...");
    }

    public void usernamePrompt() {
        System.out.print("Enter username: ");
    }

    public void passwordPrompt() {
        System.out.print("Enter password: ");
    }

    public void invalidUserError() {
        System.out.println("Invalid username/password");
        System.out.println("please try again");
    }

    public void noUserListError() {
        System.out.println("no users available");
    }
}
