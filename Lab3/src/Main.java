
public class Main{
    public static void main(String[] args) {
        HashTable<Integer, Order> shop = new HashTable<>();
        Order order1 = new Order("01.01.2000", new String[]{"apple", "banana", "meat"}, "accepted");
        Order order2 = new Order("05.09.2000", new String[]{"bear", "notebook", "penсil", "phone"}, "accepted");

        System.out.println(shop.isEmpty());
        shop.put(11134, order1);
        shop.put(13245, order2);
        System.out.println(shop.get(11134).getOrderStatus());
        shop.get(11134).setOrderStatus("done");
        System.out.println(shop.get(11134).getOrderStatus());
        System.out.println(shop.get(11134));
        System.out.println(shop.get(13245));
        System.out.println(shop.size());
        shop.delete(11134);
        System.out.println(shop.get(11134));
        System.out.println(shop.get(13245));
        System.out.println(shop.size());
        System.out.println(shop.isEmpty());
    }
}