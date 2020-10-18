public class LoginLogic implements ILoginLogic {
    String username;
    String password;
    private IDataAccessor _dataAccessor;

    public LoginLogic(IDataAccessor dataAccessor) {
        this._dataAccessor = dataAccessor;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public IMainPage login(String username, String password) {
        return _dataAccessor.fetchLoginDetails(username, password);
    }

    @Override
    public int verifyLoginDetails(String username, String password) {
        int status;
        if (_dataAccessor.fetchLoginDetails(username, password) == null) {
            status = 1;
        } else {
            status = 0;
        }
        return status;
    }

    @Override
    public int verifyChoice(String input) {
        int status;
        try {
            int intInput = Integer.parseInt(input);
            if (intInput == 1) {
                status = 0;
            } else if (intInput == 2) {
                status = -1;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            status = 1;
        } catch (IllegalArgumentException e) {
            status = 2;
        }
        return status;
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
