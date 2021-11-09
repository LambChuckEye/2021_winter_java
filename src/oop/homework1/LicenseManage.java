package oop.homework1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 第一种设计中的管理类
 *
 * @author Kamiu 2021/11/05 8:29
 */
public class LicenseManage {


    /**
     * 驾照列表
     */
    private HashMap<Long,License> licenses;

    public LicenseManage() {
        this.licenses = new HashMap<>();
    }

    /**
     * 注册功能
     *
     * @param license 驾驶证对象
     * @return 当前驾驶证数量
     */
    public int register(License license) {
        this.licenses.put(license.getNo(),license);
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
    public License lookup(Long no) {
        return licenses.get(no);
    }


}
