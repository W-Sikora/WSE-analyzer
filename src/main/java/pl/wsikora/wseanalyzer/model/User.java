package pl.wsikora.wseanalyzer.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
@JsonDeserialize(builder = User.Builder.class)
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nickname;

    private String email;

    private String password;

    @OneToMany
    @JoinColumn(name = "company_id")
    private List<Company> companiesFollowed;

    public User() {
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonPOJOBuilder
    static final class Builder {
        private final List<Consumer<User>> operations;

        private Builder() {
            operations = new ArrayList<>();
        }

        public Builder withId(Long id) {
            operations.add(e -> e.id = id);
            return this;
        }

        public Builder withNickname(String nickname) {
            operations.add(e -> e.nickname = nickname);
            return this;
        }

        public Builder withEmail(String email) {
            operations.add(e -> e.email = email);
            return this;
        }

        public Builder withPassword(String password) {
            operations.add(e -> e.password = password);
            return this;
        }

        public User build() {
            User user = new User();
            operations.forEach(operation -> operation.accept(user));
            return user;
        }

    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Company> getCompaniesFollowed() {
        return companiesFollowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(nickname, user.nickname) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(companiesFollowed, user.companiesFollowed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, email, password, companiesFollowed);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", companiesFollowed=" + companiesFollowed +
                '}';
    }

}
