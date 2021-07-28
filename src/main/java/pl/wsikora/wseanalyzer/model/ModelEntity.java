package pl.wsikora.wseanalyzer.model;

public interface ModelEntity {

    Long getId();

    default <T> T returnNewValueIfChanged(T t1, T t2) {
        if(t2 != null && !t2.equals(t1)) {
            return t2;
        }
        return t1;
    }

}
