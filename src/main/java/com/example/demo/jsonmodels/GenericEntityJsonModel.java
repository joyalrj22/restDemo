package com.example.demo.jsonmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class GenericEntityJsonModel {
    @JsonProperty("RecordType")
    private String recordType;

    @JsonProperty("DeviceId")
    private String deviceId;

    @JsonProperty("EventDateTime")
    private Date eventDateTime;

    @JsonProperty("FieldA")
    private Integer fieldA;

    @JsonProperty("FieldB")
    private String fieldB;

    @JsonProperty("FieldC")
    private Double fieldC;
}
