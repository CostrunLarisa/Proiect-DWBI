package com.unibuc.ro.dataWarehouse;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import org.springframework.stereotype.Service;

@Service
public class BigQueryService {

    private final BigQuery bigQuery;

    public BigQueryService() {
        this.bigQuery = BigQueryOptions.newBuilder()
                .setProjectId("secret-cipher-412718")
                .build()
                .getService();
    }

    // Add methods to interact with BigQuery as needed
}
