import com.example.Alex;
import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LionTest {

    @Mock
    private Feline felineMock;
    private Lion lion;

    @BeforeEach
    void setUp() throws Exception {
        lion = new Lion("Самка", felineMock);
    }

    @Test
    public void doesHaveManeFemale(){
        Assertions.assertFalse(lion.doesHaveMane(), "У самки не может быть гривы");
    }

    @Test
    public void doesHaveManeMale() throws Exception {
        Lion maleLion = new Lion("Самец", felineMock);
        Assertions.assertTrue(maleLion.doesHaveMane(), "У самца может быть гривы");
    }

    @Test
    public void shouldThrowExceptionForInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Собака", felineMock);
        });
        assertTrue(exception.getMessage().contains("допустимые значения"));
    }

    @Test
    public void getKitten(){
        Mockito.when(felineMock.getKittens()).thenReturn(1);
        int result = lion.getKittens();
        assertEquals(1, result);
        Mockito.verify(felineMock).getKittens();
    }

    @Test
    public void getFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
        Mockito.verify(felineMock).getFood("Хищник");
    }
}

@ExtendWith(MockitoExtension.class)
class CatTest {
    @Mock
    private Feline felineMock;
    private Cat cat;

    @BeforeEach
    void setUp(){
        cat = new Cat(felineMock);
    }

    @Test
    public void getSound(){
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void  getFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
        Mockito.verify(felineMock).eatMeat();

    }
}

@ExtendWith(MockitoExtension.class)
class AlexTest{
    @Mock
    private Feline felineMock;
    private Alex alex;

    @BeforeEach
    void setUp() throws Exception {
        alex = new Alex(felineMock);
    }


    @Test
    public void getFriend(){
        List<String> expectedList = List.of("Марти", "Глория", "Мелман");
        List<String> actualList = alex.getFriends();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void getPlaceOfLiving(){
        String expectedPlace = "Зоопарк";
        String actualPlace = alex.getPlaceOfLiving();

        assertEquals(expectedPlace, actualPlace);
    }

    @Test
    public void testGetKittensReturnsZero(){
        int actualKittens = alex.getKittens();
        assertEquals(0, actualKittens, "У Алекса не должно быть котят");
    }

    @Test
    public void testDoesHaveMane(){
        assertTrue(alex.doesHaveMane(), "У Алекса есть грива");
    }

    @Test
    public void testGetFoodUsesFeline() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = alex.getFood();
        assertEquals(expectedFood, actualFood);
    }



}