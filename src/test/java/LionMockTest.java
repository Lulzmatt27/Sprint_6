import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class LionMockTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnsForLion() throws Exception {
        Lion lion = new Lion("Самка");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittensCount = 1;
        int actualKittensCount = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);

    }

    @Test
    public void getFoodReturnsForLion() throws Exception {
        Lion lion = new Lion("Самец");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
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
