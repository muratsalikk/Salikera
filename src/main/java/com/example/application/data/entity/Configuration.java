package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Configuration extends AbstractEntity {

    @NotEmpty
    public String configurationName = "";

    @NotNull
    @ManyToOne
    @JoinColumn(name = "configuration_category_id")
    public ConfigurationCategory configurationCategory ;

    public String cValueType = "";

    public String cValueDefault = "";

    public String cValueAllowed = "";

    public String cValue = "";

    public String toolTip = "";

    public long timeStamp = 0L;

    public String getConfigurationName() {
        return configurationName;
    }

    public void setConfigurationName(String configurationName) {
        this.configurationName = configurationName;
    }

    public ConfigurationCategory getConfigurationCategory() {
        return configurationCategory;
    }

    public void setConfigurationCategory(ConfigurationCategory configurationCategory) {
        this.configurationCategory = configurationCategory;
    }

    public String getcValueType() {
        return cValueType;
    }

    public void setcValueType(String cValueType) {
        this.cValueType = cValueType;
    }

    public String getcValueDefault() {
        return cValueDefault;
    }

    public void setcValueDefault(String cValueDefault) {
        this.cValueDefault = cValueDefault;
    }

    public String getcValueAllowed() {
        return cValueAllowed;
    }

    public void setcValueAllowed(String cValueAllowed) {
        this.cValueAllowed = cValueAllowed;
    }

    public String getcValue() {
        return cValue;
    }

    public void setcValue(String cValue) {
        this.cValue = cValue;
    }

    public String getToolTip() {
        return toolTip;
    }

    public void setToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp() {
        this.timeStamp = System.nanoTime();
    }

}
