package Classes;

/**
 * Created by anil on 10/06/2016.
 */
public class Item
{
    private Object objectID;
    private String itemName;
    private double itemPrice;
    private boolean isVegan;
    private CaloricLevel caloricLevel;
    private int calorieCount;
    private Type type;
    private ItemCategory itemCategory;


    public Item()
    {
    }


    public Item( Object objectID, String itemName, double itemPrice, boolean isVegan, CaloricLevel caloricLevel, Type type, ItemCategory itemCategory )
    {
        this.objectID = objectID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.isVegan = isVegan;
        this.caloricLevel = caloricLevel;
        this.type = type;
        this.itemCategory = itemCategory;
    }


    public Object getObjectID()
    {
        return objectID;
    }


    public String getItemName()
    {
        return itemName;
    }


    public void setItemName( String itemName )
    {
        this.itemName = itemName;
    }


    public double getItemPrice()
    {
        return itemPrice;
    }


    public void setItemPrice( double itemPrice )
    {
        this.itemPrice = itemPrice;
    }


    public boolean isVegan()
    {
        return isVegan;
    }


    public void setVegan( boolean vegan )
    {
        isVegan = vegan;
    }


    public Type getType()
    {
        return type;
    }


    public void setType( Type type )
    {
        this.type = type;
    }


    public int getCalorieCount()
    {
        return calorieCount;
    }


    private void setCalorieCount( int calorieCount )
    {
        this.calorieCount = calorieCount;
    }


    public void setCaloricLevel( CaloricLevel caloricLevel )
    {
        if( caloricLevel.equals( CaloricLevel.DIET ) )
        {
            setCalorieCount( 100 );
        }
        else if( caloricLevel.equals( CaloricLevel.NORMAL ) )
        {
            setCalorieCount( 200 );
        }
        else
        {
            setCalorieCount( 300 );
        }
    }


    public ItemCategory getItemCategory()
    {
        return itemCategory;
    }


    public void setItemCategory( ItemCategory itemCategory )
    {
        this.itemCategory = itemCategory;
    }


    public CaloricLevel getCaloricLevel()
    {
        return caloricLevel;
    }

    public enum Type
    {
        MEAT("MEAT"), FISH("FISH"), OTHER("OTHER");

        private String type;


        Type( String type )
        {
            this.type = type;
        }


        public String getType()
        {
            return type;
        }
    }

    public enum CaloricLevel
    {
        DIET("DIET"), NORMAL("NORMAL"), FAT("FAT");

        private String caloricLevel;


        CaloricLevel( String caloricLevel )
        {
            this.caloricLevel = caloricLevel;
        }


        public String getCaloricLevel()
        {
            return caloricLevel;
        }
    }

    public enum ItemCategory
    {
        STARTERS("STARTERS"), MAINS("MAINS"), KIDS("KIDS"), DRINKS("DRINKS"), DESSERTS("DESSERTS");

        private String itemCategory;


        ItemCategory( String itemCategory )
        {
            this.itemCategory = itemCategory;
        }


        public String getItemCategory()
        {
            return itemCategory;
        }
    }
}
