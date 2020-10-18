import java.util.ArrayList;

public class Student implements IStudent {
    private String name;
    private String metricNum;
    private ArrayList<ICourse> courses;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getMetricNum() {
        return metricNum;
    }

    @Override
    public void setMetricNum(String metricNum) {
        this.metricNum = metricNum;
    }

    @Override
    public ArrayList<ICourse> getCourses() {
        return courses;
    }

    @Override
    public void setCourses(ArrayList<ICourse> courses) {
        this.courses = courses;
    }
}
