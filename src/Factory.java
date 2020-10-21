import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Factory {
    public static LoginPageView createLoginPageView() {
        return new LoginPageView();
    }

    public static StudentMainPageView createStudentMainPageView() {
        return new StudentMainPageView();
    }

    public static ILoginPageController createLoginPageController() {
        return new LoginPageController(createLoginPageView(), new Scanner(System.in));
    }

    public static IMainPageController createStudentMainPageController() {
        return new StudentMainPageController(createStudentMainPageView(), new Scanner(System.in));
    }

    public static AdminMainPageView createAdminMainPageView() {
        return new AdminMainPageView();
    }

    public static IMainPageController createAdminMainPageController() {
        return new AdminMainPageController(createAdminMainPageView(), new Scanner(System.in),
                new SimpleDateFormat("dd.MM.yyyy, HH:mm", Locale.ENGLISH));
    }

//    public static IDataAccessor createDataAccessor() {
//        return new FileDataAccessor(createMockUserFile(), createMockCourseFile());
//    }

    public static IUser createStudent() {
        return new StudentUser(createStudentMainPageController());
    }

    public static IUser createAdmin() {
        return new AdminUser(createAdminMainPageController());
    }
    public static IUser createUser() {
        return new User();
    }

    public static ICourse createCourse() {
        return new Course();
    }

    public static IIndex createIndex() {
        return new Index();
    }
}
