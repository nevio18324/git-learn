import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class DictionaryTest {

    @Mock
    DictionaryRepository uut = new DictionaryRepository() {
        //@Override
        public void add(String key, String value) {

        }

        @Override
        public void update(String key, String value) {

        }

        @Override
        public String getDefinition(String word) {
            return null;
        }
    };
    @InjectMocks
    Dictionary dictionary = new Dictionary(uut);
    @Test
    public void testAdd() {
        DictionaryStatus status = dictionary.addOrUpdateWord("ada","dada",dictionary);
        DictionaryStatus status2 = dictionary.addOrUpdateWord("ada","dada",dictionary);

        //verify(uut, times(1)).add("ada", "dada");
        //verify(uut, times(1)).add("ada","dada");
        assertEquals(DictionaryStatus.ADDED,status);
    }
    @Test
    public void testUpdate(){
        //verify(uut, never()).add(any(),any());
        verify(uut, times(1)).update("uda","uga");
    }
}