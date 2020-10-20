import java.util.ArrayList;

public interface IStudent {
    String getMetricNum();
    void setMetricNum(String metricNum);
    ArrayList<ICourse> getCourses();
    void addCourse(ICourse course);
    void dropCourse(ICourse course);
}
