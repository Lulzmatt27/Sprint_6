
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
        int expectedKittens = 1;
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Mockito.when(feline.getKittens()).thenReturn(expectedKittens);
        Assert.assertEquals(1, feline.getKittens());
        Assert.assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodReturnsForLion() throws Exception {
        Lion lion = new Lion("Самец");
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        feline.eatMeat();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        Mockito.when(feline.eatMeat()).thenReturn(expectedEatMeat);
        Assert.assertEquals(expectedEatMeat, feline.eatMeat());
        Assert.assertEquals(expectedEatMeat, lion.getFood());
    }

    @Test
    public void doesHaveManeException() {
        String exceptionLion = "Оно";
        Exception exception = Assert.assertThrows("Исключение", Exception.class, () ->  new Lion (exceptionLion));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

}
