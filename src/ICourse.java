import java.util.ArrayList;

public interface ICourse {
    String getCourseCode();
    void setCourseCode(String courseCode);
    ArrayList<IIndex> getIndexes();
    void addIndex(IIndex index);
}
