import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class DictionaryTest {
    @Mock
    private DictionaryRepository uutRepository;


    @InjectMocks
    private Dictionary dictionary;


    @Test
    public void givenWordNotInDatabase_whenAddOrUpdateWord_thenAddedStatus() {
        //Given
        String word = "Apple";
        String definition = "A fruit";
        when(uutRepository.getDefinition(word)).thenReturn(null);
        //When
        DictionaryStatus status = dictionary.addOrUpdateWord(word, definition);
        //then
        assertEquals(DictionaryStatus.ADDED, status);
        verify(uutRepository, times(1)).add(word, definition);
        verify(uutRepository, never()).update(any(), any());
    }


    @Test
    public void givenWordInDatabase_whenAddOrUpdateWord_thenUpdatedStatus() {
        //G
        String word = "Apple";
        String definition = "A fruit";
        when(uutRepository.getDefinition(word)).thenReturn("Old definition");
        //w
        DictionaryStatus status = dictionary.addOrUpdateWord(word, definition);
        //T
        assertEquals(DictionaryStatus.UPDATED, status);
        verify(uutRepository, times(1)).update(word, definition);
        verify(uutRepository, never()).add(any(), any());
    }


    @Test
    public void givenEmptyWord_whenAddOrUpdateWord_thenInvalidStatus() {
        //G
        String word = "";
        String definition = "A fruit";
        //Wh
        DictionaryStatus status = dictionary.addOrUpdateWord(word, definition);
        //T
        assertEquals(DictionaryStatus.INVALID, status);
        verify(uutRepository, never()).add(any(), any());
        verify(uutRepository, never()).update(any(), any());
    }


    @Test
    public void givenWordWithNumbers_whenAddOrUpdateWord_thenInvalidStatus() {
        //G
        String word = "Appl3";
        String definition = "A fruit";
        //W
        DictionaryStatus status = dictionary.addOrUpdateWord(word, definition);
        //T
        assertEquals(DictionaryStatus.INVALID, status);
        verify(uutRepository, never()).add(any(), any());
        verify(uutRepository, never()).update(any(), any());
    }


    @Test
    public void givenWordInDatabase_whenGetDefinition_thenDefinitionReturned() {
        //G
        String word = "Apple";
        String expectedDefinition = "A fruit";
        when(uutRepository.getDefinition(word)).thenReturn(expectedDefinition);
        // W
        String definition = dictionary.getDefinition(word);
        //T
        assertEquals(expectedDefinition, definition);
    }


    @Test
    public void givenWordNotInDatabase_whenGetDefinition_thenNotFoundMessage() {
        //Given
        String word = "Banana";
        when(uutRepository.getDefinition(word)).thenReturn(null);
        //When
        String definition = dictionary.getDefinition(word);
        //Then
        assertEquals("Das Wort Banana konnte im Wörterbuch nicht gefunden werden", definition);
    }


    @Test
    public void givenEmptyWord_whenGetDefinition_thenInvalidMessage() {
        //G
        String word = "";
        //W
        String definition = dictionary.getDefinition(word);
        //t
        assertEquals("Das Wort  konnte im Wörterbuch nicht gefunden werden", definition);
        verify(uutRepository, never()).getDefinition(any());
    }


    @Test
    public void givenWordWithNumbers_whenGetDefinition_thenInvalidMessage() {
        //G
        String word = "Appl3";
        // W
        String definition = dictionary.getDefinition(word);
        //t
        assertEquals("Das Wort Appl3 konnte im Wörterbuch nicht gefunden werden", definition);
        verify(uutRepository, never()).getDefinition(any());
    }
}