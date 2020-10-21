import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentUser implements IUser, IStudent {
    private String username;
    private String password;
    private String name;
    private String metricNum;
    private List<Long> accessPeriod;
    private ArrayList<ICourse> courses = new ArrayList<>();
    private IMainPageController mainPageController;

    public StudentUser(IMainPageController mainPageController) {
        this.mainPageController = mainPageController;
    }

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
    public void addCourse(ICourse course) {
        this.courses.add(course);
    }

    @Override
    public void dropCourse(ICourse course) {
        this.courses.remove(course);
    }

    @Override
    public List<Long> getAccessPeriod() {
        return this.accessPeriod;
    }

    @Override
    public void setAccessPeriod(long startDate, long endDate) {
        accessPeriod.clear();
        accessPeriod.add(startDate);
        accessPeriod.add(endDate);
    }

    @Override
    public IMainPageController getMainPageController(IUser user) {
        mainPageController.addUserInfo(user);
        return mainPageController;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(IUser user) {
        return username.equals(user.getUsername()) && password.equals(user.getPassword());
    }
}
