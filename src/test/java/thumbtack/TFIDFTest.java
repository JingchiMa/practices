package thumbtack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TFIDFTest {
    @Test
    public void getTfidfs() throws Exception {
        TFIDF instance = new TFIDF();
        List<List<String>> documents = new ArrayList<>();
        documents.add(new ArrayList<>(Arrays.asList("test1", "test2", "test2")));
        documents.add(new ArrayList<>(Arrays.asList("test1", "test2", "test1", "test3")));
        List<String> words = new ArrayList<>(Arrays.asList("test1", "test2", "test3"));
        System.out.println(instance.getTfidfs(documents, words));
    }

}