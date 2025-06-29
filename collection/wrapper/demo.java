package collection.wrapper;



import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.SortedMap;

public class demo {
    public static void main(String[] args) {
        Integer i = Integer.valueOf(120);  //here "value of' return wrapper object
        Integer i2 = Integer.valueOf(123);

        System.out.println(i);
        System.out.println(i2);
        int obj1 = Integer.parseInt("7878"); // isme integer type string daloge, usko parse karega ,aur apne ko wrapper object dega
        Boolean.parseBoolean("true"); // jis type ke wrapper ko parse lagaoge us  type ko ye parse kar dega

        Double d=9.88;
        int i3 = d.intValue();

        Integer k = 66;
        String Ks = k.toString();
        Integer pa = 128;
        Integer pb = 128;
        System.out.println(pa.equals(pb));
    }
}

