public interface ILoginLogic {
    IMainPage login(String username, String password);
    int verifyLoginDetails(String username, String password);
    int verifyChoice(String input);
    void exit();
}
