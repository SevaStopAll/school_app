
package ru.sevastopall.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * Класс пользователя со свойствами <b>maker</b> и <b>price</b>.
 * @autor Всеволод
 * @version 0.5
 */
public class User {
    /**
     * Идентификатор пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Имя пользователя
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Электронная почта пользователя
     */
    @Column(name = "email")
    private String email;

    /**
     * Логин пользователя
     */
    @Column(name = "login")
    private String login;

    /**
     * Пароль пользователя
     */
    @Column(name = "password")
    private String password;

    /**
     * Подтверждение учетной записи администратором
     */
    @Column(name = "confirmed")
    private boolean confirmed;

    /**
     * Роли пользователя хранятся в коллекции List
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;
}