import java.util.Scanner;

public class StudentMainPage implements IMainPage{
    IMainPageLogic _mainPageLogic;
    Scanner _scanner;

    public StudentMainPage (IMainPageLogic mainPageLogic, Scanner scanner) {
        this._mainPageLogic = mainPageLogic;
        this._scanner = scanner;
    }
    @Override
    public int mainPageDisplay() {
        boolean repeat = false;
        boolean logOut = false;
        String input;

        do {
            System.out.println("Welcome to student Main Page");
            System.out.println("1. Add Course");
            System.out.println("2. Drop Course");
            System.out.println("3. Check/Print Courses Registered");
            System.out.println("4. Check Vacancies Available");
            System.out.println("5. Change Index Number of Course");
            System.out.println("6. Swop Index Number with Another Student");
            System.out.println("7. Log out");
            System.out.println("8. Exit");

            input = _scanner.nextLine();
            int inputStatus = _mainPageLogic.verifyChoice(input);
            switch (inputStatus) {
                case -2 -> {
                    System.out.println("exiting...");
                    logOut = false;
                    repeat = false;
                }
                case -1 -> {
                    System.out.println("logging out");
                    logOut = _mainPageLogic.logout();
                    repeat = false;
                }
                case 0 -> {
                    int choice = Integer.parseInt(input);
                    switch (choice) {
                        case 1 -> addCourseDisplay();
                        case 2 -> dropCourseDisplay();
                        case 3 -> checkPrintCoursesRegisteredDisplay();
                        case 4 -> checkVacanciesAvailableDisplay();
                        case 5 -> changeIndexNumberOfCourseDisplay();
                        case 6 -> swopIndexNumberWithAnotherStudentDisplay();
                    }
                    repeat = true;
                }
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

        if (logOut) {
            return -1;
        } else {
            return 0;
        }
    }

    public void addCourseDisplay() {
        System.out.println("Add Course");
    }

    public void dropCourseDisplay() {
        System.out.println("Drop Course");
    }

    public void checkPrintCoursesRegisteredDisplay() {
        System.out.println("Check/Print Courses Registered");
    }

    public void checkVacanciesAvailableDisplay() {
        System.out.println("Check Vacancies Available");
    }

    public void changeIndexNumberOfCourseDisplay() {
        System.out.println("Change Index Number of Course");
    }

    public void swopIndexNumberWithAnotherStudentDisplay() {
        System.out.println("Swop Index Number with Another Student");
    }
}
