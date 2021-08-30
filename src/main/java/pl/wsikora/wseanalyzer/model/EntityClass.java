package pl.wsikora.wseanalyzer.model;

import pl.wsikora.wseanalyzer.util.Merger;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.IDENTITY;

@MappedSuperclass
public abstract class EntityClass<T extends EntityClass<T>> {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    public abstract static class BuilderTemplate<T extends EntityClass<T>> {
        private final List<Consumer<T>> operations;
        private final T object;

        protected BuilderTemplate(T object) {
            this.object = object;
            this.operations = new ArrayList<>();
        }

        protected BuilderTemplate<T> add(Consumer<T> operation) {
            operations.add(operation);
            return this;
        }

        public BuilderTemplate<T> withId(long id) {
            return add(e -> e.id = id);
        }

        public T build() {
            operations.forEach(operation -> operation.accept(object));
            return object;
        }

    }

    public Long getId() {
        return id;
    }

    public T merge(T t){
        return Merger.merge((T) this, t);
    }

}
