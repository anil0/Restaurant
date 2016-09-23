package DAO;

import java.util.ArrayList;
import java.util.List;

import Classes.Item;
import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;



/**
 * Created by anil on 22/05/2016.
 */
public class ItemDAOController
{
    private static MongoCollection<Document> collection;
    private static MongoDatabase database;


    public static void connect() throws Exception
    {
        MongoClient mongoClient = new MongoClient( new MongoClientURI( "mongodb://localhost:27017" ) );

        mongoClient.getAddress();

        database = mongoClient.getDatabase( "Restaurant" );
        getCollection();
    }


    private static void getCollection()
    {
        collection = database.getCollection( "Items" );
    }


    public static List<Item> getAllItems()
    {
        final List<Item> products = new ArrayList<>();

        try
        {
            for( Document doc : collection.find() )
            {
                if( doKeysExist( doc ) )
                {
                    products.add( new Item( doc.getObjectId( "_id" ),
                                            doc.getString( "itemName" ),
                                            doc.getDouble( "itemPrice" ),
                                            doc.getBoolean("isVegan"),
                                            Item.CaloricLevel.valueOf( doc.getString( "caloricLevel" ) ),
                                            Item.Type.valueOf( doc.getString( "type" ) ),
                                            Item.ItemCategory.valueOf( doc.getString( "itemCategory" ) ) ) );
                }
            }
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }

        return products;
    }


//    public static boolean addItem( Item item )
//    {
//        if( item.getItemQuantity() <= 0 )
//        {
//            item.setItemQuantity( 0 );
//            item.setInStock( false );
//        }
//        else
//        {
//            item.setInStock( true );
//      }
//
//        Document newItem = new Document( "itemName", item.getItemName() );
//        newItem.append( "itemCost", item.getItemCost() );
//        newItem.append( "itemQuantity", item.getItemQuantity() );
//        newItem.append( "itemIsInStock", item.isInStock() );
//
//        try
//        {
//            collection.insertOne( newItem );
//            return true;
//        }
//        catch( Exception e )
//        {
//            return false;
//        }
//    }


//    public static boolean updateItem( Item item )
//    {
//        try
//        {
//            Bson filter = new Document( "itemName", item.getItemName() );
//
//            Bson updatedValues = new Document( "itemQuantity", item.getItemQuantity() )
//                                      .append( "itemIsInStock", item.isInStock() )
//                                      .append( "itemCost", item.getItemCost() );
//
//            Bson updateDocument = new Document( "$set", updatedValues );
//
//            collection.updateOne( filter, updateDocument );
//
//            return true;
//        }
//        catch ( Exception e )
//        {
//            return false;
//        }
//    }


    public static boolean removeItem( String itemName )
    {
        try
        {
            Bson doc = new Document( "itemName", itemName );
            collection.findOneAndDelete( doc );
            return true;
        }
        catch ( Exception e )
        {
            return false;
        }
    }


//    public static void updateItems( Item item )
//    {
//        Bson filter = new Document( "itemName", item.getItemName() );
//        Bson updatedValues = new Document( "itemQuantity", item.getItemQuantity() )
//                .append( "itemIsInStock", item.isInStock() );
//        Bson updateDocument = new Document( "$set", updatedValues );
//
//        collection.updateOne( filter, updateDocument );
//    }


    private static boolean doKeysExist( Document next )
    {
        List<String> availableKeys = new ArrayList<>();
        availableKeys.add( "itemName" );
        availableKeys.add( "itemPrice" );
        availableKeys.add( "isVegan" );
        availableKeys.add( "caloricLevel" );
        availableKeys.add( "type" );
        availableKeys.add( "itemCategory" );

        for( String key : availableKeys )
        {
            if( !next.containsKey( key ) )
            {
                return false;
            }
        }

        return true;
    }
}