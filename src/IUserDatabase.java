import java.util.ArrayList;

public interface IUserDatabase {
    ArrayList<IUser> read();
    void write(ArrayList<IUser> users);
}
