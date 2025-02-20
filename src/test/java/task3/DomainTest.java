package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DomainTest {
    private Person arthur;
    private Door cabinDoor;

    private Furry furry;
    private Gap wideGap;
    private Gap narrowGap;

    @BeforeEach
    public void setup(){
        Voice humanVoice = new Voice(5,222, "deep voice");
        Voice furryVoice = new Voice(1,999, "безумное верещание");

        arthur = new Person("Артур", Size.MEDIUM, 75, 10, humanVoice, Emotion.HAPPY);
        furry = new Furry("Мохнатый", Size.VERY_SMALL, 2, 1, furryVoice, 6);

        cabinDoor = new Door("Дверь кабины", Material.IRON, Size.BIG, 200, State.CLOSED, 4);
        wideGap = new Gap(1.5, 0.5);
        narrowGap = new Gap(0.5, 0.5);


    }

    // тест дверь кабины не должна закрыться из-за плохого прилегания

    @Test
    public void testPersonCloseDoorFail(){
        arthur.closeDoor(cabinDoor);

        assertNotEquals(State.CLOSED, cabinDoor.state);
    }

    // тест дверь кабины должна закрыться из-за нового уровня прилегания
    @Test
    public void testPersonCloseDoorSuccess(){
        cabinDoor.fitting = 7;
        arthur.closeDoor(cabinDoor);
        assertEquals(State.CLOSED, cabinDoor.state);
    }

    // фурри не может пролезть через щель
    @Test
    public void testFurryThroughGapFail(){
        boolean canPass = narrowGap.canPass(furry);
        furry.stickHand(narrowGap);
        assertFalse(canPass);
    }
    // фурри может пролезть через щель
    @Test
    public void testFurryThroughGapSuccess(){
        boolean canPass = wideGap.canPass(furry);
        furry.stickHand(wideGap);
        assertTrue(canPass);
    }

    // Тест методов makeSound
    @Test
    public void testCreatureMakeSound(){
        arthur.makeSound();
        furry.makeSound();

        assertNotNull(arthur);
        assertNotNull(furry);
    }

    // Тест проверка изменения состояния двери
    @Test
    public void testDoorStateChange(){
        cabinDoor.unlock();
        assertEquals(State.OPEN, cabinDoor.state);

        cabinDoor.changeState(State.HALF_OPEN);
        assertEquals(State.HALF_OPEN, cabinDoor.state);
    }

}
