package com.rsjavasolutions.cache.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    @Setter(AccessLevel.NONE)
    private String uuid;
    private String name;
    private String surname;
    @Setter(AccessLevel.NONE)
    private LocalDateTime creationDateTime;

    public UserEntity(String name,
                      String surname) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.creationDateTime = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}

