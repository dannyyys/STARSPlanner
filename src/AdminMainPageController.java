import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;

public class AdminMainPageController implements IMainPageController {
    AdminMainPageView _adminMainPageView;
    IDataAccessor _dataAccessor;
    Scanner _scanner;
    IUser user;
    DateFormat dateFormat;

    public AdminMainPageController(AdminMainPageView adminMainPagView,
                                   Scanner scanner, DateFormat dateFormat) {
        this._adminMainPageView = adminMainPagView;
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
    public void addDataAccessor(IDataAccessor dataAccessor) {
        this._dataAccessor = dataAccessor;
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

    private boolean validateDateInput(String input) {
        try {
            long now = System.currentTimeMillis();
            long date = dateFormat.parse(input).getTime();
            boolean isAfter = date >= now;
            if (isAfter == false) {
                _adminMainPageView.dateAlreadyOverError();
            }
            return isAfter;
        } catch (ParseException e) {
            _adminMainPageView.inputDateInvalidFormatError();
            return false;
        }
    }

    private boolean validateBetweenDates(long now, Long start, Long end) {
        return ( now >= start ) && (now < end);
    }

    private boolean validateAccessPeriod(long start, long end) {
        long now = System.currentTimeMillis();
        boolean isBetween = validateBetweenDates(now, start, end);
        if (isBetween == false) {
            _adminMainPageView.invalidAccessPeriodError();
        }
        return isBetween;
    }

    private void editStudentAccessPeriod() {
        try {
            boolean isValidAccessPeriod;
            long startDate, endDate;
            do {
                boolean isValidAccessPeriodChange;
                String input;
                do {
                    _adminMainPageView.editStudentAccessPeriodFunctionPromptStartDate();
                    input = _scanner.nextLine();
                    isValidAccessPeriodChange = validateDateInput(input);
                } while (isValidAccessPeriodChange == false);
                startDate = dateFormat.parse(input).getTime();

                do {
                    _adminMainPageView.editStudentAccessPeriodFunctionPromptEndDate();
                    input = _scanner.nextLine();
                    isValidAccessPeriodChange = validateDateInput(input);
                } while (isValidAccessPeriodChange == false);
                endDate = dateFormat.parse(input).getTime();

                isValidAccessPeriod = validateAccessPeriod(startDate, endDate);
            } while (isValidAccessPeriod == false);

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
