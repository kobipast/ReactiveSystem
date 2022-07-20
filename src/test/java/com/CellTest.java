package test.java.com;

import main.java.com.Cell;
import main.java.com.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {
    Cell cell;
    State state;
    @Test
    public void testUpdateStateValid() {
        init( "2,18,=2*{0},9,={2}+1*5");
        assertEquals(1,  cell.getValueAsInt());
    }

    private void init(String stateAsString) {
        state = new State();
        String[] baseStateArray = stateAsString.split(",");
        for (int i = 0; i < baseStateArray.length; i++) {
            Cell cell = new Cell(baseStateArray[i],state);
            state.getState().add(cell);
        }
        cell = new Cell("1",state);
    }
}
