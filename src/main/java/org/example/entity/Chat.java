package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "chat")
public class Chat extends SupperClass implements BaseEntity<Long> {
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "chat")
    private List<UsersChat> usersChats = new ArrayList<>();
}
