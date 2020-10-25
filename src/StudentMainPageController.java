import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentMainPageController implements IMainPageController {
    StudentMainPageView _studentMainPageView;
    IDataAccessor _dataAccessor;
    Scanner _scanner;
    IStudent user;
    LoginPageController _LoginPageController;
    FileDataAccessor _FileDataAccessor;

    public StudentMainPageController(StudentMainPageView studentMainPageView,
                                     Scanner scanner) {
        this._studentMainPageView = studentMainPageView;
        this._scanner = scanner;
    }

    @Override
    public boolean performFunctions() {
        boolean logout = false;
        do {
            String input;
            boolean isValidChoice;
            do {
                _studentMainPageView.studentFunctionsPrompt();
                input = _scanner.nextLine();
                isValidChoice = validateFunctionSelectionChoice(input);
            } while (isValidChoice == false);

            int intInput = Integer.parseInt(input);
            switch (intInput) {
                case 1 -> addCourse();
                case 2 -> dropCourse();
                case 3 -> checkPrintCoursesRegistered();
                case 4 -> checkVacanciesAvailable();
                case 5 -> changeCourseIndex();
                case 6 -> swapCourseWithPeer();
                case 7 -> logout = logout();
                case 8 -> exit();
            }
        } while (logout == false);

        return logout;
    }

    @Override
    public void addUserInfo(IUser user) {
        this.user = (IStudent) user;
    }

    @Override
    public void addDataAccessor(IDataAccessor dataAccessor) {
        this._dataAccessor = dataAccessor;
    }

    private void exit() {
        _studentMainPageView.exitScreen();
        System.exit(0);
    }

    private boolean logout() {
        _studentMainPageView.logoutScreen();
        return true;
    }

    private boolean validateFunctionSelectionChoice(String input) {
        try {
            int intInput = Integer.parseInt(input);
            switch (intInput) {
                case 1, 2, 3, 4, 5, 6, 7, 8 -> {
                    return true;
                }
                default -> {
                    _studentMainPageView.inputOutOfBoundError();
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            _studentMainPageView.nonNumericInputError();
            return false;
        }
    }

    private boolean validateAccessPeriod() {
        List<Long> accessPeriod = user.getAccessPeriod();
        if (accessPeriod == null) {
            _studentMainPageView.fetchAccessPeriodError();
            return false;
        } else if (accessPeriod.isEmpty()) {
            _studentMainPageView.noAccessPeriodError();
            return false;
        } else if (accessPeriod.size() != 2) {
            _studentMainPageView.fetchAccessPeriodError();
            return false;
        }
        long now = System.currentTimeMillis();
        boolean isBetween = validateBetweenDates(now, accessPeriod.get(0), accessPeriod.get(1));
        if (isBetween == false) {
            _studentMainPageView.invalidAccessPeriodError();
        }
        return isBetween;
    }

    private boolean validateBetweenDates(long now, Long start, Long end) {
        return ( now >= start ) && (now < end);
    }

    private boolean validateCourseSelectionChoice(String input, int numOfCourses) {
        try {
            int intInput = Integer.parseInt(input);
            if (numOfCourses - intInput >= 0) {
                return true;
            } else {
                _studentMainPageView.inputOutOfBoundError();
                return false;
            }
        } catch (NumberFormatException e) {
            _studentMainPageView.nonNumericInputError();
            return false;
        }
    }

    private boolean validateCourseSelectionChoiceToChangeCourseIndex(String input, ArrayList<ICourse> courses) {
        
            //int intInput = Integer.parseInt(input);
            //boolean inside;
            int courseChoice = Integer.parseInt(input);
            for (ICourse i : courses) {
                if(input == courses.get(courseChoice-1).getCourseCode()){
                    return true;
                }
                else {
                _studentMainPageView.errorCourseNotRegistered();
                    return false;
            }
        }
        //return inside; 
        //catch (NumberFormatException e) {
            //_studentMainPageView.nonNumericInputError();
            //return false;
        //}
        return false;
    }

    private boolean validateCourseSelectionChoiceIndexToChangeCourseIndex(int input, ArrayList<IIndex> indexes) {
        
        //int intInput = Integer.parseInt(input);
        //boolean inside;

        for (IIndex i : indexes) {
            if(input == indexes.get(input-1).getIndexNum()){
                return true;
            }
            else {
            _studentMainPageView.errorIndexNotInCourse();
                return false;
        }
    }
    //return inside; 
    //catch (NumberFormatException e) {
        //_studentMainPageView.nonNumericInputError();
        //return false;
    //}
    return false;
}


    private boolean validateFetchUserData() {
        try {
            _dataAccessor.getAllCoursesData();
            return true;
        } catch(NullPointerException e) {
            _studentMainPageView.errorRetrievingCourses();
            return false;
        } catch (NegativeArraySizeException e) {
            _studentMainPageView.noCourseError();
            return false;
        }
    }

    public boolean validateFetchRegisteredCourses() {
        try {
            _dataAccessor.getAllCoursesData();
            return true;
        } catch(NullPointerException e) {
            _studentMainPageView.errorRetrievingCourses();
            return false;
        } catch (NegativeArraySizeException e) {
            _studentMainPageView.noCourseError();
            return false;
        }
    }

    private boolean validateUserInIndex(IStudent user, ArrayList<ICourse> userCourse, int courseChoice, int initialIndex){//check if user is in index enroll list
        for(IStudent i : userCourse.get(courseChoice-1).getIndexes().get(initialIndex).getEnrolledStudentList()){
            if(i.equals(user) == false){
                return false;
            }
            return true;
        }
        return true;
    }

    private void addCourse() {
        _studentMainPageView.addCourseFunctionPrompt();
        boolean isWithinAccessPeriod = validateAccessPeriod();
        if (isWithinAccessPeriod == false) {
            return;
        }

        boolean isValidFetchUserData = validateFetchUserData();
        if (isValidFetchUserData == false) {
            return;
        }
        ArrayList<ICourse> courses = _dataAccessor.getAllCoursesData();
        // check that the course is not already taken by the student
        // add in the option to select the index

        boolean isValidCourse;
        String input;
        do {
            _studentMainPageView.addCourseFunctionSelectionPrompt(courses);
            input = _scanner.nextLine();
            isValidCourse = validateCourseSelectionChoice(input, courses.size());
        } while(isValidCourse == false);

        int courseChoice = Integer.parseInt(input);
        user.addCourse(courses.get(courseChoice - 1));
        _studentMainPageView.addCourseSuccessMessage();
    }

    public void dropCourse() {
        _studentMainPageView.dropCourseFunctionPrompt();
        boolean isWithinAccessPeriod = validateAccessPeriod();
        if (isWithinAccessPeriod == false) {
            _studentMainPageView.invalidAccessPeriodError();
            return;
        }
        ArrayList<ICourse> registeredCourses = user.getCourses();
        if (registeredCourses.isEmpty()) {
            _studentMainPageView.noCourseError();
            return;
        }
        boolean isValidFetchRegisteredCourses = validateFetchRegisteredCourses();
        if (isValidFetchRegisteredCourses == false) {
            return;
        }
        ArrayList<ICourse> courses = _dataAccessor.getAllCoursesData();

        boolean isValidCourse;
        String input;
        do {
            _studentMainPageView.dropCourseFunctionSelectionPrompt(registeredCourses);
            input = _scanner.nextLine();
            isValidCourse = validateCourseSelectionChoice(input, registeredCourses.size());
        } while(isValidCourse == false);

        int courseChoice = Integer.parseInt(input);
        user.dropCourse(registeredCourses.get(courseChoice - 1));
        _studentMainPageView.dropCourseSuccessMessage();
    }

    private void checkPrintCoursesRegistered() {
        _studentMainPageView.printCourses(user.getCourses());
    }

    public void checkVacanciesAvailable() {
        _studentMainPageView.checkVacanciesAvailablePrompt();
        ArrayList<ICourse> courses = _dataAccessor.getAllCoursesData();
        if (courses == null) {
            _studentMainPageView.errorRetrievingCourses();
            return;
        } else if (courses.isEmpty()) {
            _studentMainPageView.noCourseError();
            return;
        }

        boolean isValidCourse;
        String input;
        do {
            _studentMainPageView.checkVacanciesAvailableSelectionPrompt(courses);
            input = _scanner.nextLine();
            isValidCourse = validateCourseSelectionChoice(input, courses.size());
        } while(isValidCourse == false);

        int courseChoice = Integer.parseInt(input);
        _studentMainPageView.printCourseVacancies(courses.get(courseChoice - 1));

    }

    public void changeCourseIndex() {  
        //int courseChoice = Integer.parseInt(input);
        ArrayList<ICourse> course = user.getCourses();
        ArrayList<ICourse> courseList = _dataAccessor.getAllCoursesData();
        boolean isValidCourse;
        boolean isValidIndex;
        String input;
        int inputIndex;
        int initialIndex;

        do {                                                    //check if course is already registered
            _studentMainPageView.changeCourseIndexPrompt();
            //checkPrintCoursesRegistered();
            input = _scanner.nextLine();
            isValidCourse = validateCourseSelectionChoiceToChangeCourseIndex(input, course);
        } while(isValidCourse == false);

        int courseChoice = Integer.parseInt(input);
        
        do {                                                    //check if index is valid
            _studentMainPageView.enterInitialIndexPrompt();
            initialIndex = _scanner.nextInt();
            _studentMainPageView.changeCourseIndexPromptIndex();
            _studentMainPageView.printCourseVacancies(courseList.get(courseChoice-1));
            inputIndex = _scanner.nextInt();
            isValidIndex = validateCourseSelectionChoiceIndexToChangeCourseIndex(inputIndex, courseList.get(courseChoice-1).getIndexes());
        } while(isValidIndex == false);

        if((courseList.get(courseChoice-1)).getIndexes().get(inputIndex-1).getVacancies() != 0){  //got vacancy
            courseList.get(courseChoice-1).getIndexes().get(inputIndex-1).addEnrolledStudentList(user);//add student into enroll list of the index
            int temp = courseList.get(courseChoice-1).getIndexes().get(inputIndex-1).getVacancies();    
            courseList.get(courseChoice-1).getIndexes().get(inputIndex-1).setVacancies(temp-1); //update course vacancy for the index
            
            courseList.get(courseChoice-1).getIndexes().get(initialIndex-1).removeEnrolledStudentList(user);//remove student from old index enrolled list
            temp = courseList.get(courseChoice-1).getIndexes().get(initialIndex-1).getVacancies();
            courseList.get(courseChoice-1).getIndexes().get(initialIndex-1).setVacancies(temp+1); //update old index vacancy
            _studentMainPageView.changeIndexSuccessMessage(); //print index successfully changed
        }

        else{   //index full
            courseList.get(courseChoice-1).getIndexes().get(inputIndex-1).addStudentWaitingList(user); //add student to waiting list
            _studentMainPageView.studentAddToWaitingListMessage();
        }

        _dataAccessor.saveCourseData();
        _dataAccessor.saveStudentData();

    }

    public void swapCourseWithPeer() {
        IStudent peer;
        ArrayList<ICourse> userCourse = user.getCourses();
        ArrayList<ICourse> peerCourse = peer.getCourses();

        _studentMainPageView.swapCourseWithPeerPrompt();
        _studentMainPageView.courseCodeToChangePrompt();
        String targetCourse = _scanner.nextLine();  //which course
        int courseChoice = Integer.parseInt(targetCourse); //convert to int
        //check if course selection is valid (to do)

        _studentMainPageView.printUserMetric(user);
        _studentMainPageView.enterInitialIndexPrompt(); //initial index
        int initialIndex = _scanner.nextInt();
        //check is index is valid (to do)
        
        if(validateUserInIndex(user, userCourse, courseChoice, initialIndex) == false){//check if user is in current index student list 
            _studentMainPageView.errorCourseNotRegistered();
            break;//if not registered, break
        }

        peer = (IStudent)getPeer();//DOWNCASTING!!!!!
        _studentMainPageView.enterPeerIndexPrompt();
        int peerIndex = _scanner.nextInt(); //peer index
        //check if index is valid (to do)

        if(validateUserInIndex(peer, peerCourse, courseChoice, peerIndex) == false){//check if peer is in current index student list 
            _studentMainPageView.errorCourseNotRegisteredForPeer();
            break;//if not registered, break
        }

        ArrayList<ICourse> courseList = _dataAccessor.getAllCoursesData();

        courseList.get(courseChoice-1).getIndexes().get(peerIndex-1).addEnrolledStudentList(user); //add user to peer index enroll list
        courseList.get(courseChoice-1).getIndexes().get(peerIndex-1).removeEnrolledStudentList(peer); //remove peer from peer index enroll list
        courseList.get(courseChoice-1).getIndexes().get(initialIndex-1).addEnrolledStudentList(peer); //add peer into user initial index enroll list
        courseList.get(courseChoice-1).getIndexes().get(initialIndex-1).removeEnrolledStudentList(user);  //remove user from initial index enroll list

        _studentMainPageView.indexSwapSuccessMessage(user, peer, initialIndex, peerIndex); //print swap success msg

        _dataAccessor.saveCourseData();
        _dataAccessor.saveStudentData();

        _FileDataAccessor.saveCourseData();
        _FileDataAccessor.saveStudentData();
    }

    private IUser getPeer() {
        boolean isValidUser;
        IUser input;
        do {
            _studentMainPageView.enterPeerUsernamePrompt();
            String username = _scanner.nextLine();
            _studentMainPageView.enterPeerPasswordPrompt();
            String password = _scanner.nextLine();

            input = Factory.createUser();
            input.setUsername(username);
            input.setPassword(password);

            isValidUser = validatePeer(input);
        } while (isValidUser == false);

        ArrayList<IUser> userList = _dataAccessor.getAllStudentsData();
        for (IUser user : userList) {
            if (user.equals(input)) {
                return user;
            }
        }
        return null;
    }

    private boolean validatePeer(IUser input) {
        ArrayList<IUser> userList = _dataAccessor.getAllUsersData();

        if (userList == null) {
            _studentMainPageView.noUserListError();
            exit();
            return false;
        }
        for (IUser user : userList) {
            if (user.equals(input)) {
                return true;
            }
        }
        _studentMainPageView.invalidUserError();
        return false;
    }
}
