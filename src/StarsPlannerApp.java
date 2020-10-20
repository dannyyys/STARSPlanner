public class StarsPlannerApp {

    public static void main(String[] args) {
        boolean repeat;
        do {
            ILoginPageController loginPage = Factory.createLoginPageController();

            IMainPageController mainPage = loginPage.login();

            repeat = mainPage.performFunctions();
        } while (repeat);

    }
}
