package miu.lesson.midexam.service;

import java.time.LocalDate;

public interface ReportService {

    int getNextQuarterNum();

    int getNextQuarterYear();

    LocalDate getNextQuarterStart();

    LocalDate getNextQuarterEnd();
}
