package collection.collectionDemo;

import java.util.ArrayList;
import java.util.List;

public class ClearProgDemo {
    public static void main(String[] args) {
        List<Integer> List = new ArrayList<>();
        for(int i=0;i<=5;i++){
            List.add(i);
        }
        System.out.println("List is:"+List);
        if(List.isEmpty()){
            System.out.println("List is EMpty");

        }else{
            System.out.println("List is not empty");
        }
        List.clear();
        System.out.println("List is"+List);
    }
}
