package com.Phonpe.Json;

public class PaymentRequest {
    private String merchantId;
    private String merchantTransactionId;
    private String merchantUserId;
    private int amount;
    private String redirectUrl;
    private String redirectMode;
    private String callbackUrl;
    private String mobileNumber;
    private PaymentInstrument paymentInstrument;
	public String getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantTransactionId() {
		return merchantTransactionId;
	}
	public void setMerchantTransactionId(String merchantTransactionId) {
		this.merchantTransactionId = merchantTransactionId;
	}
	public String getMerchantUserId() {
		return merchantUserId;
	}
	public void setMerchantUserId(String merchantUserId) {
		this.merchantUserId = merchantUserId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getRedirectMode() {
		return redirectMode;
	}
	public void setRedirectMode(String redirectMode) {
		this.redirectMode = redirectMode;
	}
	public String getCallbackUrl() {
		return callbackUrl;
	}
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public PaymentInstrument getPaymentInstrument() {
		return paymentInstrument;
	}
	public void setPaymentInstrument(PaymentInstrument paymentInstrument) {
		this.paymentInstrument = paymentInstrument;
	}
    
    

    // Getters and setters for the fields
}

class PaymentInstrument {
    private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    // Getters and setters for the 'type' field
}

