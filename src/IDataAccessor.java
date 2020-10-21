import java.util.ArrayList;

public interface IDataAccessor {
    ArrayList<IUser> getAllUsersData();
    ArrayList<ICourse> getAllCoursesData();
    ArrayList<IUser> getAllStudentsData();
    void saveAccessPeriod(long start, long end);
}
