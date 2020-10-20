import java.util.ArrayList;

public class Index implements IIndex {
    int indexNum;
    ArrayList<IStudent> studentWaitingList;
    ArrayList<IStudent> enrolledStudentList;
    int vacancies;

    @Override
    public String toString() {
        return "indexNum=" + indexNum +
                ", vacancies=" + vacancies;
    }

    public Index() {
        studentWaitingList = new ArrayList<>();
        enrolledStudentList = new ArrayList<>();
    }
    @Override
    public int getIndexNum() {
        return indexNum;
    }

    @Override
    public void setIndexNum(int indexNum) {
        this.indexNum = indexNum;
    }

    @Override
    public ArrayList<IStudent> getStudentWaitingList() {
        return studentWaitingList;
    }

    @Override
    public void setStudentWaitingList(ArrayList<IStudent> studentWaitingList) {
        this.studentWaitingList = studentWaitingList;
    }

    @Override
    public ArrayList<IStudent> getEnrolledStudentList() {
        return enrolledStudentList;
    }

    @Override
    public void setEnrolledStudentList(ArrayList<IStudent> enrolledStudentList) {
        this.enrolledStudentList = enrolledStudentList;
    }

    @Override
    public int getVacancies() {
        return vacancies;
    }

    @Override
    public void setVacancies(int vacancies) {
        this.vacancies = vacancies;
    }
}
