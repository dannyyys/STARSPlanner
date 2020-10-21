import java.util.ArrayList;

public class MockCourseSerialisedFile implements ICourseDatabase{
    private ArrayList<ICourse> allCourses = new ArrayList<>();

    @Override
    public ArrayList<ICourse> read() {
        return allCourses;
    }

    @Override
    public void write(ArrayList<ICourse> courses) {
        this.allCourses = courses;
    }
}
