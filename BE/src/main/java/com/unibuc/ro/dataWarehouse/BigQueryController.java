package com.unibuc.ro.dataWarehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bigquery")
public class BigQueryController {

    private final BigQueryService bigQueryService;

    @Autowired
    public BigQueryController(BigQueryService bigQueryService) {
        this.bigQueryService = bigQueryService;
    }

    @GetMapping("/query")
    public String executeQuery() {
        // Use the BigQueryService to execute queries
        // Example: bigQueryService.executeQuery("SELECT * FROM your_table");

        return "Query executed successfully!";
    }
}
