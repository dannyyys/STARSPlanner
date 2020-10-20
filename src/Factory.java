import java.text.SimpleDateFormat;
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
        return new LoginPageController(createLoginPageView(), createDataAccessor(), new Scanner(System.in));
    }

    public static IMainPageController createStudentMainPageController() {
        return new StudentMainPageController(createStudentMainPageView(), createDataAccessor(), new Scanner(System.in));
    }

    public static AdminMainPageView createAdminMainPageView() {
        return new AdminMainPageView();
    }

    public static IMainPageController createAdminMainPageController() {
        return new AdminMainPageController(createAdminMainPageView(), createDataAccessor(), new Scanner(System.in),
                new SimpleDateFormat("dd.MM.yyyy, HH:mm", Locale.ENGLISH));
    }

    public static IDataAccessor createDataAccessor() {
        return new FileDataAccessor(createDatabase());
    }

    public static IDatabase createDatabase() {
        return new MockSerialisedFile();
    }

//    public static IStudentController createStudentController() {
//        return new StudentController();
//    }
//
//    public static ICourseController createCourseController() {
//        return new CourseController();
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
