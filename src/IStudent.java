import java.util.ArrayList;

public interface IStudent {
    String getName();
    void setName(String name);
    String getMetricNum();
    void setMetricNum(String metricNum);
    ArrayList<ICourse> getCourses();
    void setCourses(ArrayList<ICourse> courses);
}
