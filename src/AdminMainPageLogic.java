public class AdminMainPageLogic implements IMainPageLogic{
    private IStudentController _studentController;
    private ICourseController _courseController;

    public AdminMainPageLogic(IStudentController studentController, ICourseController courseController) {
        this._studentController = studentController;
        this._courseController = courseController;
    }

    @Override
    public int verifyChoice(String input) {
        int status;
        try {
            int intInput = Integer.parseInt(input);
            switch (intInput) {
                case 1, 2, 3, 4, 5, 6 -> status = 0;
                case 7 -> status = -1;
                case 8 -> status = -2;
                default -> throw new IllegalArgumentException();
            };
        } catch (NumberFormatException e) {
            status = 1;
        } catch (IllegalArgumentException e) {
            status = 2;
        }
        return status;
    }

    @Override
    public boolean logout() {
        return true;
    }
}
