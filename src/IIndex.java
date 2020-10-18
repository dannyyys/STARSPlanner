import java.util.ArrayList;

public interface IIndex {
    int getIndexNum();
    void setIndexNum(int indexNum);
    ArrayList<IStudent> getStudentWaitingList();
    void setStudentWaitingList(ArrayList<IStudent> studentWaitingList);
    ArrayList<IStudent> getEnrolledStudentList();
    void setEnrolledStudentList(ArrayList<IStudent> enrolledStudentList);
    int getVacancies();
    void setVacancies(int vacancies);
}
