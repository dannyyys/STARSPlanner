import java.util.ArrayList;

public class StudentMainPageView extends LoginPageView{
    public void studentFunctionsPrompt() {
        System.out.println("Welcome to student Main Page");
        System.out.println("1. Add Course");
        System.out.println("2. Drop Course");
        System.out.println("3. Check/Print Courses Registered");
        System.out.println("4. Check Vacancies Available");
        System.out.println("5. Change Index Number of Course");
        System.out.println("6. Swap Index Number with Another Student");
        System.out.println("7. Log out");
        System.out.println("8. Exit");
    }

    public void addCourseFunctionPrompt() {
        System.out.println("Add Course");
        System.out.println("___________________________________");
    }

    public void addCourseFunctionSelectionPrompt(ArrayList<ICourse> courses) {
        System.out.println("Here's the list of available courses to choose from:");
        printCourses(courses);
        System.out.println("Please select the index of the course you will like to add: ");
    }

    public void invalidAccessPeriodError() {
        System.out.println("Now is not the access period. please check your actual access period");
    }

    public void noCourseError() {
        System.out.println("No courses available to choose from, please try again later");
    }

    public void errorRetrievingCourses() {
        System.out.println("Error retrieving courses");
    }

    public void addCourseSuccessMessage() {
        System.out.println("Course successfully added");
    }

    public void printCourses(ArrayList<ICourse> courses) {
        int i = 1;
        for (ICourse course : courses) {
            System.out.println("\t" + i++ + ": " + course.toString());
        }
    }

    public void dropCourseFunctionPrompt() {
        System.out.println("Drop Course");
        System.out.println("___________________________________");
    }

    public void dropCourseFunctionSelectionPrompt(ArrayList<ICourse> courses) {
        System.out.println("Here's the list of registered courses to choose from:");
        printCourses(courses);
        System.out.println("Please select the course code you will like to drop: ");
    }

    public void dropCourseSuccessMessage() {
        System.out.println("Course successfully dropped");
    }

    public void checkVacanciesAvailablePrompt() {
        System.out.println("Check Vacancies Available");
        System.out.println("___________________________________");
    }

    public void changeCourseIndexPrompt() {
        System.out.println("Change Index Number of Course");
        System.out.println("___________________________________");
    }

    public void swapCourseWithPeerPrompt() {
        System.out.println("Swap Index Number with Another Student");
        System.out.println("___________________________________");
    }

    public void checkVacanciesAvailableSelectionPrompt(ArrayList<ICourse> courses) {
        System.out.println("Select course to view vacancies:");
        printCourses(courses);
    }

    public void printCourseVacancies(ICourse course) {
        for (IIndex index : course.getIndexes()) {
            System.out.println(index.toString());
        }
    }

    public void logoutScreen() {
        System.out.println("logging out...");
    }

    public void fetchAccessPeriodError() {
        System.out.println("error fetching access period");
    }

    public void noAccessPeriodError() {
        System.out.println("student not assigned access period");
    }
}
