package pl.wsikora.wseanalyzer.model;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
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


}
