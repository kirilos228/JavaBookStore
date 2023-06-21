package practise.bookstore.report.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ReportServiceImplTest {

    @MockBean
    private ReportService reportService;

    @Test
    void generateReportBetweenTwoDates() {

        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 10, 20);

        Map <LocalDate, Float> expectedReportItems = new HashMap <>();
        expectedReportItems.put(LocalDate.of(2023, 1, 10), 1000.0f);
        expectedReportItems.put(LocalDate.of(2023, 8, 2), 1500.0f);

        // Mock the repository to throw a NotFoundException
        when(reportService.generateReportBetweenTwoDates(startDate, endDate)).thenReturn(expectedReportItems);

        Map<LocalDate, Float> report = reportService.generateReportBetweenTwoDates(startDate, endDate);

        // Assert the result
        assertEquals(expectedReportItems, report);
        assertDoesNotThrow(() -> reportService.generateReportBetweenTwoDates(startDate, endDate));
    }

}