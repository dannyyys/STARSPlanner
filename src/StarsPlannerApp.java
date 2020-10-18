public class StarsPlannerApp {

    public static void main(String[] args) {
        int status;
        do {
            ILoginPage loginPage = Factory.createLoginPage();
            loginPage.loginDisplay();

            IMainPage mainPage = loginPage.login();
            status = mainPage.mainPageDisplay();
        } while (status != 0);

    }
}
