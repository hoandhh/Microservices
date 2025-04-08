package demo.hoandh.accountservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "account")
@Setter
@Getter
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private String password;

    @Column(name = "username", unique = true)
    private String username;

    @ElementCollection
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "account_id"))
    @Column(name = "role")
    private Set<String> roles;
}