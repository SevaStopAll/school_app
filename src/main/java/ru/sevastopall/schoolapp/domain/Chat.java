package ru.sevastopall.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.TreeSet;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "news")
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chat_name")
    private String chatName;

    @ManyToMany
            //TODO доделать маппинг
    private List<User> participants;

    @OneToMany
    //TODO доделать маппинг
    private TreeSet<Message> messages;







}
