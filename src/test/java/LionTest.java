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

