package com.fastcampus.jpa.bookmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)//상속하는 투스트링을 허용.
@EqualsAndHashCode(callSuper = true)
public class BookReviewInfo extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private Long bookId;

    private float averageReviewScore;// 프리미티브 타입은 래퍼타입에 비해 널을 허용하지 않음.

    private int reviewCount;
}
