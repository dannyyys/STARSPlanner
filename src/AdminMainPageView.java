public class AdminMainPageView extends LoginPageView{
    public void adminFunctionsPrompt() {
        System.out.println("Welcome to admin Main Page");
        System.out.println("1. Edit student access period");
        System.out.println("2. Add a student (name, matric number, gender, nationality, etc)");
        System.out.println("3. Add/Update a course (course code, school, its index numbers and vacancy)");
        System.out.println("4. Check available slot for an index number (vacancy in a class)");
        System.out.println("5. Print student list by index number");
        System.out.println("6. Print student list by course (all students registered for the selected course)");
        System.out.println("7. Log out");
        System.out.println("8. Exit");
    }

    public void addStudentFunctionPrompt() {
        System.out.println("Add a student");
        System.out.println("___________________________________");
    }

    public void logoutScreen() {
        System.out.println("logging out...");
    }

    public void editStudentAccessPeriodFunctionPromptStartDate() {
        System.out.println("Edit student access period");
        System.out.print("enter new access period start date (dd.mm.yyyy, hh:mm): ");
    }

    public void editStudentAccessPeriodFunctionPromptEndDate() {
        System.out.print("enter new access period end date (dd.mm.yyyy, hh:mm): ");
    }

    public void inputDateInvalidFormatError() {
        System.out.println("Invalid input: input is not in the right format");
    }

    public void sameDateError() {
        System.out.println("invalid input: same date and time entered for start and end");
    }

    public void editStudentAccessPeriodSuccessMessage() {
        System.out.println("Successfully changed access period");
    }

    public void addUpdateCourseFunctionPrompt() {
        System.out.println("Add/Update a course");
        System.out.println("___________________________________");
    }

    public void checkVacanciesFunctionPrompt() {
        System.out.println("Check available slot for an index number");
        System.out.println("___________________________________");
    }

    public void printStudentListByIndexNumber() {
        System.out.println("Print student list by index number");
        System.out.println("___________________________________");
    }

    public void printStudentListByCourse() {
        System.out.println("Print student list by course");
        System.out.println("___________________________________");
    }
}
