package _study._doc._quick_example;

import java.sql.Date;

/**
 * @author 734070824@qq.com
 * @date 2019/4/18 17:12
 */
public class DeviceData {
    private String device;
    private String deviceType;
    private Double signal;
    private java.sql.Date time;
    // Getter and setter methods for each field


    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Double getSignal() {
        return signal;
    }

    public void setSignal(Double signal) {
        this.signal = signal;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}