import java.util.ArrayList;

public class StarsPlannerApp {

    public static void main(String[] args) {

        IUserDatabase mockUserFile = new MockUserSerialisedFile();
        ICourseDatabase mockCourseFile = new MockCourseSerialisedFile();

        ArrayList<ICourse> courseList = new ArrayList<>();
        ArrayList<IUser> userList = new ArrayList<>();

        ICourse course = Factory.createCourse();
        course.setCourseCode("cz2001");
        IIndex index = Factory.createIndex();
        index.setIndexNum(1234);
        index.setVacancies(25);
        course.addIndex(index);

        index = Factory.createIndex();
        index.setIndexNum(2345);
        index.setVacancies(30);
        course.addIndex(index);
        courseList.add(course);

        course = Factory.createCourse();
        course.setCourseCode("cz2002");
        index = Factory.createIndex();
        index.setIndexNum(9876);
        index.setVacancies(10);
        course.addIndex(index);

        index.setIndexNum(8776);
        index.setVacancies(30);
        course.addIndex(index);
        courseList.add(course);

        mockCourseFile.write(courseList);

        IUser studentUser = Factory.createStudent();
        studentUser.setUsername("student");
        studentUser.setPassword("student");
        userList.add(studentUser);

        IUser adminUser = Factory.createAdmin();
        adminUser.setUsername("admin");
        adminUser.setPassword("admin");
        userList.add(adminUser);

        mockUserFile.write(userList);

        IDataAccessor dataAccessor = new FileDataAccessor(mockUserFile, mockCourseFile);
        boolean repeat;
        do {
            ILoginPageController loginPage = Factory.createLoginPageController();
            loginPage.getDataAccessor(dataAccessor);
            IMainPageController mainPage = loginPage.login();
            mainPage.addDataAccessor(dataAccessor);
            repeat = mainPage.performFunctions();
        } while (repeat);

    }
}
