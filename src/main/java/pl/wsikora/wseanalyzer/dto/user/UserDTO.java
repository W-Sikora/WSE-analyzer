package pl.wsikora.wseanalyzer.dto.user;

import pl.wsikora.wseanalyzer.model.user.User;

public class UserDTO {
    private final long id;
    private final String nickname;
    private final String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
    }

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

}
