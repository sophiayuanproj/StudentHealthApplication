package com.example.sleep.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;

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
    private ZonedDateTime start;

    @Getter
    @Setter
    @NonNull
    @Column(name = "end")
    private ZonedDateTime end;

    @Getter
    @Setter
    @Column(name = "feel")
    @Enumerated(EnumType.STRING)
    private Feel feel;

    public enum Feel {
        PERFECT,
        GOOD,
        NEUTRAL,
        BAD,
        WORST,
        NOT_SET
    }

    public Duration getDuration() {
        return Duration.between(start, end);
    }
}
