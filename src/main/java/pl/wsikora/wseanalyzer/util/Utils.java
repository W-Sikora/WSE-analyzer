package pl.wsikora.wseanalyzer.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Utils {

    private Utils() {
    }

    public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public static <T> Class<T> getEntityType(Object object) {
        return (Class<T>) ((ParameterizedType) object.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

}
