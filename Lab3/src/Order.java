public class Order {
    private String date;
    private String[] listGoods;
    private String orderStatus;

    public Order(String date, String[] listGoods, String statusOrder){
        this.date = date;
        this.listGoods = listGoods;
        this.orderStatus = statusOrder;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String[] getListGoods() {
        return listGoods;
    }

    public void setListGoods(String[] listGoods) {
        this.listGoods = listGoods;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String statusOrder) {
        this.orderStatus = statusOrder;
    }
}
