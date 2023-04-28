package com.example.demo.services;

import com.example.demo.jsonmodels.GenericEntityJsonModel;
import com.example.demo.models.Record;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.RecordRepository;

import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

@Service
public class SaveRecordServiceImpl implements SaveRecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Transactional
    public void writeGenericEntityToDb(final GenericEntityJsonModel genericEntity) {
        ExampleMatcher recordMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("recordType", exact())
                .withMatcher("fieldA", exact())
                .withMatcher("fieldB", exact())
                .withMatcher("fieldC", exact());
        Record probeRecord = new Record(genericEntity.getRecordType(), genericEntity.getFieldA(), genericEntity.getFieldB(), genericEntity.getFieldC(), genericEntity.getDeviceId(), genericEntity.getEventDateTime());
        Example<Record> exampleRecord = Example.of(probeRecord, recordMatcher);
        Optional<Record> existingRecord = recordRepository.findOne(exampleRecord);
        if (existingRecord.isEmpty()) {
            Record newRecord = new Record(genericEntity.getRecordType(), genericEntity.getFieldA(), genericEntity.getFieldB(), genericEntity.getFieldC(), genericEntity.getDeviceId(), genericEntity.getEventDateTime());
            recordRepository.save(newRecord);
        }
    }

}
