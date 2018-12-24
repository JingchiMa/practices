package thumbtack;

import java.util.*;

public class TFIDF {
    /*
    Given a list of documents, and a list of target words, find the tfidf for each of the word
    and return the top k documents

    step 1: process all documents
        (1) calculate tf for each given word in each document. # of occurrences for word, total # words in the document

        (2) calculate the idf for each word. # word in all documents

    step 2: find the top k of
     */

    List<Map<String, Double>> getTfidfs(List<List<String>> documents, List<String> words) {
        Map<String, Map<Integer, Integer>> wordCounts = getWordCounts(documents, words);
        Map<String, Integer> documentCounts = getDocumentCounts(wordCounts);
        List<Map<String, Double>> results = new ArrayList<>();
        for (int i = 0; i < documents.size(); i++) {
            Map<String, Double> tfidfs = new HashMap<>();
            for (String word : words) {
                if (!tfidfs.containsKey(word)) {
                    tfidfs.put(word, getTfidf(wordCounts, documentCounts, documents, i, word));
                }
            }
            results.add(tfidfs);
        }
        return results;
    }

    private double getTfidf(Map<String, Map<Integer, Integer>> wordCounts, Map<String, Integer> documentCounts,
                            List<List<String>> documents, int documentId, String word) {
        Integer totalNum = documentCounts.get(word);
        if (totalNum == null) {
            return 0;
        }
        Integer numInDocument = wordCounts.get(word).get(documentId);
        if (numInDocument == null) {
            return 0;
        }
        double tf = numInDocument * 1.0 / documents.size();
        double idf = Math.log(documents.size() * 1.0 / documentCounts.get(word));
        return tf * idf;
    }

    private Map<String, Map<Integer, Integer>> getWordCounts(List<List<String>> documents, List<String> words) {
        Set<String> set = new HashSet<>(words);
        Map<String, Map<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < documents.size(); i++) {
            List<String> document = documents.get(i);
            for (String word : document) {
                if (!set.contains(word)) {
                    continue;
                }
                map.putIfAbsent(word, new HashMap<>());
                Map<Integer, Integer> documentWordCount = map.get(word);
                documentWordCount.put(i, documentWordCount.getOrDefault(i, 0) + 1);
            }
        }
        return map;
    }

    private Map<String, Integer> getDocumentCounts(Map<String, Map<Integer, Integer>> wordCounts) {
        Map<String, Integer> documentCounts = new HashMap<>();
        for (Map.Entry<String, Map<Integer, Integer>> mapEntry : wordCounts.entrySet()) {
            documentCounts.put(mapEntry.getKey(), mapEntry.getValue().size());
        }
        return documentCounts;
    }



    public static void main(String[] args) {
        TFIDF instance = new TFIDF();
        List<List<String>> documents = new ArrayList<>();
        documents.add(new ArrayList<>(Arrays.asList("test1", "test2", "test2")));
        documents.add(new ArrayList<>(Arrays.asList("test1", "test2", "test1", "test3")));
        List<String> words = new ArrayList<>(Arrays.asList("test1", "test2", "test3"));
        Map<String, Map<Integer, Integer>> wordCounts = instance.getWordCounts(documents, words);
    }

//    double getTF(List<String> document, String word) {
//
//    }
//
//    double getIDF(List<List<String>> documents, String word) {
//
//    }

}
