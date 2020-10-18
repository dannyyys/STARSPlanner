import java.util.Scanner;

public class Factory {
    public static ILoginPage createLoginPage() {
        return new LoginPage(createLoginLogic(), new Scanner(System.in));
    }

    public static ILoginLogic createLoginLogic() {
        return new LoginLogic(createDataAccessor());
    }

    public static IMainPage createStudentMainPage() {
        return new StudentMainPage(createStudentMainPageLogic(), new Scanner(System.in));
    }

    public static IMainPage createAdminMainPage() {
        return new AdminMainPage(createAdminMainPageLogic(), new Scanner(System.in));
    }

    public static IDataAccessor createDataAccessor() {
        return new FileDataAccessor(createDatabase());
    }

    public static IDatabase createDatabase() {
        return new SerialisedFile();
    }

    public static IMainPageLogic createStudentMainPageLogic() {
        return new StudentMainPageLogic(createStudentController(), createCourseController());
    }

    public static IMainPageLogic createAdminMainPageLogic() {
        return new AdminMainPageLogic(createStudentController(), createCourseController());
    }

    public static IStudentController createStudentController() {
        return new StudentController();
    }

    public static ICourseController createCourseController() {
        return new CourseController();
    }

    public static IStudent createStudent() {
        return new Student();
    }

    public static ICourse createCourse() {
        return new Course();
    }

    public static IIndex createIndex() {
        return new Index();
    }
}
