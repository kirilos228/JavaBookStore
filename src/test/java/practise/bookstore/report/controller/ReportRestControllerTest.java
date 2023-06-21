package practise.bookstore.report.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import practise.bookstore.report.service.ReportService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReportRestController.class)
class ReportRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReportService reportService;

    @Test
    public void testGenerateReport() throws Exception {

        Map <LocalDate, Float> expectedReportItems = new HashMap <>();
        expectedReportItems.put(LocalDate.of(2023, 1, 1), 1000.0f);
        expectedReportItems.put(LocalDate.of(2023, 1, 2), 1500.0f);

        when(reportService.generateReportBetweenTwoDates(any(LocalDate.class), any(LocalDate.class)))
                .thenReturn(expectedReportItems);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/reports/{startDate}:{endDate}", "2023.01.01", "2023.01.02")
                .accept(MediaType.ALL);

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$['2023-01-01']").value(1000.0))
                .andExpect(jsonPath("$['2023-01-02']").value(1500.0));

        verify(reportService).generateReportBetweenTwoDates(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 2));

    }

}