import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MockSerialisedFile implements IDatabase {
    private ArrayList<IUser> allUsers = new ArrayList<>();
    private ArrayList<IStudent> allStudents = new ArrayList<>();
    private ArrayList<ICourse> allCourses = new ArrayList<>();
    private List<Date> AccessPeriod;

    @Override
    public ArrayList<IUser> getAllUsers() {
        IUser studentUser = Factory.createStudent();
        studentUser.setUsername("student");
        studentUser.setPassword("student");
        allUsers.add(studentUser);
        IUser adminUser = Factory.createAdmin();
        adminUser.setUsername("admin");
        adminUser.setPassword("admin");
        allUsers.add(adminUser);
        return this.allUsers;
    }

    @Override
    public ArrayList<IStudent> getAllStudents() {
        return this.allStudents;
    }

    @Override
    public ArrayList<ICourse> getAllCourses() {
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
        allCourses.add(course);

        course = Factory.createCourse();
        course.setCourseCode("cz2002");
        index = Factory.createIndex();
        index.setIndexNum(9876);
        index.setVacancies(10);
        course.addIndex(index);
        index.setIndexNum(8776);
        index.setVacancies(30);
        course.addIndex(index);
        allCourses.add(course);
        return this.allCourses;
    }

    @Override
    public List<Date> getAccessPeriod() {
        return this.AccessPeriod;
    }
}
