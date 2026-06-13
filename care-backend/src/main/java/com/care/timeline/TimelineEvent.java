package com.care.timeline;

import com.care.case_management.Case;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "timeline_events")
@Getter
@Setter
public class TimelineEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime eventTime;

    private String eventType;

    @Column(length = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private Case investigationCase;
}