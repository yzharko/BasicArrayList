package testgoth;

import org.junit.jupiter.api.Test;
import somegoth.Goth;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GothTest {
    @Test
    public void getGothName() {
        final String name = "GothName";
        final int level = 10;

        Goth goth = new Goth(name, level);

        assertEquals(name, goth.getGothName());
    }
    @Test
    public void getGothLevel() {
        final String name = "GothName";
        final int level = 10;

        Goth goth = new Goth(name, level);

        assertEquals(level, goth.getGothicLevel());
    }
    @Test
    public void createGoth() {
        final String name = "GothName";
        final int level = 10;

        Goth goth = new Goth(name, level);

        assertEquals(name, goth.getGothName());
        assertEquals(level, goth.getGothicLevel());
    }
    @Test
    public void getGothInfo() {
        final String name = "GothName";
        final int level = 10;

        Goth goth = new Goth(name, level);
        final String expected = name + " with goth level of " + level;

        assertEquals(expected, goth.getInfo());
    }
    @Test
    public void compareIdenticalGoths() {
        final String name = "GothName";
        final int level = 10;
        Goth goth = new Goth(name, level);

        final String yaName = "GothName";
        final int yaLevel = 10;
        Goth yaGoth = new Goth(yaName, yaLevel);

        int expected = 0;
        assertEquals(expected, goth.compareTo(yaGoth));
    }
    @Test
    public void compareMinorGothToMajorGoth() {
        final String name = "GothName";
        final int level = 10;
        Goth goth = new Goth(name, level);

        final String yaName = "GothName";
        final int yaLevel = 20;
        Goth yaGoth = new Goth(yaName, yaLevel);

        int expected = -1;
        assertEquals(expected, goth.compareTo(yaGoth));
    }
    @Test
    public void compareMajorGothToMinorGoth() {
        final String name = "GothName";
        final int level = 20;
        Goth goth = new Goth(name, level);

        final String yaName = "GothName";
        final int yaLevel = 10;
        Goth yaGoth = new Goth(yaName, yaLevel);

        int expected = 1;
        assertEquals(expected, goth.compareTo(yaGoth));
    }
}
