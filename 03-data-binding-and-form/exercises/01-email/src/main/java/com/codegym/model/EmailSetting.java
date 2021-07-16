package com.codegym.model;

public class EmailSetting {
    public String language;
    public int pageSize;
    public boolean enableSpamFilter;
    public String signature;

    public EmailSetting() {
    }

    public EmailSetting(String language, int pageSize, boolean enableSpamFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.enableSpamFilter = enableSpamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isEnableSpamFilter() {
        return enableSpamFilter;
    }

    public void setEnableSpamFilter(boolean enableSpamFilter) {
        this.enableSpamFilter = enableSpamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
