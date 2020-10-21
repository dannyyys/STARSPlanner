import java.util.ArrayList;

public interface IUserController {
    ArrayList<IUser> getAllUsers();
    ArrayList<IStudent> getAllStudents();
    void setAllStudents(ArrayList<IStudent> allStudents);
    void setAllUsers(ArrayList<IUser> allUsers);
}
