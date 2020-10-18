import java.util.Scanner;

public class AdminMainPage implements IMainPage{
    IMainPageLogic _mainPageLogic;
    Scanner _scanner;

    public AdminMainPage (IMainPageLogic mainPageLogic, Scanner scanner) {
        this._mainPageLogic = mainPageLogic;
        this._scanner = scanner;
    }

    @Override
    public int mainPageDisplay() {
        boolean repeat = false;
        boolean logOut = false;
        String input;

        do {
            System.out.println("Welcome to admin Main Page");
            System.out.println("1. Edit student access period");
            System.out.println("2. Add a student (name, matric number, gender, nationality, etc)");
            System.out.println("3. Add/Update a course (course code, school, its index numbers and vacancy)");
            System.out.println("4. Check available slot for an index number (vacancy in a class)");
            System.out.println("5. Print student list by index number");
            System.out.println("6. Print student list by course (all students registered for the selected course)");
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
                        case 1 -> editStudentAccessPeriodDisplay();
                        case 2 -> addStudentDisplay();
                        case 3 -> addUpdateCourseDisplay();
                        case 4 -> checkVacanciesAvailableDisplay();
                        case 5 -> printStudentListByIndexNumberDisplay();
                        case 6 -> printStudentListByCourseDisplay();
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

    public void editStudentAccessPeriodDisplay() {
        System.out.println("Edit student access period");
    }

    public void addStudentDisplay() {
        System.out.println("Add a student");
    }

    public void addUpdateCourseDisplay() {
        System.out.println("Add/Update a course");
    }

    public void checkVacanciesAvailableDisplay() {
        System.out.println("Check available slot for an index number");
    }

    public void printStudentListByIndexNumberDisplay() {
        System.out.println("Print student list by index number");
    }

    public void printStudentListByCourseDisplay() {
        System.out.println("Print student list by course");
    }
}
