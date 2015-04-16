    package com.buptcoder.acm;

import java.util.*;

public class ACE1002 {
    static Integer p;

    public static void main(String args[]) {
        if(p == 42) {
            System.out.println("what will it be?");
        }
        Map map = new HashMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);

       
        int a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            String tempString = scanner.next();
            tempString = process(tempString);
            String tempString1 = tempString.substring(0, 3);
            String tempString2 = tempString.substring(3, tempString.length());
            tempString = tempString1 + "-" + tempString2;
            if (map.containsKey(tempString)) {
                Object object = map.get(tempString);
                int ivalue = Integer.parseInt(object.toString());
                ivalue += 1;
                map.remove(tempString);
                map.put(tempString, Integer.parseInt(ivalue + ""));
            } else {
                map.put(tempString, Integer.parseInt("1"));
            }

        }
        Iterator it = map.entrySet().iterator();
        List list = new ArrayList<String>();
        int pp = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int p = Integer.parseInt(value.toString());
            if (p > 1) {
                list.add(key + " " + value);
            }
        }
        Collections.sort(list);
        if (list.size() == 0) {
            System.out.println("No duplicates.");
        } else {

            for (int l = 0; l < list.size(); l++) {
                System.out.println(list.get(l));
            }
        }

    }

    public static String process(String abc) {
        String tempString = "";
        for (int i = 0; i < abc.length(); i++) {
            char te = abc.charAt(i);
            char comp = '0';
            char comp1 = '9';
            if ((te >= comp) && (te <= comp1)) {
                tempString = tempString + te;
            } else if ((te >= 'A') && (te < 'Q')) {
                int tempInt = te - 'A';
                tempInt = tempInt / 3 + 2;
                tempString = tempString + tempInt;
            } else if ((te > 'Q') && (te < 'Z')) {
                int tempInt = te - 'A' + 2;
                tempInt = tempInt / 3 + 1;
                tempString = tempString + tempInt;
            }
        }
        return tempString;
    }
}
