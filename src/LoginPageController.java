import java.util.ArrayList;
import java.util.Scanner;

public class LoginPageController implements ILoginPageController{
    private LoginPageView _loginPageView;
    private IDataAccessor _dataAccessor;
    private Scanner _scanner;

    public LoginPageController(LoginPageView loginPageView, IDataAccessor dataAccessor, Scanner scanner) {
        this._loginPageView = loginPageView;
        this._dataAccessor = dataAccessor;
        this._scanner = scanner;
    }

    @Override
    public IMainPageController login() {
        welcomeScreen();
        IUser user = loginScreen();
        return user.getMainPageController(user);
    }

    private boolean validateUser(IUser input) {
        ArrayList<IUser> userList = _dataAccessor.getAllUsersData();

        if (userList == null) {
            _loginPageView.noUserListError();
            exit();
            return false;
        }
        for (IUser user : userList) {
            if (user.equals(input)) {
                return true;
            }
        }
        _loginPageView.invalidUserError();
        return false;
    }

    private boolean validateInput(String input) {
        try {
            int intInput = Integer.parseInt(input);
            if (intInput == 1 || intInput == 2) {
                return true;
            } else {
                _loginPageView.inputOutOfBoundError();
                return false;
            }
        } catch (Exception e) {
            _loginPageView.nonNumericInputError();
            return false;
        }
    }

    private IUser loginScreen() {
        boolean isValidUser;
        IUser input;
        do {
            _loginPageView.usernamePrompt();
            String username = _scanner.nextLine();
            _loginPageView.passwordPrompt();
            String password = _scanner.nextLine();

            input = Factory.createUser();
            input.setUsername(username);
            input.setPassword(password);

            isValidUser = validateUser(input);
        } while (isValidUser == false);

        ArrayList<IUser> userList = _dataAccessor.getAllUsersData();
        for (IUser user : userList) {
            if (user.equals(input)) {
                return user;
            }
        }
        return null;
    }

    private void welcomeScreen() {
        boolean isValidInput;
        String input;
        do {
            _loginPageView.welcomeScreen();
             input = _scanner.nextLine();
            isValidInput = validateInput(input);
        } while (isValidInput == false);

        if (Integer.parseInt(input) == 2) {
            exit();
        }
    }

    private void exit() {
        _loginPageView.exitScreen();
        System.exit(0);
    }
}
