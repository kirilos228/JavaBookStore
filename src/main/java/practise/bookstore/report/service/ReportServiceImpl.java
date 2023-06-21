package practise.bookstore.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practise.bookstore.report.dao.ReportRepository;
import practise.models.order.Order;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Autowired
    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public Map <LocalDate, Float> generateReportBetweenTwoDates(LocalDate localDateFrom, LocalDate localDateTo) {

        List <Order> byCreatedDateBetween = reportRepository.findByCreatedDateBetween(localDateFrom.atStartOfDay(), localDateTo.atStartOfDay());
        Map <LocalDate, Float> reportItems = new HashMap <>();
        byCreatedDateBetween.stream().sorted(Comparator.comparing(Order::getCreatedDate))
                .forEach(order -> reportItems.put(order.getCreatedDate().toLocalDate(), order.getTotalPrice().floatValue()));

        return reportItems;
    }


}
