package ru.sevastopall.schoolapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat")
@NamedEntityGraph(
        name = "chat-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("messages"),
                @NamedAttributeNode("participants"),
        }
)
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "chat_name")
    private String chatName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "user_chat",
            joinColumns = { @JoinColumn(name = "chat_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> participants;

    @OneToMany(mappedBy = "chat")
    private List<ChatMessage> messages;
}
