package com.verlockt.models.request;


import java.time.LocalDate;

public class TransactionUpdateRequest {
    private final String recipientSender;
    private final String transactionType;
    private final int categoryId;
    private final double amount;
    private final LocalDate transactionDate;
    private final boolean isRecurring;
    private final LocalDate endDate;
    private final String frequency;
    private final boolean removeExistingImage;

    public TransactionUpdateRequest(String recipientSender, String transactionType, int categoryId, double amount,
                                    LocalDate transactionDate, boolean isRecurring, LocalDate endDate,
                                    String frequency, boolean removeExistingImage) {
        this.recipientSender = recipientSender;
        this.transactionType = transactionType;
        this.categoryId = categoryId;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isRecurring = isRecurring;
        this.endDate = endDate;
        this.frequency = frequency;
        this.removeExistingImage = removeExistingImage;
    }

    public String getRecipientSender() { return recipientSender; }
    public String getTransactionType() { return transactionType; }
    public int getCategoryId() { return categoryId; }
    public double getAmount() { return amount; }
    public LocalDate getTransactionDate() { return transactionDate; }
    public boolean isRecurring() { return isRecurring; }
    public LocalDate getEndDate() { return endDate; }
    public String getFrequency() { return frequency; }
    public boolean isRemoveExistingImage() { return removeExistingImage; }
}