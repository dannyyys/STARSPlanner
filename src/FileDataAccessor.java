import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileDataAccessor implements IDataAccessor{
    private IDatabase savedData;

    public FileDataAccessor(IDatabase serialisedFile) {
        this.savedData = serialisedFile;
    }

    @Override
    public ArrayList<IUser> getAllUsersData() {
        //do some error checking
        //temporary
        return savedData.getAllUsers();
    }

    @Override
    public List<Date> getAccessPeriod() {
        return null;
    }

    @Override
    public ArrayList<ICourse> getAllCoursesData() {
        return savedData.getAllCourses();
    }

    @Override
    public ArrayList<IStudent> getAllStudentsData() {
        return savedData.getAllStudents();
    }

    @Override
    public void saveAccessPeriod(Date start, Date end) {
        //write new access period into file
    }

    @Override
    public void saveCourseData(ICourse course) {

    }

    @Override
    public void saveStudentData(IStudent student) {
    }

    @Override
    public void saveUserData(String loginDetails) {

    }
}
