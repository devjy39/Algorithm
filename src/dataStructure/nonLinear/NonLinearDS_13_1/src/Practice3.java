package dataStructure.nonLinear.NonLinearDS_13_1.src;

import java.util.*;

public class Practice3 {
    public static ArrayList<ArrayList<String>> solution(ArrayList<ArrayList<String>> accounts) {
        HashMap<String, ArrayList<HashSet<String>>> map = new HashMap<>();
        for (ArrayList<String> account : accounts) {
            String name = account.get(0);
            HashSet<String> emails = new HashSet<>();
            for (int i = 1; i < account.size(); i++) {
                emails.add(account.get(i));
            }
            if (map.containsKey(name)) {
                ArrayList<HashSet<String>> hashSets = map.get(name);
                boolean check = true;
                for (HashSet<String> hashSet : hashSets) {
                    if (emails.stream().anyMatch(hashSet::contains)) {
                        hashSet.addAll(emails);
                        check = false;
                        break;
                    }
                }
                if (check) {
                    hashSets.add(emails);
                }
            } else {
                ArrayList<HashSet<String>> temp = new ArrayList<>();
                temp.add(emails);
                map.put(name, temp);
            }
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            ArrayList<HashSet<String>> hashSets = map.get(key);
            for (HashSet<String> hashSet : hashSets) {
                ArrayList<String> list = new ArrayList<>(hashSet);
                list.add(0, key);
                result.add(list);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test code
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john_lab@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "john@mail.com", "john02@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));
        accounts = solution(accounts);
        for (ArrayList<String> item: accounts) {
            System.out.println(item);
        }
    }
}
