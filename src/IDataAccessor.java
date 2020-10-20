import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IDataAccessor {
    ArrayList<IUser> getAllUsersData();
    List<Date> getAccessPeriod();
    ArrayList<ICourse> getAllCoursesData();
    ArrayList<IStudent> getAllStudentsData();
    void saveAccessPeriod(Date start, Date end);
    void saveCourseData(ICourse course);
    void saveStudentData(IStudent student);
    void saveUserData(String loginDetails);
}
