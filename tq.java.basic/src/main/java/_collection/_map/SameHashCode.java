package _collection._map;

import java.util.HashMap;
import java.util.Map;

public class SameHashCode {

    public static void main(String[] args) {
        Map<PP, String> map = new HashMap<>();
        PP p = new PP();
        map.put(p, "ss");
        PP pp = new PP();
        map.put(pp, "ss");
        System.err.println(pp == p);
        System.err.println(map.get(p));
        System.err.println(map.get(pp));
        System.err.println(map);
    }

  public static  class PP {
        @Override
        public int hashCode() {
            return 1;
        }

    }
}
