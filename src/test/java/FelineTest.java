import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    Feline feline;

    @BeforeEach
    void setUp(){
        feline = new Feline();
    }

    @Test
    public void getKittens(){
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void getFamilyFeline(){
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeat() throws Exception{
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @ParameterizedTest
    @CsvSource ({"1, 1", "5, 5", "10, 10"})
    public void getKittensByCount(int count, int expected){
        assertEquals(expected, feline.getKittens(count));
    }





}
