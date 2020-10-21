import java.util.ArrayList;
import java.util.List;

public interface IStudent {
    String getMetricNum();
    void setMetricNum(String metricNum);
    ArrayList<ICourse> getCourses();
    void addCourse(ICourse course);
    void dropCourse(ICourse course);
    List<Long> getAccessPeriod();
    void setAccessPeriod(long startDate, long endDate);
}
