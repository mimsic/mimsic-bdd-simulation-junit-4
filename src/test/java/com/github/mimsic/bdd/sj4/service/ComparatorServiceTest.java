package com.github.mimsic.bdd.sj4.service;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
@SpringBootTest
public class ComparatorServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComparatorServiceTest.class);

    @ClassRule
    public static final SpringClassRule scr = new SpringClassRule();

    @Rule
    public final SpringMethodRule smr = new SpringMethodRule();

    @Autowired
    private ComparatorService comparatorService;

    @Test
    @Parameters({
            "1, 2, 1",
            "-2, -1, -1",
            "-1, 1, 0",
            "2, 1, -100",
            "0, 0, -100"
    })
    public void whenWithAnnotationProvidedParams_thenCompare(int low, int high, int expected) {

        assertEquals(expected, comparatorService.compare(low, high));
    }

    @Test
    @FileParameters(value = "src/test/resources/ComparatorServiceTestParameters.csv", mapper = CsvWithHeaderMapper.class)
    public void whenWithCsvFileProvidedParams_thenCompare(int low, int high, int expected) {

        assertEquals(expected, comparatorService.compare(low, high));
    }
}