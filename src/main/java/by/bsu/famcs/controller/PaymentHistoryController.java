package by.bsu.famcs.controller;

import by.bsu.famcs.dto.PaymentHistoryDto;
import by.bsu.famcs.filter.PaymentHistoryFilter;
import by.bsu.famcs.service.PaymentHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import static by.bsu.famcs.security.SecurityPermission.EDIT_PAYMENTS;
import static by.bsu.famcs.security.SecurityPermission.READ_PAYMENTS;

@RestController
@RequestMapping("/payment-history")
public class PaymentHistoryController {

    private static final String PAYMENT_HISTORY_ID_PARAM = "{paymentHistoryId}";

    private final PaymentHistoryService paymentHistoryService;

    public PaymentHistoryController(PaymentHistoryService paymentHistoryService) {
        this.paymentHistoryService = paymentHistoryService;
    }

    @Secured(READ_PAYMENTS)
    @GetMapping
    public Page<PaymentHistoryDto> getAllPaymentHistories(PaymentHistoryFilter filter, Pageable pageable) {
        return paymentHistoryService.findAll(filter, pageable);
    }

    @Secured(READ_PAYMENTS)
    @GetMapping(PAYMENT_HISTORY_ID_PARAM)
    public ResponseEntity<PaymentHistoryDto> getPaymentHistoryById(@PathVariable String paymentHistoryId) {
        return ResponseEntity.of(paymentHistoryService.findById(paymentHistoryId));
    }

    @Secured(EDIT_PAYMENTS)
    @PostMapping
    public PaymentHistoryDto createPaymentHistory(@RequestBody PaymentHistoryDto paymentHistory) {
        return paymentHistoryService.create(paymentHistory);
    }

    @Secured(EDIT_PAYMENTS)
    @PutMapping(PAYMENT_HISTORY_ID_PARAM)
    public PaymentHistoryDto updatePaymentHistory(@RequestBody PaymentHistoryDto paymentHistory, @PathVariable String paymentHistoryId) {
        return paymentHistoryService.update(paymentHistory, paymentHistoryId);
    }

    @Secured(EDIT_PAYMENTS)
    @DeleteMapping(PAYMENT_HISTORY_ID_PARAM)
    public void removePaymentHistory(@PathVariable String paymentHistoryId) {
        paymentHistoryService.deleteById(paymentHistoryId);
    }

}
