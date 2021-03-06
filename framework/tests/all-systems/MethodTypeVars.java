import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

class MethodTypeVars {
    private <T> void addToBindingList(Map<T, List<String>> map, T key, String value) {}

    void call1() {
        LinkedHashMap<Object, List<String>> multiMap = new LinkedHashMap<Object, List<String>>();
        String s = "s";
        Object o = new Object();
        addToBindingList(multiMap, o, s);
    }

    void call2() {
        LinkedHashMap<Integer, List<String>> multiMap = new LinkedHashMap<Integer, List<String>>();
        String s = "s";
        Integer n = 5;
        addToBindingList(multiMap, n, s);
    }
}
