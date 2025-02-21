package task3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DomainCoverageTest {

    // Тесты для класса Person
    @Test
    public void testPersonMakeSound() {
        Voice humanVoice = new Voice(5, 222, "deep voice");
        Person person = new Person("Артур", Size.MEDIUM, 75, 10, humanVoice, Emotion.HAPPY);
        person.makeSound();
        assertNotNull(person);
    }

    // Тесты для класса Furry
    @Test
    public void testFurryMakeSound() {
        Voice furryVoice = new Voice(1, 999, "безумное верещание");
        Furry furry = new Furry("Мохнатый", Size.VERY_SMALL, 2, 1, furryVoice, 6);
        furry.makeSound();
        assertNotNull(furry);
    }

    @Test
    public void testFurryStickHandWithNarrowGap() {
        Voice furryVoice = new Voice(1, 999, "безумное верещание");
        Furry furry = new Furry("Мохнатый", Size.VERY_SMALL, 2, 1, furryVoice, 6);
        Gap narrowGap = new Gap(0.5, 0.5);
        boolean canPass = narrowGap.canPass(furry);
        // Для узкой щели ожидание – пройти нельзя.
        assertFalse(canPass);
        furry.stickHand(narrowGap);
    }

    @Test
    public void testFurryStickHandWithWideGap() {
        Voice furryVoice = new Voice(1, 999, "безумное верещание");
        Furry furry = new Furry("Мохнатый", Size.VERY_SMALL, 2, 1, furryVoice, 6);
        Gap wideGap = new Gap(1.5, 0.5);
        boolean canPass = wideGap.canPass(furry);
        // Для широкой щели ожидание – пройти можно.
        assertTrue(canPass);
        furry.stickHand(wideGap);
    }

    // Тесты для класса Door
    @Test
    public void testDoorLockLowFitting() {
        // Если fitting меньше или равен 5, дверь не должна закрываться (согласно модифицированной логике)
        Door door = new Door("Дверь", Material.IRON, Size.BIG, 200, State.CLOSED, 4);
        door.lock();
        // В данном случае lock() установит состояние OPEN
        assertEquals(State.OPEN, door.state);
    }

    @Test
    public void testDoorLockHighFitting() {
        // Если fitting больше 5, дверь должна закрыться
        Door door = new Door("Дверь", Material.IRON, Size.BIG, 200, State.OPEN, 7);
        door.lock();
        assertEquals(State.CLOSED, door.state);
    }

    @Test
    public void testDoorUnlock() {
        Door door = new Door("Дверь", Material.IRON, Size.BIG, 200, State.CLOSED, 7);
        door.unlock();
        assertEquals(State.OPEN, door.state);
    }

    @Test
    public void testDoorChangeState() {
        Door door = new Door("Дверь", Material.IRON, Size.BIG, 200, State.OPEN, 7);
        door.changeState(State.HALF_OPEN);
        assertEquals(State.HALF_OPEN, door.state);
    }

    // Тесты для класса Gap
    @Test
    public void testGapCanPassEqualThreshold() {
        // При ширине ровно 1.5, по логике, щель должна позволять пройти.
        Gap gap = new Gap(1.5, 1.0);
        Voice voice = new Voice(5, 200, "voice");
        Person person = new Person("Test", Size.MEDIUM, 70, 10, voice, Emotion.HAPPY);
        boolean result = gap.canPass(person);
        assertTrue(result);
    }

    @Test
    public void testGapCanPassBelowThreshold() {
        // При ширине меньше порогового значения
        Gap gap = new Gap(1.4, 1.0);
        Voice voice = new Voice(5, 200, "voice");
        Person person = new Person("Test", Size.MEDIUM, 70, 10, voice, Emotion.HAPPY);
        boolean result = gap.canPass(person);
        assertFalse(result);
    }

    @Test
    public void testGapCanPassAboveThreshold() {
        // При ширине больше порогового значения
        Gap gap = new Gap(2.0, 1.0);
        Voice voice = new Voice(5, 200, "voice");
        Person person = new Person("Test", Size.MEDIUM, 70, 10, voice, Emotion.HAPPY);
        boolean result = gap.canPass(person);
        assertTrue(result);
    }

    // Тест для класса Action
    @Test
    public void testActionProperties() {
        Action action = new Action(ActionType.MOVEMENT, "Перемещение");
        assertEquals(ActionType.MOVEMENT, action.getType());
        assertEquals("Перемещение", action.getDescription());
    }

    // Тест для класса Voice
    @Test
    public void testVoiceGetDescription() {
        Voice voice = new Voice(10, 100, "громкий голос");
        assertEquals("громкий голос", voice.getDescription());
    }
}
