package oop.homework1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 第二种设计中的管理类
 *
 * @author Kamiu 2021/11/05 8:42
 */
public class NewLicenseManage {

    /**
     * 驾照列表
     */
    private HashMap<Long, License> licenses;

    public NewLicenseManage() {
        this.licenses = new HashMap<>();
    }

    /**
     * 注册功能
     *
     * @param no     驾驶证编号
     * @param name   姓名
     * @param type   类型
     * @param date   发行日期
     * @param expiry 有效期（天）
     * @return 当前驾驶证数量
     */
    public int register(long no, String name, String type, Date date, int expiry) {
        License license = new License(no, name, type, date, expiry);
        this.licenses.put(no, license);
        return this.licenses.size();
    }

    /**
     * 注销功能
     *
     * @param no 驾驶证编号
     */
    public void cancel(Long no) {
        licenses.remove(no);
    }

    /**
     * 查找功能
     *
     * @param no 驾驶证编号
     * @return 驾驶证对象
     */
    private License lookup(Long no) {
        return licenses.get(no);
    }

    /**
     * 获取用户名
     *
     * @param no 驾驶证编号
     * @return 驾驶证用户名
     */
    public String getName(Long no) {
        return licenses.get(no).getName();
    }

    /**
     * 获取类型
     *
     * @param no 驾驶证编号
     * @return 驾驶证类型
     */
    public String getType(Long no) {
        return licenses.get(no).getType();
    }

    /**
     * 获取到期日期
     *
     * @param no 驾驶证编号
     * @return 驾驶证到期日期
     */
    public Date getExpiryDate(Long no) {
        return licenses.get(no).getEnpiryDate();
    }

    /**
     * 设置类型
     *
     * @param no   驾驶证编号
     * @param type 驾驶证类型
     */
    public void setType(Long no, String type) {
        licenses.get(no).setType(type);
    }

    /**
     * 延长过期
     *
     * @param no 驾驶证编号
     * @param ex 延长日期
     */
    public void extendExpiry(Long no, int ex) {
        License license = licenses.get(no);
        license.setExpiry(ex + license.getExpiry());
    }

}
