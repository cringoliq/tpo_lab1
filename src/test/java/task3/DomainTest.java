package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DomainTest {
    private Person arthur;
    private Door cabinDoor;
    private Furry furry;
    private Gap wideGap;
    private Gap narrowGap;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();


    @BeforeEach
    public void setup(){
        Voice humanVoice = new Voice(5, 222, "deep voice");
        Voice furryVoice = new Voice(1, 999, "безумное верещание");

        arthur = new Person("Артур", Size.MEDIUM, 75, 10, humanVoice, Emotion.HAPPY);
        furry = new Furry("Мохнатый", Size.VERY_SMALL, 2, 1, furryVoice, 6);

        cabinDoor = new Door("Дверь кабины", Material.IRON, Size.BIG, 200, State.CLOSED, 4);
        wideGap = new Gap(1.5, 0.5);
        narrowGap = new Gap(0.5, 0.5);

        System.setOut(new PrintStream(outputStream));
    }






    /*
        Тестирование makeSound для furry and person
    */

    @Test
    public void testPersonMakesSound(){
        arthur.makeSound();
        String output = outputStream.toString().trim();
        assertEquals("Артур издает звук: deep voice", output);
    }

    @Test
    public void testFurryMakesSound(){
        furry.makeSound();
        String output = outputStream.toString().trim();
        assertEquals("Мохнатый издает верещание.", output);
    }


    /*
        Тестирование открытия/закрытия двери с разным уровнем прилегания
    */
    @Test
    public void testDoorLockFailsIfFittingTooLow(){
        cabinDoor.setFitting(2);
        cabinDoor.lock();

        assertNotEquals(State.CLOSED, cabinDoor.getState());
    }

    @Test
    public void testDoorUnlocksSuccessfully(){
        cabinDoor.unlock();
        assertEquals(State.OPEN, cabinDoor.getState());
    }

    @Test
    public void testDoorLocksSuccessfully(){
        cabinDoor.setFitting(6);
        cabinDoor.lock();
        assertEquals(State.CLOSED, cabinDoor.getState());
    }


    /*
        Тестирование корректного добавления действия в список к существам
    */
    @Test
    public void testPersonPushesDoor(){
        arthur.performAction(ActionType.MOVEMENT, "уперся плечом в дверь, стараясь запереть ее");
        assertEquals(ActionType.MOVEMENT, arthur.actions.get(0).getType());
    }

    @Test
    public void testFurry(){
        furry.performAction(ActionType.MOVEMENT, "защекотал до смерти");
        assertEquals(ActionType.MOVEMENT, furry.actions.get(0).getType());
    }


    /*
        Тестирование furry может просунуть руку через щель(
    */
    @Test
    public void testFurrySticksHandThroughWideGap() {
        furry.stickHand(wideGap);

        assertEquals("Мохнатый просунул руку через щель.", furry.actions.get(0).getDescription());
    }

    @Test
    public void testFurryFailsToStickHandThroughNarrowGap() {
        furry.stickHand(narrowGap);

        assertEquals("Мохнатый попытался просунуть руку, но не смог.", furry.actions.get(0).getDescription());
    }

}
