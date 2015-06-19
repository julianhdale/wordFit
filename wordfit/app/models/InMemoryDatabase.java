package models;

import java.util.*;

/**
 * Created by juliandale on 6/19/15.
 */
public class InMemoryDatabase {

    private static InMemoryDatabase instance = new InMemoryDatabase();

    private static ShouldShowNotification notification;
    private static HashMap<String, Integer> wordCount = new HashMap<String, Integer>();

    public static InMemoryDatabase getInstance() {
        return instance;
    }


    public void putWord(final String word) {
        Integer value = wordCount.get(word);

        if (value == null) {
            wordCount.put(word, 1);
        } else {
            value++;
            wordCount.put(word,value);
        }
    }

    public WordCountPayload getWordCountPayload() {
        WordCountPayload payload = new WordCountPayload();
        int[] temp = {12,3,15,17,18,22,7};
        payload.setTotalWordCount(temp);
        ArrayList<WordCountModel> wordList = new ArrayList<WordCountModel>();

        for (Map.Entry<String, Integer> entry : wordCount.entrySet())
        {
            wordList.add(new WordCountModel(entry.getKey(), entry.getValue()));
        }
        Collections.sort(wordList, new WordCountSorter());

        System.out.println("hashmap size: "+wordList.size());
        int listSize = Math.min(wordList.size(), 10);
        WordCountModel[] models = new WordCountModel[listSize];
        models = wordList.subList(0,listSize).toArray(models);
        payload.setTopWords(models);
        return payload;
    }

    public void setShouldShowNotification(ShouldShowNotification not) {
        notification = not;
    }

    public ShouldShowNotification getNotification() {
        if (notification == null) {
            notification = new ShouldShowNotification();
            notification.shouldShow = 0;
        }
        return notification;
    }

    public class WordCountSorter implements Comparator<WordCountModel> {
        @Override
        public int compare(WordCountModel a, WordCountModel b) {
            return b.count - a.count;
        }
    }

}
