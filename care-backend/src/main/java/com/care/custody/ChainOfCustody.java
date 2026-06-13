package com.care.custody;

import com.care.evidence.Evidence;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "chain_of_custody")
@Getter
@Setter
public class ChainOfCustody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;

    private String performedBy;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "evidence_id")
    private Evidence evidence;
}