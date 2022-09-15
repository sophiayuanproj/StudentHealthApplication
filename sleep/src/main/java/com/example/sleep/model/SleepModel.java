package com.example.sleep.model;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.Instant;

@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sleep")
public class SleepModel {
    @Getter
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    @NonNull
    @Column(name = "start")
    private Instant start;

    @Getter
    @Setter
    @NonNull
    @Column(name = "end")
    private Instant end;

    @Getter
    @Setter
    @Column(name = "feel")
    private Feel feel;

    public enum Feel {
        PERFECT,
        GOOD,
        NEUTRAL,
        BAD,
        WORST
    }

    public Duration getDuration() {
        return Duration.between(start, end);
    }
}
