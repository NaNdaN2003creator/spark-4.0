package collection.StackDemo;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.SortedMap;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("raj");
        list.add("soham");
        list.add("amruta");
        list.add("Nabha");
        list.add("nandan");

        //fetch
        String fisrt = list.getFirst();
        String last  =list.getLast();

        System.out.println("firstelement="+fisrt);
        System.out.println("lastelement="+last);
    }
}
