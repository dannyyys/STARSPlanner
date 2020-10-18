import java.util.ArrayList;

public class Course implements ICourse{
    private String courseCode;
    private ArrayList<IIndex> indexes;

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
    public void setGetIndexes(ArrayList<IIndex> indexes) {
        this.indexes = indexes;
    }
}
