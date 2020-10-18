public class FileDataAccessor implements IDataAccessor{
    private IDatabase loginData;

    public FileDataAccessor(IDatabase serialisedFile) {
        this.loginData = serialisedFile;
    }

    @Override
    public IMainPage fetchLoginDetails(String username, String password) {
        IMainPage mainPage;
//        if (username, password is student) {
//            mainPage = factory.create(student mainpage)
//        } else if (username, password is student) {
//            mainPage = factory.create(admin mainpage)
//        } else {
//            mainPage = null;
        mainPage = Factory.createAdminMainPage();
        return mainPage;
    }

    @Override
    public void saveData(ICourse course) {

    }

    @Override
    public void saveData(IStudent student) {

    }

    @Override
    public void saveData(String loginDetails) {

    }
}
