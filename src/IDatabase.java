import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IDatabase {
    ArrayList<IUser> getAllUsers();
    ArrayList<IStudent> getAllStudents();
    ArrayList<ICourse> getAllCourses();
    List<Date> getAccessPeriod();
}
