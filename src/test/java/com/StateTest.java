package test.java.com;

import main.java.com.Cell;
import main.java.com.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateTest {
    State state;

    @Test
    public void testUpdateStateValid() {
        initState( "2,18,=2*{0},9,={2}+1*5");
        String expression = "b 2 8";
        state.updateState(expression);
        assertEquals(8,  state.getState().get(2).getValueAsInt());
    }

    private void initState(String stateAsString) {
        state = new State();
        String[] baseStateArray = stateAsString.split(",");
        for (int i = 0; i < baseStateArray.length; i++) {
            Cell cell = new Cell(baseStateArray[i],state);
            state.getState().add(cell);
        }
    }
}
