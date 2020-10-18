public interface IDataAccessor {
    IMainPage fetchLoginDetails(String username, String password);
    void saveData(ICourse course);
    void saveData(IStudent student);
    void saveData(String loginDetails);
}
