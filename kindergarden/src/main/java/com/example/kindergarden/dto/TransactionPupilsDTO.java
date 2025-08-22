package com.example.kindergarden.dto;

import com.example.kindergarden.Entity.KinderGardens;
import com.example.kindergarden.Entity.Pupils;
import com.example.kindergarden.enums.TransactionStatus;
import com.example.kindergarden.enums.TransactionType;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionPupilsDTO {

    private Long id;
    private Pupils pupils;
    private KinderGardens kinderGardens;
    private Date transactionDateTime;
    private TransactionType transactionType;
    BigDecimal Amount;
    private Date transactionDate;
    private TransactionStatus transactionStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pupils getPupils() {
        return pupils;
    }

    public void setPupils(Pupils pupils) {
        this.pupils = pupils;
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
