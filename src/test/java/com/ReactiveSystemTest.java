package test.java.com;

import main.java.com.ReactiveSystem;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class ReactiveSystemTest {

    ReactiveSystem reactiveSystem = new ReactiveSystem();
    @Test
    public void testInit() {
        String state = "2,18,=2*{0},9,={2}+1*5";
        reactiveSystem.init(state);
        assertNotNull(reactiveSystem.getBaseState());
    }


}
