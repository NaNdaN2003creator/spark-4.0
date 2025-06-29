package collection.collectionDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class ArrayListDemo {
    public static void main(String []args){
        //order
        //duplicate
        //index access
        List<Integer>nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(10);
        System.out.println(nums.get(3));
        System.out.println(nums);
        System.out.println(nums.size());
        if(nums.isEmpty()){
            System.out.println("list empty");

        }
        else{
            System.out.println("not empty");
        }
        nums.add(3,90);
        System.out.println(nums);
    }
}
