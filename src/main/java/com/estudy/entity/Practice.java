package com.estudy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "practice", indexes = {
        @Index(name = "idx_lesson_id", columnList = "lesson_id")
})
public class Practice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "practice_id")
    private Long practiceId;

    @Column(name = "practice_name")
    private String practiceName;

    @Column(name = "lesson_id")
    private Long lessonId;

}
