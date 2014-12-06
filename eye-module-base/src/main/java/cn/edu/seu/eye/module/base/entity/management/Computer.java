package cn.edu.seu.eye.module.base.entity.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by DL on 2014/12/1.
 */
@Entity
@Table(name = "SYS_COMPUTERS")
@JsonInclude(Include.NON_NULL)
public class Computer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "COMPUTER_ID", columnDefinition = "INT|电脑ID", nullable = false)
    private int computerId;
    @Column(name = "COMPUTER_NAME", columnDefinition = "VARCHAR2|电脑名称", length = 50, nullable = true)
    private String computerName;
    @Column(name = "COMPUTER_IP", columnDefinition = "VARCHAR2|电脑IP", length = 25, nullable = true)
    private String computerIp;
    @Column(name = "COMPUTER_OS", columnDefinition = "VARCHAR2|电脑系统信息", length = 50, nullable = true)
    private String computerOs;
    @Column(name = "COMPUTER_CPU", columnDefinition = "VARCHAR2|电脑CPU信息", length = 50, nullable = true)
    private String computerCpu;
    @Column(name = "COMPUTER_RAM", columnDefinition = "VARCHAR2|电脑RAM信息", length = 50, nullable = true)
    private String computerRam;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getComputerId() {
        return computerId;
    }

    public void setComputerId(int computerId) {
        this.computerId = computerId;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public String getComputerIp() {
        return computerIp;
    }

    public void setComputerIp(String computerIp) {
        this.computerIp = computerIp;
    }

    public String getComputerOs() {
        return computerOs;
    }

    public void setComputerOs(String computerOs) {
        this.computerOs = computerOs;
    }

    public String getComputerCpu() {
        return computerCpu;
    }

    public void setComputerCpu(String computerCpu) {
        this.computerCpu = computerCpu;
    }

    public String getComputerRam() {
        return computerRam;
    }

    public void setComputerRam(String computerRam) {
        this.computerRam = computerRam;
    }

    public static final String COMPUTER_ID="computerId";
    public static final String COMPUTER_NAME="computerName";
    public static final String COMPUTER_IP="computerIp";
    public static final String COMPUTER_OS="computerOs";
    public static final String COMPUTER_CPU="computerCpu";
    public static final String COMPUTER_RAM="computerRam";

    public static final String[] All_FIELDS = new String[] { COMPUTER_ID, COMPUTER_NAME, COMPUTER_IP, COMPUTER_OS, COMPUTER_CPU, COMPUTER_RAM};

}
