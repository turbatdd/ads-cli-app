package miu.lesson.midexam.service.impl;

import miu.lesson.midexam.service.ReportService;

import java.time.LocalDate;

public class ReportServiceImpl implements ReportService {

    @Override
    public int getNextQuarterNum() {
        int q = (LocalDate.now().getMonthValue() - 1) / 3 + 1;
        return (q % 4) + 1;
    }

    @Override
    public int getNextQuarterYear() {
        LocalDate today = LocalDate.now();
        int q = (today.getMonthValue() - 1) / 3 + 1;
        return q == 4 ? today.getYear() + 1 : today.getYear();
    }

    @Override
    public LocalDate getNextQuarterStart() {
        int nextQ = getNextQuarterNum();
        int year  = getNextQuarterYear();
        return LocalDate.of(year, (nextQ - 1) * 3 + 1, 1);
    }

    @Override
    public LocalDate getNextQuarterEnd() {
        return getNextQuarterStart().plusMonths(3).minusDays(1);
    }
}
