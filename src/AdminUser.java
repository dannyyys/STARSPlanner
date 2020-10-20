public class AdminUser implements IUser{
    private String username;
    private String password;
    private String name;
    private IMainPageController mainPageController;

    public AdminUser(IMainPageController mainPageController) {
        this.mainPageController = mainPageController;
    }

    @Override
    public IMainPageController getMainPageController(IUser user) {
        mainPageController.addUserInfo(user);
        return mainPageController;
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
