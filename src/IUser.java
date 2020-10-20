public interface IUser{
    IMainPageController getMainPageController(IUser user);
    String getName();
    void setName(String name);
    String getUsername();
    void setUsername(String username);
    String getPassword();
    void setPassword(String password);

    boolean equals(IUser user);
}
