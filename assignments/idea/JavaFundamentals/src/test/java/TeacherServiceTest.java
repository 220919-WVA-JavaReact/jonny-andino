import com.revature.courses.dao.TeacherDAO;
import com.revature.courses.models.Teacher;
import com.revature.courses.service.TeacherService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TeacherServiceTest {
    // we're going to create a fake teacher dao

    // first we create the class we want to mock

    @Mock
    static TeacherDAO td;
    // now that we've mocked our class we need to inject it to the teacher svc

    @InjectMocks
    private static TeacherService ts;

    // before we can do any testing, we need to initialize our mocks using mockito
    @Before
    public void initMocks(){
        System.out.println("This happens before each test");
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void deleteTeacherShouldReturnTrue(){
        // we need to specify what will return when we make a call to the teacherDAO
        when(td.deleteTeacher(any())).thenReturn(1);

        //we're now going to make sure that the svc returns true
        Assert.assertTrue(ts.deleteTeacher(new Teacher()));
    }

    @Test
    public void deleteTeacherShouldReturnFalse(){
        // we need to specify what will return when we make a call to the teacherDAO
        when(td.deleteTeacher(any())).thenReturn(0);

        //we're now going to make sure that the svc returns false
        Assert.assertFalse(ts.deleteTeacher(new Teacher()));
    }
}
