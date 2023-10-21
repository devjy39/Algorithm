package problem.baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No1302 {

    static class Book {
        String title;
        int count;

        public Book(String title, int count) {
            this.title = title;
            this.count = count;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String str = br.readLine();
            int count = map.getOrDefault(str, 0);
            map.put(str, count + 1);
        }

        List<Book> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(new Book(key, map.get(key)));
        }

        list.sort((b1, b2) -> b2.count - b1.count);
        List<String> sortedList = new ArrayList<>();

        int maxCount = list.get(0).count;
        for (Book book : list) {
            if (book.count == maxCount) {
                sortedList.add(book.title);
            } else {
                break;
            }
        }

        Collections.sort(sortedList);
        System.out.println(sortedList.get(0));
    }

}

