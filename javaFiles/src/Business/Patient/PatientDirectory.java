/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author rama
 */
public class PatientDirectory {
    
    
    private ArrayList<Patient> patientDirectory;

    public PatientDirectory() {
        this.patientDirectory = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientDirectory() {
        return patientDirectory;
    }

    public void setPatientDirectory(Patient patient) {
        this.patientDirectory.add(patient);
    }
    
    
    
}
