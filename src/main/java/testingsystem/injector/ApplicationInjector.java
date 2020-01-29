package testingsystem.injector;

import testingsystem.dao.ConnectionPool;
import testingsystem.dao.HikariCPDataSource;
import testingsystem.dao.impl.QuestionDaoImpl;
import testingsystem.dao.impl.TopicDaoImpl;
import testingsystem.dao.impl.UserDaoImpl;
import testingsystem.dao.interfacepack.QuestionDao;
import testingsystem.dao.interfacepack.TopicDao;
import testingsystem.dao.interfacepack.UserDao;
import testingsystem.entity.User;
import testingsystem.service.PasswordEncryption;
import testingsystem.service.impl.UserServiceImpl;
import testingsystem.service.interfacepack.UserService;
import testingsystem.service.validator.UserValidator;
import testingsystem.service.validator.Validator;

public class ApplicationInjector {

    private static final ApplicationInjector INSTANCE = new ApplicationInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final PasswordEncryption PASSWORD_ENCRYPTION = new PasswordEncryption();

    private static final ConnectionPool DATA_SOURCE = new HikariCPDataSource();

//    TODO: Change to private
    public static final UserDao USER_DAO = new UserDaoImpl(DATA_SOURCE);
    public static final QuestionDao QUESTION_DAO = new QuestionDaoImpl(DATA_SOURCE);

    private static final UserService USER_SERVICE = new UserServiceImpl(USER_DAO, PASSWORD_ENCRYPTION, USER_VALIDATOR);

    private ApplicationInjector() {

    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }
}