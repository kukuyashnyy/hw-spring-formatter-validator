package org.itstep.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "custom_users")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CustomUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    private String login;
    @NonNull
    private String password;
}
