import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


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

