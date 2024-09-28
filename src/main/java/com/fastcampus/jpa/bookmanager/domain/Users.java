package com.fastcampus.jpa.bookmanager.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity //해당 객체가 JPA에서 관리하는 엔티티 객체임을 알림.
@Table
@EntityListeners(value = MyEntityListener.class)
public class Users implements Auditable{
    @Id //entity에는 pk가 필요함.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Transient //영속성 처리에서 제외되어 DB에 반영되지 않고 객체와 생명주기를 같이함.
    private String testData;

    @Enumerated(value = EnumType.STRING) //오디널로 사용되는것을 방지하기위해 반드시 스트링으로 처리해야함 , 이렇게 하지않으면 DB에 0,1 로 저장되는것이 문제임. 추후 업데이트로 0,1이 바뀌는 경우를 고려해야함.
    private Gender gender;

    //파일이 컴파일될때 delombok 되서 실행됨.

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;

//    @PrePersist //insert전 , 자동으로 업데이트되게할 목적으로 사용.
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//
//
//    @PreUpdate //update전
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }
}
