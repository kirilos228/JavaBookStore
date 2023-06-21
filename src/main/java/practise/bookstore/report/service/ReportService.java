package practise.bookstore.report.service;

import java.time.LocalDate;
import java.util.Map;

public interface ReportService {

    Map <LocalDate, Float> generateReportBetweenTwoDates(LocalDate localDateFrom, LocalDate localDateTo);

}
