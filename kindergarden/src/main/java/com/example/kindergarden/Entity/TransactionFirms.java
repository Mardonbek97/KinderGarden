package com.example.kindergarden.Entity;

import com.example.kindergarden.enums.TransactionStatus;
import com.example.kindergarden.enums.TransactionType;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "transactions_firms")
public class TransactionFirms {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "firm_id", nullable = false)
    private KinderGardens kinderGardens;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "transaction_date_time")
    private Date transactionDateTime;
    private TransactionType transactionType;
    BigDecimal Amount;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "transaction_date")
    private Date transactionDate;
    private TransactionStatus transactionStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public KinderGardens getKinderGardens() {
        return kinderGardens;
    }

    public void setKinderGardens(KinderGardens kinderGardens) {
        this.kinderGardens = kinderGardens;
    }

    public Date getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(Date transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
