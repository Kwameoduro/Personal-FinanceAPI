package com.verlockt.models.response;


public class TransactionUpdateResponse {
    private boolean success;
    private String message;
    private Data data;

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public Data getData() { return data; }

    public static class Data {
        private int id;
        private int userId;
        private String recipientSender;
        private double amount;
        private String type;
        private String categoryName;
        private String transactionDate;
        private boolean isRecurring;
        private String frequency;
        private String endDate;
        private String transactionImage;

        public int getId() { return id; }
        public int getUserId() { return userId; }
        public String getRecipientSender() { return recipientSender; }
        public double getAmount() { return amount; }
        public String getType() { return type; }
        public String getCategoryName() { return categoryName; }
        public String getTransactionDate() { return transactionDate; }
        public boolean isRecurring() { return isRecurring; }
        public String getFrequency() { return frequency; }
        public String getEndDate() { return endDate; }
        public String getTransactionImage() { return transactionImage; }
    }
}
