package com.example.sontes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormModel implements Serializable {
    
    private String deliveryDate;
    private String projectName;
    private String boreholeeName;
    private String latitude;
    private String longitude;
    private String wellHeadPhoto;
    private String plannedBoreholeLength;
    private String deliveredBoreholeLength;
    private List<String> casePhotos;
    private String groundwaterLevel;
    private String measurementDate;
    private int sptTestCount;
    private int pressiometerTestCount;
    private int udSampleCount;
    private int disturbedSampleCount;
    private boolean labSamplesDelivered;
    
    public FormModel() {
        this.casePhotos = new ArrayList<>();
    }
    
    // Getters and Setters
    public String getDeliveryDate() { return deliveryDate; };
    public void setDeliveryDate(String deliveryDate) { this.deliveryDate = deliveryDate; };
    
    public String getProjectName() { return projectName; };
    public void setProjectName(String projectName) { this.projectName = projectName; };
    
    public String getBoreholeeName() { return boreholeeName; };
    public void setBoreholeeName(String boreholeeName) { this.boreholeeName = boreholeeName; };
    
    public String getLatitude() { return latitude; };
    public void setLatitude(String latitude) { this.latitude = latitude; };
    
    public String getLongitude() { return longitude; };
    public void setLongitude(String longitude) { this.longitude = longitude; };
    
    public String getWellHeadPhoto() { return wellHeadPhoto; };
    public void setWellHeadPhoto(String wellHeadPhoto) { this.wellHeadPhoto = wellHeadPhoto; };
    
    public String getPlannedBoreholeLength() { return plannedBoreholeLength; };
    public void setPlannedBoreholeLength(String plannedBoreholeLength) { this.plannedBoreholeLength = plannedBoreholeLength; };
    
    public String getDeliveredBoreholeLength() { return deliveredBoreholeLength; };
    public void setDeliveredBoreholeLength(String deliveredBoreholeLength) { this.deliveredBoreholeLength = deliveredBoreholeLength; };
    
    public List<String> getCasePhotos() { return casePhotos; };
    public void setCasePhotos(List<String> casePhotos) { this.casePhotos = casePhotos; };
    
    public String getGroundwaterLevel() { return groundwaterLevel; };
    public void setGroundwaterLevel(String groundwaterLevel) { this.groundwaterLevel = groundwaterLevel; };
    
    public String getMeasurementDate() { return measurementDate; };
    public void setMeasurementDate(String measurementDate) { this.measurementDate = measurementDate; };
    
    public int getSptTestCount() { return sptTestCount; };
    public void setSptTestCount(int sptTestCount) { this.sptTestCount = sptTestCount; };
    
    public int getPressiometerTestCount() { return pressiometerTestCount; };
    public void setPressiometerTestCount(int pressiometerTestCount) { this.pressiometerTestCount = pressiometerTestCount; };
    
    public int getUdSampleCount() { return udSampleCount; };
    public void setUdSampleCount(int udSampleCount) { this.udSampleCount = udSampleCount; };
    
    public int getDisturbedSampleCount() { return disturbedSampleCount; };
    public void setDisturbedSampleCount(int disturbedSampleCount) { this.disturbedSampleCount = disturbedSampleCount; };
    
    public boolean isLabSamplesDelivered() { return labSamplesDelivered; };
    public void setLabSamplesDelivered(boolean labSamplesDelivered) { this.labSamplesDelivered = labSamplesDelivered; };
}