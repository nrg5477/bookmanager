package com.fastcampus.jpa.bookmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
public class User {
    @Id //entity에는 pk가 필요함.
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    //파일이 컴파일될때 delombok 되서 실행됨.
}
