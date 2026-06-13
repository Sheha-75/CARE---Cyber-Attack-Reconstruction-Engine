package com.care.evidence;

import com.care.case_management.Case;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "evidence")
@Getter
@Setter
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    private String fileType;

    private String filePath;

    private LocalDateTime uploadedAt;

    private String sha256Hash;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private Case investigationCase;
}