package resource;

import com.loginExample.dao.PersonDAO;
import com.loginExample.resource.LoginExampleResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ViewsResourceTest {

    private static final PersonDAO dao = mock(PersonDAO.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new LoginExampleResource(dao))
            .build();

    @Before
    public void setup() {
        when(dao.checkDetails(anyString(), anyString())).thenReturn(1);
    }

    @Test
    public void testLogin(){
        //TODO : Learn how to test Post method using Form Params
    }

    @Test
    public void testCreatePersonView(){
    }

    @Test
    public void testDeleteUserView(){
    }

    @Test
    public void testViewAllPeopleView(){
    }

    @Test
    public void testFindByIdView(){
    }

    @Test
    public void testLoginPageView(){
    }

}
