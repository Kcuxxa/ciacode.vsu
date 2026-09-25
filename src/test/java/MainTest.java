import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    void generateCreatesArrayOfGivenSize() {
        Main.generate(10, 0.5);
        assertEquals(10, Main.n);
        assertEquals(10, Main.flag.length);
    }

    @Test
    void generateWithZeroProbabilityNoDamaged() {
        Main.generate(100, 0.0);
        for (int i = 0; i < Main.n; i++) {
            assertFalse(Main.flag[i], "При p=0 все блоки целые");
        }
    }

    @Test
    void generateWithFullProbabilityAllDamaged() {
        Main.generate(50, 1.0);
        for (int i = 0; i < Main.n; i++) {
            assertTrue(Main.flag[i], "При p=1 все блоки повреждены");
        }
    }

    @Test
    void checkGroupOnSingleBlockReturnsItsFlag() {
        Main.m = 1;
        Main.generate(5, 0.0);
        Main.flag[2] = true;
        assertTrue(Main.checkGroup(2, 3), "Блок 2 повреждён");
        assertFalse(Main.checkGroup(0, 1), "Блок 0 целый");
    }

    @Test
    void checkGroupOnEmptyRangeReturnsFalse() {
        Main.m = 1;
        Main.generate(5, 1.0);
        assertFalse(Main.checkGroup(2, 2), "Пустая группа пуста");
    }
}