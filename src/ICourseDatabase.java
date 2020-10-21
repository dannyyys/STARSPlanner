import java.util.ArrayList;

public interface ICourseDatabase {
    ArrayList<ICourse> read();
    void write(ArrayList<ICourse> courses);
}
