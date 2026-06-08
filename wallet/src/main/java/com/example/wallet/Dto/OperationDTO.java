package com.example.wallet.Dto;

public class OperationDTO {
    private Long operationId;
    private String operationType;
    private long category;
    private Double amount;
    private String createdAt; // Formatted date
    private String updatedAt; // Formatted date
    private Double amountSigned;
    private Double amountCredit;
    private Double amountDebit;

    // Constructor
    public OperationDTO(Long operationId, String operationType, long category, Double amount, String createdAt, String updatedAt, Double amountSigned, Double amountCredit, Double amountDebit) {
        this.operationId = operationId;
        this.operationType = operationType;
        this.category = category;
        this.amount = amount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.amountSigned = amountSigned;
        this.amountCredit = amountCredit;
        this.amountDebit = amountDebit;
    }

    // Getters and setters
    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public long getCategory() {
        return category;
    }

    public void setCategory(long category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getAmountSigned() {
        return amountSigned;
    }

    public void setAmountSigned(Double amountSigned) {
        this.amountSigned = amountSigned;
    }

    public Double getAmountCredit() {
        return amountCredit;
    }

    public void setAmountCredit(Double amountCredit) {
        this.amountCredit = amountCredit;
    }

    public Double getAmountDebit() {
        return amountDebit;
    }

    public void setAmountDebit(Double amountDebit) {
        this.amountDebit = amountDebit;
    }
}
