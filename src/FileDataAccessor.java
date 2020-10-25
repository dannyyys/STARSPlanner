import java.util.ArrayList;

public class FileDataAccessor implements IDataAccessor{
    private IUserDatabase savedUserData;
    private ICourseDatabase savedCourseData;

    private ArrayList<ICourse> allCourses;
    private ArrayList<IUser> allStudents;

    public FileDataAccessor(IUserDatabase serialisedUserFile, ICourseDatabase serialisedCourseData) {
        this.savedUserData = serialisedUserFile;
        this.savedCourseData = serialisedCourseData;
    }

    @Override
    public ArrayList<IUser> getAllUsersData() {
        ArrayList<IUser> allUsers = savedUserData.read();
        if (allUsers == null) {
            throw new NullPointerException();
        } else if (allUsers.isEmpty()) {
            throw new NegativeArraySizeException();
        } else {
            return allUsers;
        }
    }

    @Override
    public ArrayList<ICourse> getAllCoursesData() {
        if (allCourses == null) {
            allCourses = savedCourseData.read();
        }

        if (allCourses.isEmpty()) {
            throw new NegativeArraySizeException();
        } else {
            return allCourses;
        }
    }

    @Override
    public ArrayList<IUser> getAllStudentsData() {
        if (allStudents == null) {
            ArrayList<IUser> allUsers = savedUserData.read();
            allStudents = new ArrayList<>();
            for (IUser user : allUsers) {
                if (user instanceof IStudent) {
                    allStudents.add(user);
                }
            }
        }
        if (allStudents.isEmpty()) {
            throw new NegativeArraySizeException();
        }
        return allStudents;
    }

    @Override
    public void saveAccessPeriod(long start, long end) {
        if (allStudents == null) {
            getAllStudentsData();
        } else if (allStudents.isEmpty()) {
            throw new NegativeArraySizeException();
        }
        for (IUser studentUser : allStudents) {
            IStudent student = (IStudent) studentUser;
            student.setAccessPeriod(start, end);
        }
        saveStudentData();
    }

    public void saveCourseData() {
        if (allCourses == null) {
            getAllCoursesData();
        }
        savedCourseData.write(allCourses);
        //serialise that file
    }

    private void saveStudentData() { //w
        if (allStudents == null) {
            getAllStudentsData();
        }
        ArrayList<IUser> users = getAllUsersData();
        for (int i = 0; i < users.size(); i++) {
            for (IUser studentUser : allStudents) {
                if (users.get(0).equals(studentUser)) {
                    users.set(i, studentUser);
                    break;
                }
            }
        }
        savedUserData.write(users);
        //serialise that file
    }
}
