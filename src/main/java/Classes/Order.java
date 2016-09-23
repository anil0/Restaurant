package Classes;

import java.util.List;

/**
 * Created by anil on 10/06/2016.
 */
public class Order
{
    private int orderID;
    private String name;
    private double price;
    private List<Item> orderItems;


    public Order( int orderID, String name, double price, List<Item> orderItems )
    {
        this.orderID = orderID;
        this.name = name;
        this.price = price;
        this.orderItems = orderItems;
    }


    public int getOrderID()
    {
        return orderID;
    }


    public void setOrderID( int orderID )
    {
        this.orderID = orderID;
    }


    public String getName()
    {
        return name;
    }


    public void setName( String name )
    {
        this.name = name;
    }


    public double getPrice()
    {
        return price;
    }


    public void setPrice( double price )
    {
        this.price = price;

    }


    public List<Item> getOrderItems()
    {
        return orderItems;
    }


    public void setOrderItems( List<Item> orderItems )
    {
        this.orderItems = orderItems;
    }
}
