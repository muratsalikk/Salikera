package com.example.application.data.entity;

import com.example.application.data.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;

@Entity
public class Server extends AbstractEntity {

    @NotEmpty
    private String hostName = "";

    @NotEmpty
    private String ip = "";

    @NotEmpty
    private String userName = "";

    @NotEmpty
    private String nodeId = "";

    @NotEmpty
    private String prestoBinDirectory = "";

    @NotEmpty
    private String prestoDataDirectory = "";

    @NotNull
    private Long prestoDataDiskUsage = 0L;

    @NotNull
    private Long prestoDataDiskUsagePresto = 0L;

    @NotEmpty
    private String javaVersion = "";

    @NotEmpty
    private String prestoVersion = "";

    @NotEmpty
    private String OSVersion = "";

    @NotNull
    private Long cpuCores = 0L;

    @NotNull
    private Long cpuUsage = 0L;

    @NotNull
    private Long cpuUsagePresto = 0L;

    @NotNull
    private Long threadCount = 0L;

    @NotNull
    private Long threadCountPresto = 0L;

    @NotNull
    private Long memory = 0L;

    @NotNull
    private Long memoryUsage = 0L;

    @NotNull
    private Long memoryUsagePresto = 0L;

    @NotNull
    private Long lastUpdateTime = 0L;

    @Min(0)
    @Max(1)
    private Integer isCoordinator = 0;

    //@ManyToOne
    //@JoinColumn(name = "status_id")
    @NotEmpty
    private String status;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public Integer isCoordinator() {
        return isCoordinator;
    }

    public void setCoordinator(Integer coordinator) {
        isCoordinator = coordinator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getPrestoBinDirectory() {
        return prestoBinDirectory;
    }

    public void setPrestoBinDirectory(String prestoBinDirectory) {
        this.prestoBinDirectory = prestoBinDirectory;
    }

    public String getPrestoDataDirectory() {
        return prestoDataDirectory;
    }

    public void setPrestoDataDirectory(String prestoDataDirectory) {
        this.prestoDataDirectory = prestoDataDirectory;
    }

    public Long getPrestoDataDiskUsage() {
        return prestoDataDiskUsage;
    }

    public void setPrestoDataDiskUsage(Long prestoDataDiskUsage) {
        this.prestoDataDiskUsage = prestoDataDiskUsage;
    }

    public String getJavaVersion() {
        return javaVersion;
    }

    public Long getPrestoDataDiskUsagePresto() {
        return prestoDataDiskUsagePresto;
    }

    public void setPrestoDataDiskUsagePresto(Long prestoDataDiskUsagePresto) {
        this.prestoDataDiskUsagePresto = prestoDataDiskUsagePresto;
    }


    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
    }

    public String getPrestoVersion() {
        return prestoVersion;
    }

    public void setPrestoVersion(String prestoVersion) {
        this.prestoVersion = prestoVersion;
    }

    public String getOSVersion() {
        return OSVersion;
    }

    public void setOSVersion(String OSVersion) {
        this.OSVersion = OSVersion;
    }

    public Long getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Long cpuCores) {
        this.cpuCores = cpuCores;
    }

    public Long getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(Long cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public Long getCpuUsagePresto() {
        return cpuUsagePresto;
    }

    public void setCpuUsagePresto(Long cpuUsagePresto) {
        this.cpuUsagePresto = cpuUsagePresto;
    }

    public Long getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(Long threadCount) {
        this.threadCount = threadCount;
    }

    public Long getThreadCountPresto() {
        return threadCountPresto;
    }

    public void setThreadCountPresto(Long threadCountPresto) {
        this.threadCountPresto = threadCountPresto;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Long getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Long memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Long getMemoryUsagePresto() {
        return memoryUsagePresto;
    }

    public void setMemoryUsagePresto(Long memoryUsagePresto) {
        this.memoryUsagePresto = memoryUsagePresto;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Integer getIsCoordinator() {
        return isCoordinator;
    }

    public void setIsCoordinator(Integer isCoordinator) {
        this.isCoordinator = isCoordinator;
    }
}

