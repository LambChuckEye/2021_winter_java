package oop.homework1;

import java.util.Calendar;
import java.util.Date;

/**
 * 驾驶证类
 *
 * @author Kamiu 2021/11/05 8:18
 */
public class License {

    /**
     * 驾驶证编号
     */
    private long no;

    /**
     * 姓名
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 发证日期
     */
    private Date date;

    /**
     * 有效期 (天)
     */
    private int expiry;

    /**
     * 构造方法
     *
     * @param no     驾驶证编号
     * @param name   姓名
     * @param type   类型
     * @param date   发行日期
     * @param expiry 有效期（天）
     */
    public License(long no, String name, String type, Date date, int expiry) {
        this.no = no;
        this.name = name;
        this.type = type;
        this.date = date;
        this.expiry = expiry;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }

    /**
     * 获得驾照到期日期
     *
     * @return 到期日期
     */
    public Date getEnpiryDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.date);
        c.add(Calendar.DATE, this.expiry);
        Date newDate = c.getTime();
        return newDate;
    }

    @Override
    public String toString() {
        return "License{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", expiry=" + expiry +
                '}';
    }


}
