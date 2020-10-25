import java.util.ArrayList;

public interface IIndex {
    int getIndexNum();
    void setIndexNum(int indexNum);
    ArrayList<IStudent> getStudentWaitingList();
    void setStudentWaitingList(ArrayList<IStudent> studentWaitingList);
    void addStudentWaitingList(IStudent user);
    void removeStudentWaitingList(IStudent user);
    ArrayList<IStudent> getEnrolledStudentList();
    void setEnrolledStudentList(ArrayList<IStudent> enrolledStudentList);
    void addEnrolledStudentList(IStudent user);
    void removeEnrolledStudentList(IStudent user);
    int getVacancies();
    void setVacancies(int vacancies);
}
