package oop.homework2;

/**
 * 商品类
 *
 * @author Kamiu 2021/11/08 15:14
 */
public class Goods {

    /**
     * 货物编号
     */
    private int id;

    /**
     * 货物名称
     */
    private String name;

    /**
     * 委托人
     */
    private String owner;

    /**
     * 保留价
     */
    private int basePrice;

    /**
     * 当前价
     */
    private int currentPrice;

    /**
     * 成交价
     */
    private int finalPrice;

    /**
     * 购买人
     */
    private String buyer;

    /**
     * 状态： 0-未拍卖 1-已拍出 2-流拍
     */
    private int state;

    public Goods(int id, String name, String owner, int basePrice) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.basePrice = basePrice;
        this.currentPrice = 0;
        this.finalPrice = 0;
        this.state = 0;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", basePrice=" + basePrice +
                ", currentPrice=" + currentPrice +
                ", finalPrice=" + finalPrice +
                ", buyer='" + buyer + '\'' +
                ", state=" + state +
                '}';
    }
}
