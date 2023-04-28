package com.example.demo.services;

import com.example.demo.jsonmodels.GenericEntityJsonModel;

public interface SaveRecordService {
    void writeGenericEntityToDb(final GenericEntityJsonModel genericEntity);
}
