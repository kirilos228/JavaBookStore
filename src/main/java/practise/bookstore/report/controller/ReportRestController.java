package practise.bookstore.report.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practise.bookstore.report.service.ReportService;

import java.time.LocalDate;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
public class ReportRestController {

    private final ReportService reportService;

    public ReportRestController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{startDate}:{endDate}")
    public ResponseEntity <Map <LocalDate, Float>> generateReport(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate startDate,
                                                                  @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy.MM.dd") LocalDate endDate) {
        return ResponseEntity.ok(reportService.generateReportBetweenTwoDates(startDate, endDate));
    }


}
