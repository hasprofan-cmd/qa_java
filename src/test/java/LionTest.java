import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

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

    @ParameterizedTest
    @CsvSource({"Самец, true", "Самка, false"})
    public void doesHaveMane(String sex, boolean expectedMane) throws Exception {
        Lion lionParam = new Lion(sex, felineMock);
        assertEquals(expectedMane, lionParam.doesHaveMane());
    }



}

