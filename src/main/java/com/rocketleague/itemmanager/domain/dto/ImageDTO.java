package com.rocketleague.itemmanager.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class ImageDTO {
    private Integer failureCount;
    private Integer receivedCount;
    private Integer savedCount;
    private List<String> erroredFileNames;

    public ImageDTO() {
        this.erroredFileNames = new ArrayList<>();
    }

    public int getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(int failureCount) {
        this.failureCount = failureCount;
    }

    public int getReceivedCount() {
        return receivedCount;
    }

    public void setReceivedCount(int receivedCount) {
        this.receivedCount = receivedCount;
    }

    public int getSavedCount() {
        return savedCount;
    }

    public void setSavedCount(int savedCount) {
        this.savedCount = savedCount;
    }

    public List<String> getErroredFileNames() {
        return erroredFileNames;
    }

    public void setErroredFileNames(List<String> erroredFileNames) {
        this.erroredFileNames = erroredFileNames;
    }
}
