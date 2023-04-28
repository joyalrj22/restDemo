package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@ToString
public class Record {

    public Record(final String recordType, final Integer fieldA, final String fieldB, final Double fieldC, final String deviceId, final Date eventDateTime) {
        this.recordType = recordType;
        this.fieldA = fieldA;
        this.fieldB = fieldB;
        this.fieldC = fieldC;
        this.deviceId = deviceId;
        this.eventDateTime = eventDateTime;
    }

    public Record() {

    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String recordType;

    @Column(nullable = false)
    private Integer fieldA;

    @Column(nullable = false)
    private String fieldB;

    @Column(nullable = false)
    private Double fieldC;

    @Column(nullable = false)
    private String deviceId;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDateTime;
}
