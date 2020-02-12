
public class Customer {
    private int goods;
    private int id;
    private long time;


    public Customer(long time, int id) {
        this.time = time;
        this.id = id;
    }

    public int getGoods() {
        return goods;
    }

    public void setGoods(int goods) {
        this.goods = goods;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
