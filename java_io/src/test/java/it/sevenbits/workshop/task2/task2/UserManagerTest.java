package it.sevenbits.workshop.task2.task2;

import it.sevenbits.workshop.task2.ICollection;
import it.sevenbits.workshop.task2.User;
import it.sevenbits.workshop.task2.UserManager;
import it.sevenbits.workshop.task2.UserManagerException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserManagerTest {
    private UserManager userManager;
    private ICollection collection;
    private User user;
    @Before
    public void setUp() {
        this.collection = mock(ICollection.class);
        this.userManager = new UserManager(this.collection);
        this.user = new User("name", "role");
    }

    @Test
    public void getUserByIndexTest() {
        int number = 1;
        try {
            when(collection.get(number)).thenReturn(user);
            User tuser = this.userManager.getUserByIndex(number);
            assertEquals(this.user, tuser);
        } catch (UserManagerException e) {
            fail("UserManagerException");
        } catch (IOException e) {
            fail("IOException");
        }
    }

    @Test (expected = UserManagerException.class)
    public void getUserByIndexExceptionTest() throws UserManagerException, IOException{
        int number = 1;
        when(collection.get(number)).thenThrow(new IOException());
        this.userManager.getUserByIndex(number);
    }

    @Test
    public void createDefaultTest() throws IOException {
        final String DEFAULT_ROLE = "default";
        final String name = "name";
        try {
            this.userManager.createDefault("name");
        } catch (UserManagerException e) {
            fail("UserManagerException");
        }
        doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                User tuser = (User) invocationOnMock.getArguments()[0];
                assertEquals(name, tuser.getName());
                assertEquals(DEFAULT_ROLE, tuser.getRole());
                return null;
            }
        }).when(collection).add(any(User.class));
    }
    @Test (expected = UserManagerException.class)
    public void createDefaultExceptionTest() throws UserManagerException, IOException{
        String DEFAULT_ROLE = "default";
        String name = "name";
        doThrow(new IOException()).when(collection).add(any(User.class));
        this.userManager.createDefault(name);
    }
}
