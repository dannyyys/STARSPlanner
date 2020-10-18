import java.util.ArrayList;

public class StudentController implements IStudentController{
    private ArrayList<IStudent> _studentList = null;

    @Override
    public void addStudent(IStudent student) {
        this._studentList.add(student);
    }

    @Override
    public void deleteStudent(IStudent student) {
        this._studentList.remove(student);
    }

    @Override
    public void modifyStudentInfo() {

    }

    @Override
    public void fetchStudentInfo() {

    }
}
