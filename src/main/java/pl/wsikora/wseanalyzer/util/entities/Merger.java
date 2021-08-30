package pl.wsikora.wseanalyzer.util.entities;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Merger {

    private Merger() {
    }

    public static <T> T merge(T t1, T t2) {
        Class<T> tClass = (Class<T>) t1.getClass();
        try {
            T result = tClass.getConstructor().newInstance();
            for (Field field : tClass.getDeclaredFields()) {
                field.setAccessible(true);
                field.set(result, returnNewValueIfNotEqualsAndNotNull(field.get(t1), field.get(t2)));
            }
            return result;
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return t1;
    }

    private static <T> T returnNewValueIfNotEqualsAndNotNull(T t1, T t2) {
        if (t2 != null && !t2.equals(t1)) {
            return t2;
        }
        return t1;
    }

}
