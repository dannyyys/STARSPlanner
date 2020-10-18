import java.util.ArrayList;

public class CourseController implements ICourseController{
    private ArrayList<ICourse>  courseList = null;
    @Override
    public void addCourse(ICourse course) {
        courseList.add(course);
    }

    @Override
    public void deleteCourse(ICourse course) {
        courseList.remove(course);
    }

    @Override
    public void modifyCourseInfo() {

    }

    @Override
    public void fetchCourseInfo() {

    }
}
