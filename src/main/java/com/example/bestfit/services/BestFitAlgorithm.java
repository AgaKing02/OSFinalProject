package com.example.bestfit.services;

import com.example.bestfit.models.ProcessAllocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestFitAlgorithm {
    // Method to allocate memory to blocks as per Best fit
    // algorithm
     public static List<ProcessAllocation> bestFit(int[] blockSize, int m, int[] processSize, int n) {
        List<ProcessAllocation> processAllocations = new ArrayList<>();
        // Stores block id of the block allocated to a
        // process
        int[] allocation = new int[n];

        // Initially no block is assigned to any process
        Arrays.fill(allocation, -1);

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++) {
            // Find the best fit block for current process
            int bestIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (blockSize[bestIdx] > blockSize[j])
                        bestIdx = j;
                }
            }

            // If we could find a block for current process
            if (bestIdx != -1) {
                // allocate block j to p[i] process
                allocation[i] = bestIdx;

                // Reduce available memory in this block.
                blockSize[bestIdx] -= processSize[i];
            }
        }

//        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            ProcessAllocation processAllocation = new ProcessAllocation(i + 1, processSize[i]);

//            System.out.print("   " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
//                System.out.print(allocation[i] + 1);
                processAllocation.setBlockNumber(String.valueOf(allocation[i] + 1));
            else
                processAllocation.setBlockNumber("Not Allocated");

            processAllocations.add(processAllocation);
        }
        return processAllocations;

    }

    // Driver Method
//    public static void main(String[] args) {
//        int[] blockSize = {100, 500, 200, 300, 600};
//        int[] processSize = {212, 417, 112, 426};
//        int m = blockSize.length;
//        int n = processSize.length;
//
//        bestFit(blockSize, m, processSize, n);
//    }
}
