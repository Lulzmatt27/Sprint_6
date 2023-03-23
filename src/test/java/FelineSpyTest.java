import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineSpyTest {

    @Spy
    Feline feline;

    @Test
    public void getEatMeatReturnsForFeline() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualEatMeat = feline.eatMeat();
        List<String> expectedEatMeat = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedEatMeat, actualEatMeat);
    }

    @Test
    public void getFamilyReturnsForFeline() {
        Feline feline = new Feline();
        String actualFamily = feline.getFamily();
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensReturnsForFeline() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittensCount = feline.getKittens();
        int expectedKittensCount = 1;
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}
