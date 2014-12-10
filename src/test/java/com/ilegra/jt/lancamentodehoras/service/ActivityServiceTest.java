package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.Memory;
import com.ilegra.jt.lancamentodehoras.model.Activity;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ActivityServiceTest {
   
    @Before
    public void setup(){
        int year = 2014;
        Month month = Month.DECEMBER; 
        int dayOfMonth = 5;        
        Activity first = new Activity();
        first.setStartHour(LocalDateTime.of(year, month, dayOfMonth, 9, 30));
        first.setFinishHour(LocalDateTime.of(year, month, dayOfMonth, 10, 30));         
        Memory.activities = Arrays.asList(first);
    }
    
    @Test
    public void receiveEmptyReturnTrue() {
        assertEquals(true, ActivityService.isEmpty(""));
    }

    @Test
    public void receiveNullReturnTrue() {
        assertEquals(true, ActivityService.isNull(null));
    }

    @Test
    public void receiveTextOutOfBrazilianDateFormatReturFalse() {
        assertEquals(false, ActivityService.validateDate("2014-02-20"));
    }

    @Test
    public void receiveTextInBrazilianDateFormatReturnTrue() {
        assertEquals(true, ActivityService.validateDate("20/12/2014"));
    }

    @Test
    public void receiveInvalidDayReturnFalse() {
        assertEquals(false, ActivityService.validateDate("50/12/2014"));
    }

    @Test
    public void receiveInvalidMonthReturnFalse() {
        assertEquals(false, ActivityService.validateDate("20/13/2014"));
    }

    @Test
    public void receiveTextContainsHoursInFormatHoursMinuteReturnTrue() {
        assertEquals(true, ActivityService.isHour("20:00"));
    }

    @Test
    public void receiveInvalidTextReturnFalse() {
        assertEquals(false, ActivityService.isHour("textoInvalido"));
    }

    @Test
    public void toLocalDateTimeConvertCorrectly() {

        LocalDateTime expected = LocalDateTime.of(2014, Month.MARCH, 10, 10, 20);
        LocalDateTime actual = ActivityService.toLocalDateTime("10/03/2014", "10:20");

        assertEquals(expected, actual);

    }

    @Test
    public void validateStartHourUpperThanFinishHour() {
        LocalDateTime start = LocalDateTime.of(2014, Month.MARCH, 10, 20, 20);
        LocalDateTime end = LocalDateTime.of(2014, Month.MARCH, 10, 10, 20);

        assertFalse(ActivityService.validateHours(start, end));

    }

    @Test
    public void validateStartHourLowerThanFinishHour() {
        LocalDateTime start = LocalDateTime.of(2014, Month.MARCH, 10, 2, 20);
        LocalDateTime end = LocalDateTime.of(2014, Month.MARCH, 10, 10, 20);

        assertTrue(ActivityService.validateHours(start, end));

    }    
    
    @Test
    public void horaInicialEmIntervaloJaCadastrado(){
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 10, 00);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 10, 40); 
        assertTrue(ActivityService.isOverlapHour(start, end));
    }

    
    @Test
    public void horaFinalEmIntervaloJaCadastrado(){
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 9, 00);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 9, 40);        
        assertTrue(ActivityService.isOverlapHour(start, end));
    }    
        
    @Test
    public void horarioDentroDeIntervaloJaCadastrado(){
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 9, 40);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 10, 10);        
        assertTrue(ActivityService.isOverlapHour(start, end));
    }       
    
    @Test
    public void dataComIntervaloContendoHorasJaLancadas(){
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 9, 0);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 11, 0);        
        assertTrue(ActivityService.isOverlapHour(start, end));
    }   
    
    @Test
    public void periodoNaoSobrepostoDeveRetornaFalse(){
        LocalDateTime start = LocalDateTime.of(2014, Month.DECEMBER, 5, 8, 0);
        LocalDateTime end = LocalDateTime.of(2014, Month.DECEMBER, 5, 8, 30);        
        assertFalse(ActivityService.isOverlapHour(start, end));        
    }
    
    /**
     * @Test public void validaDiasEntreDatas() { LocalDateTime today =
     * LocalDateTime.now(); LocalDateTime startDate = LocalDateTime.of(2014,
     * Month.MARCH, 10, 10, 20);
     * assertFalse(ActivityService.validadeBetweenDates(startDate));
     *
     * }
     *
     * @Test public void validaSeDataLancadaÉMaiorQueHoje() { LocalDateTime
     * today = LocalDateTime.now(); LocalDateTime startDate =
     * LocalDateTime.of(2014, Month.NOVEMBER, 5, 10, 20);
     * assertFalse(ActivityService.validadeStartDateUpperThanToday(startDate));
     *
     * }
     */
}
