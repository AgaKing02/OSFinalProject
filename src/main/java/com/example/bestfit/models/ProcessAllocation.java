package com.example.bestfit.models;

public class ProcessAllocation {
    public int processNumber;
    public int processSize;
    public String blockNumber;

    public ProcessAllocation(int processNumber, int processSize, String blockNumber) {
        this.processNumber = processNumber;
        this.processSize = processSize;
        this.blockNumber = blockNumber;
    }

    public ProcessAllocation(int processNumber, int processSize) {
        this.processNumber = processNumber;
        this.processSize = processSize;
    }

    public int getProcessNumber() {
        return processNumber;
    }

    public void setProcessNumber(int processNumber) {
        this.processNumber = processNumber;
    }

    public int getProcessSize() {
        return processSize;
    }

    public void setProcessSize(int processSize) {
        this.processSize = processSize;
    }

    public String getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(String blockNumber) {
        this.blockNumber = blockNumber;
    }
}
