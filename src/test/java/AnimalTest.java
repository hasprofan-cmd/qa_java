import com.example.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTest {

    Animal animal;

    @BeforeEach
    void setUp(){
        animal = new Animal();
    }

    @Test
    public void getFamily(){
        assertEquals(
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                animal.getFamily()
        );
    }

    @Test
    public void getFood() throws Exception {
        assertEquals(
                List.of("Трава", "Различные растения"),
                animal.getFood("Травоядное")
        );
    }

    @Test
    public void getFoodForUnknownKind(){
       assertThrows(
               Exception.class, () ->
                       animal.getFood("Малюски")
       );

    }
}
