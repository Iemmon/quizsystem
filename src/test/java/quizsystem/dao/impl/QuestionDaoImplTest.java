package quizsystem.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import quizsystem.entity.Question;
import quizsystem.injector.ApplicationInjector;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class QuestionDaoImplTest {

    private QuestionDaoImpl questionDaoImpl;

    @Before
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        Class<ApplicationInjector> injectorClass = ApplicationInjector.class;
        Field questionDao = injectorClass.getDeclaredField("QUESTION_DAO");
        questionDao.setAccessible(true);
        questionDaoImpl = (QuestionDaoImpl) questionDao.get(null);
    }

    @Test
    public void findAllByTestIdShouldReturnListOfQuestions() {
        List<Question> questionListList = questionDaoImpl.findAllByTestId(1L);
        assertEquals(3, questionListList.size());
    }

}