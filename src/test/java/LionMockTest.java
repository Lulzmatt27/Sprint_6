
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionMockTest {



    @Test
    public void getKittensReturnsForLion() throws Exception {
        Lion lion = new Lion("Самка");
        int expectedKittensCount = 1;
        int actualKittensCount = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);

    }

    @Test
    public void getFoodReturnsForLion() throws Exception {
        Lion lion = new Lion("Самец");
        List<String> actualEatMeat = lion.getFood();
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedEatMeat, actualEatMeat);
    }

    @Test
    public void doesHaveManeException() {
        String exceptionLion = "Оно";
        Exception exception = Assert.assertThrows("Исключение", Exception.class, () ->  new Lion (exceptionLion));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}
