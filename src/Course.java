import java.util.ArrayList;

public class Course implements ICourse {
    private String courseCode;
    private ArrayList<IIndex> indexes;

    public Course() {
        indexes = new ArrayList<>();
    }

    @Override
    public String getCourseCode() {
        return courseCode;
    }

    @Override
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public ArrayList<IIndex> getIndexes() {
        return indexes;
    }

    @Override
    public String toString() {
        return "courseCode='" + courseCode + '\'' +
                ", indexes=" + indexes;
    }

    @Override
    public void addIndex(IIndex index) {
        this.indexes.add(index);
    }
}
