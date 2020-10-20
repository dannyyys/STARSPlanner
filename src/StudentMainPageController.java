import java.util.ArrayList;
import java.util.Scanner;

public class StudentMainPageController implements IMainPageController {
    StudentMainPageView _studentMainPageView;
    IDataAccessor _dataAccessor;
    Scanner _scanner;
    IStudent user;

    public StudentMainPageController(StudentMainPageView studentMainPageView, IDataAccessor dataAccessor,
                                     Scanner scanner) {
        this._studentMainPageView = studentMainPageView;
        this._dataAccessor = dataAccessor;
        this._scanner = scanner;
    }

    private boolean validateFunctionSelectionChoice(String input) {
        try {
            int intInput = Integer.parseInt(input);
            switch (intInput) {
                case 1, 2, 3, 4, 5, 6, 7, 8 -> {
                    return true;
                }
                default -> {
                    _studentMainPageView.inputOutOfBoundError();
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            _studentMainPageView.nonNumericInputError();
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
                _studentMainPageView.studentFunctionsPrompt();
                input = _scanner.nextLine();
                isValidChoice = validateFunctionSelectionChoice(input);
            } while (isValidChoice == false);

            int intInput = Integer.parseInt(input);
            switch (intInput) {
                case 1 -> addCourse();
                case 2 -> dropCourse();
                case 3 -> checkPrintCoursesRegistered();
                case 4 -> checkVacanciesAvailable();
                case 5 -> changeCourseIndex();
                case 6 -> swapCourseWithPeer();
                case 7 -> logout = logout();
                case 8 -> exit();
            }
        } while (logout == false);

        return logout;
    }

    @Override
    public void addUserInfo(IUser user) {
        this.user = (IStudent) user;
    }

    private void exit() {
        _studentMainPageView.exitScreen();
        System.exit(0);
    }

    private boolean logout() {
        _studentMainPageView.logoutScreen();
        return true;
    }
    private boolean validateAccessPeriod() {
        // fetch access time from data accessor
        // check if current time is within access period.
        // If yes return true, else return false
        // handle error checking
        return true;
    }

    private boolean validateCourseSelectionChoice(String input, int numOfCourses) {
        try {
            int intInput = Integer.parseInt(input);
            if (numOfCourses - intInput >= 0) {
                return true;
            } else {
                _studentMainPageView.inputOutOfBoundError();
                return false;
            }
        } catch (NumberFormatException e) {
            _studentMainPageView.nonNumericInputError();
            return false;
        }
    }

    private void addCourse() {
        _studentMainPageView.addCourseFunctionPrompt();
        boolean isWithinAccessPeriod = validateAccessPeriod();
        if (isWithinAccessPeriod == false) {
            _studentMainPageView.invalidAccessPeriodError();
            return;
        }

        ArrayList<ICourse> courses = _dataAccessor.getAllCoursesData();
        if (courses == null) {
            _studentMainPageView.errorRetrievingCourses();
            return;
        } else if (courses.isEmpty()) {
            _studentMainPageView.noCourseError();
            return;
        }

        // check that the course is not already taken by the student
        // add in the option to select the index

        boolean isValidCourse;
        String input;
        do {
            _studentMainPageView.addCourseFunctionSelectionPrompt(courses);
            input = _scanner.nextLine();
            isValidCourse = validateCourseSelectionChoice(input, courses.size());
        } while(isValidCourse == false);

        int courseChoice = Integer.parseInt(input);
        user.addCourse(courses.get(courseChoice - 1));
        _studentMainPageView.addCourseSuccessMessage();
    }

    public void dropCourse() {
        _studentMainPageView.dropCourseFunctionPrompt();
        boolean isWithinAccessPeriod = validateAccessPeriod();
        if (isWithinAccessPeriod == false) {
            _studentMainPageView.invalidAccessPeriodError();
            return;
        }
        ArrayList<ICourse> registeredCourses = user.getCourses();
        if (registeredCourses.isEmpty()) {
            _studentMainPageView.noCourseError();
            return;
        }

        boolean isValidCourse;
        String input;
        do {
            _studentMainPageView.dropCourseFunctionSelectionPrompt(registeredCourses);
            input = _scanner.nextLine();
            isValidCourse = validateCourseSelectionChoice(input, registeredCourses.size());
        } while(isValidCourse == false);

        int courseChoice = Integer.parseInt(input);
        user.dropCourse(registeredCourses.get(courseChoice - 1));
        _studentMainPageView.dropCourseSuccessMessage();
    }

    private void checkPrintCoursesRegistered() {
        _studentMainPageView.printCourses(user.getCourses());
    }

    public void checkVacanciesAvailable() {
        _studentMainPageView.checkVacanciesAvailablePrompt();
        ArrayList<ICourse> courses = _dataAccessor.getAllCoursesData();
        if (courses == null) {
            _studentMainPageView.errorRetrievingCourses();
            return;
        } else if (courses.isEmpty()) {
            _studentMainPageView.noCourseError();
            return;
        }

        boolean isValidCourse;
        String input;
        do {
            _studentMainPageView.checkVacanciesAvailableSelectionPrompt(courses);
            input = _scanner.nextLine();
            isValidCourse = validateCourseSelectionChoice(input, courses.size());
        } while(isValidCourse == false);

        int courseChoice = Integer.parseInt(input);
        _studentMainPageView.printCourseVacancies(courses.get(courseChoice - 1));

    }

    public void changeCourseIndex() {
        _studentMainPageView.changeCourseIndexPrompt();
    }

    public void swapCourseWithPeer() {
        _studentMainPageView.swapCourseWithPeerPrompt();
    }
}
