package cn.edu.seu.eye.module.base.entity.management;

/**
 * Created by DL on 2014/12/7.
 */
        import com.fasterxml.jackson.annotation.JsonInclude;
        import com.fasterxml.jackson.annotation.JsonInclude.Include;

        import javax.persistence.*;
        import java.io.Serializable;
        import java.sql.Timestamp;
        import java.util.List;
@Entity
@Table(name = "SYS_ALARMS")
@JsonInclude(Include.NON_NULL)
public class Alarm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ALARM_ID", columnDefinition = "INT|报警编号", nullable = false)
    private int alarmId;
    @Column(name = "COMPUTER_NAME", columnDefinition = "VARCHAR2|电脑名称", length = 20, nullable = false)
    private String computerName;
    @Column(name = "ALARM_TIME", columnDefinition = "smalldatetime|报警时间", length = 4, nullable = false)
    private Timestamp alarmTime;
    @Column(name = "ALARM_MESSAGE", columnDefinition = "VARCHAR2|报警信息", length = 100, nullable = true)
    private String alarmMessage;
    @Column(name = "ALARM_LEVEL", columnDefinition = "int|报警信息", length = 4, nullable = true)
    private int alarmLevel;

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public Timestamp getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Timestamp alarmTime) {
        this.alarmTime = alarmTime;
    }

    public String getAlarmMessage() {
        return alarmMessage;
    }

    public void setAlarmMessage(String alarmMessage) {
        this.alarmMessage = alarmMessage;
    }

    public int getAlarmLevel() {
        return alarmLevel;
    }

    public void setAlarmLevel(int alarmLevel) {
        this.alarmLevel = alarmLevel;
    }

    public static final String ALARM_ID="alarmId";
    public static final String COMPUTER_NAME="computerName";
    public static final String ALARM_TIME="alarmTime";
    public static final String ALARM_MESSAGE="alarmMessage";
    public static final String ALARM_LEVEL="alarmLevel";

    public static final String[] All_FIELDS = new String[] { ALARM_ID, COMPUTER_NAME, ALARM_TIME, ALARM_MESSAGE,ALARM_LEVEL};

}
