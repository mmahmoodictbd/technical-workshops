package com.unloadbrain.covid19bangladesh.service;

import com.unloadbrain.covid19bangladesh.dto.Covid19CountryStat;
import com.unloadbrain.covid19bangladesh.util.DateTimeUtil;
import com.unloadbrain.covid19bangladesh.util.JsoupUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class Covid19DataScraperService {

    private static final String DATA_SOURCE_URL = "https://www.prothomalo.com/";
    private static final int TIMEOUT_MILLIS = 10000;

    private final JsoupUtil jsoupUtil;
    private final DateTimeUtil dateTimeUtil;

    @Cacheable("stat")
    public Covid19CountryStat scrape() {

        log.info("COVID-19 Data scraped from {} at {}", DATA_SOURCE_URL, dateTimeUtil.getCurrentTimeEpochMilli());

        Document doc = jsoupUtil.fetch(DATA_SOURCE_URL, TIMEOUT_MILLIS);
        Elements statElements = doc.select("div.coronavirus-statistics > div.body-bangladesh > div.content");

        return Covid19CountryStat.builder()
                .totalAffected(statElements.eq(0).select("div.number").text())
                .totalDeath(statElements.eq(2).select("div.number").text())
                .totalRecovered(statElements.eq(1).select("div.number").text())
                .unixTimestamp(dateTimeUtil.getCurrentTimeEpochMilli())
                .build();
    }
}
