package oop.homework2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 拍卖类
 *
 * @author Kamiu 2021/11/08 15:15
 */
public class Auction {

    /**
     * 拍卖物品
     */
    private HashMap<Integer, Goods> goodsMap;

    public Auction() {
        goodsMap = new HashMap<>();
    }

    /**
     * 主菜单
     */
    public void mainPage() {
        System.out.println("==============================================");
        System.out.println("拍卖系统\n1.添加拍品\n2.开始竞拍\n3.查看竞拍结果");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        if (str.equals("1")) {
            addGoods();
        } else if (str.equals("2")) {
            auctionStart();
        } else {
            checkGoods();
        }
    }

    /**
     * 添加待拍卖货物
     */
    public void addGoods() {
        System.out.println("请根据格式输入拍卖物品信息：id-名称-委托人-最低价");
        Goods goods = (Goods) input();
        goodsMap.put(goods.getId(), goods);
        mainPage();
    }


    /**
     * 获取输入生成对象
     *
     * @return 转义对象
     */
    public Object input() {
        Scanner input = new Scanner(System.in);
        String str = input.next();
        String[] s = str.split("-");
        if (s.length == 2) {
            return new Bid(s[0], Integer.parseInt(s[1]));
        } else if (s.length == 4) {
            return new Goods(Integer.parseInt(s[0]), s[1], s[2], Integer.parseInt(s[3]));
        }
        return null;
    }


    /**
     * 出价过程
     *
     * @param goods 货物信息
     * @param bid   投标信息
     * @return 出价是否成功
     */
    public boolean bid(Goods goods, Bid bid) {
        if (bid.getPrice() >= Math.max(goods.getBasePrice(), goods.getCurrentPrice())) {
            goods.setCurrentPrice(bid.getPrice());
            goods.setBuyer(bid.getName());
            return true;
        }
        return false;
    }


    /**
     * 开始拍卖
     */
    public int auctionStart() {
        System.out.println("请输入拍卖商品id：");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        Goods goods = goodsMap.get(Integer.parseInt(str));
        if (goods.getState() != 0) {
            System.out.println("该商品已结束竞拍!");
            mainPage();
            return 1;
        }
        while (true) {
            System.out.println("------------------------------------------------------");
            System.out.println("当前拍卖商品为：" + goods.getName() + ",起拍价为：" + goods.getBasePrice() + ",当前出价为：" + goods.getCurrentPrice());
            System.out.println("出价格式为：姓名-价格,输入finnish-0结束竞拍。\n请出价：");
            Bid bid = (Bid) input();
            //竞拍结束
            if (bid.getName().equals("finnish")) {
                System.out.println(goods.getName() + "竞拍结束。");
                if (goods.getCurrentPrice() == 0) {
                    //流拍
                    goods.setState(2);
                    System.out.println(goods.getName() + "已流拍。");
                    mainPage();
                    return 1;
                } else {
                    //正常结束
                    goods.setState(1);
                    goods.setFinalPrice(goods.getCurrentPrice());
                    System.out.println(goods.getName() + "中标价格：" + goods.getFinalPrice() + ",中标人：" + goods.getBuyer());
                    mainPage();
                    return 1;
                }
            }

            if (bid(goods, bid)) {
                System.out.println("出价成功");
            } else {
                System.out.println("出价失败");
            }
        }
    }


    /**
     * 查看竞拍结果
     */
    public void checkGoods() {
        System.out.println("请输入查看商品id：");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        Goods goods = goodsMap.get(Integer.parseInt(str));
        if (goods.getState() == 0) {
            System.out.println("该商品未参加拍卖。");
            mainPage();
        } else if (goods.getState() == 2) {
            System.out.println(goods.getName() + " 已流拍。");
            mainPage();
        } else {
            System.out.println(goods.getName() + "中标价格：" + goods.getFinalPrice() + ",中标人：" + goods.getBuyer());
            mainPage();
        }
    }

    public static void main(String[] args) {
        Auction auction = new Auction();
        auction.mainPage();

    }

}
