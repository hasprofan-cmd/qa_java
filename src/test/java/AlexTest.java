import com.example.Alex;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AlexTest {
    @Mock
    private Feline felineMock;
    private Alex alex;

    @BeforeEach
    void setUp() throws Exception {
        alex = new Alex(felineMock);
    }


    @Test
    public void getFriend() {
        List<String> expectedList = List.of("Марти", "Глория", "Мелман");
        List<String> actualList = alex.getFriends();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void getPlaceOfLiving() {
        String expectedPlace = "Зоопарк";
        String actualPlace = alex.getPlaceOfLiving();

        assertEquals(expectedPlace, actualPlace);
    }

    @Test
    public void testGetKittensReturnsZero() {
        int actualKittens = alex.getKittens();
        assertEquals(0, actualKittens, "У Алекса не должно быть котят");
    }

    @Test
    public void testDoesHaveMane() {
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