import java.util.Scanner;

public class LoginPage implements ILoginPage{
    ILoginLogic _loginLogic;
    Scanner _scanner;

    public LoginPage (ILoginLogic iLoginLogic, Scanner scanner) {
        this._loginLogic = iLoginLogic;
        this._scanner = scanner;
    }
    @Override
    public void loginDisplay() {
        boolean repeat = false;

        do {
            System.out.println("Welcome to STARS Planner");
            System.out.println("1: login");
            System.out.println("2: exit");
            String input = _scanner.nextLine();
            int inputStatus = _loginLogic.verifyChoice(input);
            switch (inputStatus) {
                case -1 -> {
                    System.out.println("exiting...");
                    _loginLogic.exit();
                    repeat = false;
                }
                case 0 -> repeat = false;
                case 1 -> {
                    System.out.println("input is not numerical, please try again");
                    repeat = true;
                }
                case 2 -> {
                    System.out.println("input is not one of the options, please try again");
                    repeat = true;
                }
            }
        } while (repeat);
    }

    public IMainPage login() {
        boolean repeat = false;
        IMainPage mainPage = null;

        do {
            System.out.print("Please enter your username: ");
            String username = _scanner.nextLine();
            System.out.print("Please enter your password: ");
            String password = _scanner.nextLine();
            int loginStatus = _loginLogic.verifyLoginDetails(username, password);
            switch (loginStatus) {
                case -1 -> {
                    System.out.println("Username or password incorrect, please check and try again");
                    repeat = true;
                }
                case 0 -> {
                    mainPage = _loginLogic.login(username, password);
                    repeat = false;
                }
            }
        } while (repeat);

        return mainPage;
    }
}
