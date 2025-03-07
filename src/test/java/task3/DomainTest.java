package task3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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
        Voice humanVoice = new Voice(5,"deep voice");
        Voice furryVoice = new Voice(10, "безумное верещание");

        arthur = new Person("Артур", Size.MEDIUM, 75, 10, humanVoice, Emotion.HAPPY);
        furry = new Furry("Мохнатый", Size.VERY_SMALL, 2, 1, furryVoice, Emotion.ANGRY,60);

        cabinDoor = new Door("Дверь кабины", Material.IRON, Size.BIG, 20, State.CLOSED, 40);
        wideGap = new Gap(1.5, 0.5);
        narrowGap = new Gap(0.5, 0.5);

        System.setOut(new PrintStream(outputStream));
    }






    /*
        Тестирование makeSound для furry and person
    */






    @ParameterizedTest
    @CsvFileSource(resources = "/data_volume.csv", numLinesToSkip = 1)
    public void testFurrySoundVolume(int volume, int strength, Size size, Emotion emotion, double expectedValue) {
        Voice furryVoice = new Voice(volume, "верещание");
        furry = new Furry("Мохнатый", size, 2, strength, furryVoice, emotion,60);

        assertEquals(expectedValue, furry.makeSound(), 0.01);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data_volume.csv", numLinesToSkip = 1)
    public void testPersonSoundVolume(int volume, int strength, Size size, Emotion emotion, double expectedValue) {
        Voice personVoice = new Voice(volume, "шепот");
        arthur = new Person("Артур", size, 75, strength, personVoice, emotion);


        assertEquals(expectedValue,  arthur.makeSound(), 0.01);
    }


    /*
        Тестирование открытия/закрытия двери с разным уровнем прилегания
    */
    @Test
    public void testDoorLockFailsIfFittingTooLow(){
        cabinDoor.setFitting(20);
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
        cabinDoor.setFitting(50);
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
