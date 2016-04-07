/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import java.util.ArrayList;

/**
 *
 * @author rama
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> WorkQueue;

    public WorkQueue() {
        WorkQueue = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkQueue() {
        return WorkQueue;
    }

    public void setWorkQueue(WorkRequest workRequest) {
        WorkQueue.add(workRequest);
    }
    
    
    
}