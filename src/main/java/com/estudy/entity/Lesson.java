package com.estudy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "lesson", indexes = {
        @Index(name = "idx_topic_id", columnList = "topic_id")
})
@Data
public class Lesson extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lession_id")
    private Long lessonId;

    @Column(name = "lesson_name")
    private String lessonName;

    @Column(name = "topic_id")
    private Long topicId;

    @Column(name = "description", columnDefinition = "TEXT NOT NULL")
    private String description;

}
