package cn.edu.seu.eye.core.data_transform;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by acer-pc on 2014/12/15.
 */
public class GetSQLServerRec {
    private int comRec;
    private int hardRec;
    private int dbRec;
    private Date comDate;
    private Date hardDate;
    private Date dbDate;

    public void setComRec(int comRec) {
        this.comRec = comRec;
    }

    public void setHardRec(int hardRec) {
        this.hardRec = hardRec;
    }

    public void setDbRec(int dbRec) {
        this.dbRec = dbRec;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public void setHardDate(Date hardDate) {
        this.hardDate = hardDate;
    }

    public void setDbDate(Date dbDate) {
        this.dbDate = dbDate;
    }

    public int getComRec() {
        return comRec;
    }

    public int getHardRec() {
        return hardRec;
    }

    public int getDbRec() {
        return dbRec;
    }

    public Date getComDate() {
        return comDate;
    }

    public Date getHardDate() {
        return hardDate;
    }

    public Date getDbDate() {
        return dbDate;
    }

    //读取SQL Server中COMPUTER记录
    public GetSQLServerRec checkRec()
    {
        Connection con = new BatchImportData().init();
        GetSQLServerRec getSQLServerRec = new GetSQLServerRec();
        try
        {
            String sql = "select * from SYS_COMPUTERS";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next())
            {
                getSQLServerRec.comRec++;
            }

            String sql1 = "select * from SYS_HARDWARE";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ResultSet resultSet1 = ps1.executeQuery();

            while (resultSet1.next())
            {
                getSQLServerRec.hardRec++;
            }
            String sql2 = "select * from SYS_DATABASE";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet resultSet2 = ps2.executeQuery();

            while (resultSet2.next())
            {
                getSQLServerRec.dbRec++;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return getSQLServerRec;
    }

    public GetSQLServerRec getLastRec()
    {
        Connection con = new BatchImportData().init();
        GetSQLServerRec getSQLServerRec = new GetSQLServerRec();
        try
        {
            String sql1 = "select top 1 * from SYS_HARDWARE where order by time desc ";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ResultSet resultSet1 = ps1.executeQuery();
            getSQLServerRec.hardDate = resultSet1.getDate("UPDATA_TIME");

            String sql2 = "select top 1 * from SYS_DATABASE where order by time desc";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet resultSet2 = ps2.executeQuery();
            getSQLServerRec.dbDate = resultSet2.getDate("UPDATA_TIME");

        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return getSQLServerRec;

    }

}
