import java.util.ArrayList;

public class MockUserSerialisedFile implements IUserDatabase {
    private ArrayList<IUser> allUsers = new ArrayList<>();

    @Override
    public ArrayList<IUser> read() {
        return this.allUsers;
    }

    @Override
    public void write(ArrayList<IUser> users) {
        this.allUsers = users;
    }
}
