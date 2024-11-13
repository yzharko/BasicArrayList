package testgoth;

import org.junit.jupiter.api.Test;
import somegoth.Goth;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GothTest {
    @Test
    void getGothName() {
        final String name = "GothName";
        final int level = 10;

        Goth goth = new Goth(name, level);

        assertEquals(name, goth.getGothName());
    }
    @Test
    void getGothLevel() {
        final String name = "GothName";
        final int level = 10;

        Goth goth = new Goth(name, level);

        assertEquals(level, goth.getGothicLevel());
    }
    @Test
    void createGoth() {
        final String name = "GothName";
        final int level = 10;

        Goth goth = new Goth(name, level);

        assertEquals(name, goth.getGothName());
        assertEquals(level, goth.getGothicLevel());
    }
    @Test
    void getGothInfo() {
        final String name = "GothName";
        final int level = 10;

        Goth goth = new Goth(name, level);
        final String expected = name + " with goth level of " + level;

        assertEquals(expected, goth.getInfo());
    }
    @Test
    void getHashCodeForIdenticalGoths() {
        final String name = "GothName";
        final int level = 10;
        Goth goth = new Goth(name, level);

        final String yaName = "GothName";
        final int yaLevel = 10;
        Goth yaGoth = new Goth(yaName, yaLevel);

        int gothHashCode = goth.hashCode();
        int yaGothHashCode = yaGoth.hashCode();
        boolean actual = gothHashCode == yaGothHashCode;
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    void getHashCodeForDifferentGoths() {
        final String name = "GothName";
        final int level = 10;
        Goth goth = new Goth(name, level);

        final String yaName = "YaGothName";
        final int yaLevel = 20;
        Goth yaGoth = new Goth(yaName, yaLevel);

        int gothHashCode = goth.hashCode();
        int yaGothHashCode = yaGoth.hashCode();
        boolean actual = gothHashCode == yaGothHashCode;
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test
    void getEqualsMethodResultForIdenticalGoths() {
        final String name = "GothName";
        final int level = 10;
        Goth goth = new Goth(name, level);

        final String yaName = "GothName";
        final int yaLevel = 10;
        Goth yaGoth = new Goth(yaName, yaLevel);

        boolean actual = goth.equals(yaGoth);
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    void getEqualsMethodResultForDifferentGoths() {
        final String name = "GothName";
        final int level = 10;
        Goth goth = new Goth(name, level);

        final String yaName = "YaGothName";
        final int yaLevel = 20;
        Goth yaGoth = new Goth(yaName, yaLevel);

        boolean actual = goth.equals(yaGoth);
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test
    void getEqualsMethodResultForGothAndObject() {
        final String name = "GothName";
        final int level = 10;
        Goth goth = new Goth(name, level);

        Object object = new Object();

        boolean actual = goth.equals(object);
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test
    void compareIdenticalGoths() {
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
    void compareMinorGothToMajorGoth() {
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
    void compareMajorGothToMinorGoth() {
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
