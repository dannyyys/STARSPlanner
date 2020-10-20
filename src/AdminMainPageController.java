import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class AdminMainPageController implements IMainPageController {
    AdminMainPageView _adminMainPageView;
    IDataAccessor _dataAccessor;
    Scanner _scanner;
    IUser user;
    DateFormat dateFormat;

    public AdminMainPageController(AdminMainPageView adminMainPagView, IDataAccessor dataAccessor,
                                   Scanner scanner, DateFormat dateFormat) {
        this._adminMainPageView = adminMainPagView;
        this._dataAccessor = dataAccessor;
        this._scanner = scanner;
        this.dateFormat = dateFormat;
    }

    private boolean validateFunctionSelectionChoice(String input) {
        try {
            int intInput = Integer.parseInt(input);
            switch (intInput) {
                case 1, 2, 3, 4, 5, 6, 7, 8 -> {
                    return true;
                }
                default -> {
                    _adminMainPageView.inputOutOfBoundError();
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            _adminMainPageView.nonNumericInputError();
            return false;
        }
    }

    @Override
    public boolean performFunctions() {
        boolean logout = false;
        do {
            String input;
            boolean isValidChoice;
            do {
                _adminMainPageView.adminFunctionsPrompt();
                input = _scanner.nextLine();
                isValidChoice = validateFunctionSelectionChoice(input);
            } while (isValidChoice == false);

            int intInput = Integer.parseInt(input);
            switch (intInput) {
                case 1 -> editStudentAccessPeriod();
                case 2 -> addStudent();
                case 3 -> addUpdateCourse();
                case 4 -> checkVacancies();
                case 5 -> printStudentListByIndexNumber();
                case 6 -> printStudentListByCourse();
                case 7 -> logout = logout();
                case 8 -> exit();
            }
        } while (logout == false);

        return logout;
    }

    @Override
    public void addUserInfo(IUser user) {
        this.user = user;
    }

    private void exit() {
        _adminMainPageView.exitScreen();
        System.exit(0);
    }

    private boolean logout() {
        _adminMainPageView.logoutScreen();
        return true;
    }

    private boolean validateDate(String input) {
        try {
            Date date = dateFormat.parse(input);
            // check that date entered is not over already
            return true;
        } catch (ParseException e) {
            _adminMainPageView.inputDateInvalidFormatError();
            return false;
        }
    }
    private void editStudentAccessPeriod() {
        boolean isValidAccessPeriodChange;
        String input;
        try {
            do {
                _adminMainPageView.editStudentAccessPeriodFunctionPromptStartDate();
                input = _scanner.nextLine();
                isValidAccessPeriodChange = validateDate(input);
            } while (isValidAccessPeriodChange == false);
            Date startDate = dateFormat.parse(input);

            do {
                _adminMainPageView.editStudentAccessPeriodFunctionPromptEndDate();
                input = _scanner.nextLine();
                isValidAccessPeriodChange = validateDate(input);
            } while (isValidAccessPeriodChange == false);
            Date endDate = dateFormat.parse(input);

            // somehow check that the dates are not the same, but not inside this function

            _dataAccessor.saveAccessPeriod(startDate, endDate);
            _adminMainPageView.editStudentAccessPeriodSuccessMessage();
        } catch (ParseException ignored) {
        }
    }

    private void addStudent() {
        _adminMainPageView.addStudentFunctionPrompt();
    }

    private void addUpdateCourse() {
        _adminMainPageView.addUpdateCourseFunctionPrompt();
    }

    private void checkVacancies() {
        _adminMainPageView.checkVacanciesFunctionPrompt();
    }

    private void printStudentListByIndexNumber() {
        _adminMainPageView.printStudentListByIndexNumber();
    }

    private void printStudentListByCourse() {
        _adminMainPageView.printStudentListByCourse();
    }

}
