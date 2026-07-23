package com.care.common.sequence;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "case_sequence")
@Getter
@Setter
@NoArgsConstructor
public class CaseSequence {

    @Id
    private Long id = 1L;

    @Column(nullable = false)
    private Long nextValue = 1L;

}