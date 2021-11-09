package oop.homework1;

import java.util.Date;

/**
 * description
 *
 * @author Kamiu 2021/11/05 9:12
 */
public class ext {

    public static void main(String[] args) {

        License lic = new License(1L, "wang", "A", new Date(), 10);
        License lic1 = new License(2L, "Li", "B", new Date(), 10);
        License lic2 = new License(3L, "Zhang", "C", new Date(), 10);

        System.out.println("\n==============================================\n");

        LicenseManage licenseManage = new LicenseManage();
        licenseManage.register(lic);
        licenseManage.register(lic1);
        licenseManage.register(lic2);
        System.out.println(licenseManage.lookup(1L).getEnpiryDate());

        System.out.println(licenseManage.lookup(2L));
        licenseManage.cancel(2L);
        System.out.println(licenseManage.lookup(2L));

        System.out.println("\n==============================================\n");

        NewLicenseManage nlm = new NewLicenseManage();
        nlm.register(1L, "wang", "A", new Date(), 10);
        nlm.register(2L, "Li", "B", new Date(), 10);
        nlm.register(3L, "Zhang", "C", new Date(), 10);

        System.out.println(nlm.getName(1L));
        System.out.println(nlm.getType(2L));
        nlm.setType(2L, "C");
        System.out.println(nlm.getType(2L));

        System.out.println(nlm.getExpiryDate(1L));
        nlm.extendExpiry(1L, 10);
        System.out.println(nlm.getExpiryDate(1L));

        System.out.println("\n==============================================\n");
        System.out.println("驾驶证管理系统功能菜单：");
        System.out.println("1.驾驶证信息注册");
        System.out.println("2.驾驶证信息注销");
        System.out.println("3.驾驶证信息查询");
        System.out.println("4.驾驶证信息修改");
        System.out.println("请键入功能序号选择功能。");

        System.out.println("\n");
        System.out.println("1");
        System.out.println("请输入待注册驾驶证信息：");
        System.out.println("1 wang A 2021-10-10 10");
        System.out.println("注册成功，当前驾驶证数量： 1");

        System.out.println("\n");
        System.out.println("3");
        System.out.println("请输入待查询驾驶证信息：");
        System.out.println("1");
        System.out.println("查询成功：" +
                "\n 编号 = 1" +
                "\n 姓名：wang" +
                "\n 类型：A" +
                "\n 注册日期：2021-10-10" +
                "\n 过期日期：2021-10-20"
        );

        System.out.println("\n");
        System.out.println("4");
        System.out.println("请输入想要修改的项目以及修改值：" +
                "\n1. 修改类型" +
                "\n2. 延长有效期"
        );
        System.out.println("\n");
        System.out.println("1 B");
        System.out.println("已成功将类型修改为 B");
        System.out.println("\n");
        System.out.println("2 10");
        System.out.println("已成功将过期时间延长值 2021-10-30");

        System.out.println("\n");
        System.out.println("2");
        System.out.println("请输入待删除驾驶证编号：");
        System.out.println("1");
        System.out.println("删除成功，当前驾驶证数量： 0");


    }

}
