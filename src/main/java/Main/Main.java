package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import Alerts.Alert;
import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import Classes.Item;
import DAO.ItemDAOController;

/**
 * Created by anil on 10/06/2016.
 */
public class Main extends Application
{
    private Stage window;
    private Font font;
    private BackgroundSize backgroundSize;


    public static void main( String[] args ) throws Exception
    {
        launch( args );
    }


    @SuppressWarnings("WeakerAccess")
    public Main()
    {
        try
        {
            Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
            mongoLogger.setLevel( Level.SEVERE );

            System.out.println( "Please be patient while we attempt to load the database..." );
            ItemDAOController.connect();
        }
        catch( Exception ignored )
        {
            System.out.println( "Unable to load the database... Application quitting." );
            System.exit( 0 );
        }

        font = new Font( 20 );
        backgroundSize = new BackgroundSize( 200, 200, false, false, false, false );
    }


    @Override
    public void start( Stage primaryStage ) throws Exception
    {
        window = primaryStage;
        window.setTitle( "title" );

        GridPane grid = new GridPane();
        grid.setPadding( new Insets( 10, 10, 10, 10 ) ); //insets just lets you give 4 values
        grid.setVgap( 8 );
        grid.setHgap( 10 );
        RowConstraints row = new RowConstraints();
        row.setMinHeight( 10 );
        grid.getRowConstraints().add( row );

        int columnCount = 0;
        int rowCount = 0;
        for( Button button : setupButtons() )
        {
            //column then row ,0 0
            GridPane.setConstraints( button, columnCount++, rowCount ); //-- second column and first row
            if( columnCount == 3 )
            {
                columnCount = 0;
                rowCount++;
            }
            grid.getChildren().add( button );
        }

        Scene scene = new Scene( grid, 650, 500 );
        setUserAgentStylesheet( STYLESHEET_CASPIAN );
        window.setScene( scene );
        window.show();
    }


    private List<Button> setupButtons()
    {
        final List<Button> buttons = new ArrayList<>();

        final Color color = Color.GREY;
        final BackgroundRepeat noRepeat = BackgroundRepeat.NO_REPEAT;
        final double minWidth = 200;
        final double minHeight = 240;

        ///////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////
        Background background = new Background(
                new BackgroundImage( new Image( "starter.jpg" ), noRepeat, noRepeat, null, backgroundSize ) );
        Button starters = new Button( "Starters" );
        starters.setAlignment( Pos.BOTTOM_CENTER );
        starters.setTextFill( color );
        //starters.setStyle("-fx-opacity: 1; -fx-background-image: url(starter.jpg); -fx-background-size: cover; -fx-text-fill: black; -fx-font-weight: 500; -fx-font-size: 20pt");
        starters.setFont( font );
        starters.setBackground( background );
        //starters.setStyle("-fx-border-color: red");
        starters.setMinSize( minWidth, minHeight );
        starters.setOnAction( e -> Order( starters.getText() ) );
        buttons.add( starters );

        ///////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////
        Background background2 = new Background(
                new BackgroundImage( new Image( "main.jpg" ), noRepeat, noRepeat, null, backgroundSize ) );
        Button mains = new Button( "Mains" );
        mains.setAlignment( Pos.BOTTOM_CENTER );
        mains.setTextFill( color );
        mains.setFont( font );
        //mains.setStyle("-fx-opacity: 0.7; -fx-background-image: url(main.jpg); -fx-background-size: cover; -fx-text-fill: black; -fx-font-weight: 500; -fx-font-size: 20pt");
        mains.setBackground( background2 );
        mains.setMinSize( minWidth, minHeight );
        mains.setOnAction( e -> Order( mains.getText() ) );
        buttons.add( mains );

        ///////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////
        Background background3 = new Background(
                new BackgroundImage( new Image( "dessert.jpg" ), noRepeat, noRepeat, null, backgroundSize ) );
        Button desserts = new Button( "Desserts" );
        desserts.setAlignment( Pos.BOTTOM_CENTER );
        desserts.setTextFill( color );
        desserts.setFont( font );
        //desserts.setStyle("-fx-opacity: 0.7; -fx-background-image: url(dessert.jpg); -fx-background-size: cover; -fx-text-fill: black; -fx-font-weight: 500; -fx-font-size: 20pt");
        desserts.setBackground( background3 );
        desserts.setMinSize( minWidth, minHeight );
        desserts.setOnAction( e -> Order( desserts.getText() ) );
        buttons.add( desserts );

        ///////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////
        Background background4 = new Background(
                new BackgroundImage( new Image( "kids.jpg" ), noRepeat, noRepeat, null, backgroundSize ) );
        Button kids = new Button( "Kids" );
        kids.setAlignment( Pos.BOTTOM_CENTER );
        kids.setTextFill( color );
        kids.setFont( font );
        //kids.setStyle("-fx-opacity: 0.7; -fx-background-image: url(kids.jpg); -fx-background-size: cover; -fx-text-fill: black; -fx-font-weight: 500; -fx-font-size: 20pt");
        kids.setBackground( background4 );
        kids.setMinSize( minWidth, minHeight );
        kids.setOnAction( e -> Order( kids.getText() ) );
        buttons.add( kids );

        ///////////////////////////////////////////////////////////////////////////
        //
        ///////////////////////////////////////////////////////////////////////////
        Background background5 = new Background(
                new BackgroundImage( new Image( "drinks.png" ), noRepeat, noRepeat, null, backgroundSize ) );
        Button drinks = new Button( "Drinks" );
        drinks.setAlignment( Pos.BOTTOM_CENTER );
        drinks.setTextFill( color );
        drinks.setFont( font );
        //drinks.setStyle("-fx-opacity: 0.7; -fx-background-image: url(drink.jpg); -fx-background-size: cover; -fx-text-fill: black; -fx-font-weight: 500; -fx-font-size: 20pt");
        drinks.setBackground( background5 );
        drinks.setMinSize( minWidth, minHeight );
        drinks.setOnAction( e -> Order( drinks.getText() ) );
        buttons.add( drinks );

        return buttons;
    }


    private void Order( String text )
    {
        final ObservableList<Item> items = sortItemCategory( text );
        if( items.isEmpty() )
        {
            Alert.display("Warning","No items found.");
            return;
        }

        Stage window = new Stage();


        TableView<Item> table;


        //filteredList.addAll( items );
        VBox vBox = new VBox();

        //making columns
        //name column
        TableColumn<Item, String> nameColumn = new TableColumn<>( "Name" ); //The "Name" is the column header can be anything
        nameColumn.setMinWidth( 200 ); //keep columns orgnanised
        nameColumn.setCellValueFactory( new PropertyValueFactory<>( "itemName" ) ); //set the value of this column items to the vlaue from out product names, "name" is the variable

        //price column
        TableColumn<Item, Double> priceColumn = new TableColumn<>( "Price" );
        priceColumn.setMinWidth( 100 ); //keep columns orgnanised
        priceColumn.setCellValueFactory( new PropertyValueFactory<>( "itemPrice" ) );

        FilteredList<Item> filteredList = new FilteredList<>( items, i -> true );

        //        CheckBox meat = new CheckBox( "Meat" );
        //        CheckBox vegan = new CheckBox( "Vegan" );
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        setupChoiceBox( text, choiceBox );

        //listen for any selection changes
        choiceBox.getSelectionModel()
                .selectedItemProperty()
                .addListener( ( v, oldValue, newValue ) -> System.out.println( newValue ) );

        HBox hBox = new HBox();
        hBox.setSpacing( 10 );
        hBox.setPadding( new Insets( 10, 10, 10, 10 ) );
        hBox.getChildren().addAll( choiceBox );


        //make table
        table = new TableView<>();
        table.setItems( items ); //the data to use for the table which is from our list
        table.getColumns().addAll( nameColumn, priceColumn );

        // to filter
        //checkForType( meat, filteredList );

        choiceBox.getSelectionModel().selectedItemProperty().addListener( ( observable, oldValue, newValue ) -> {
            filteredList.setPredicate( item -> checkForType( choiceBox, item ) );
        } );


        SortedList<Item> sortedList = new SortedList<>( filteredList );
        sortedList.comparatorProperty().bind( table.comparatorProperty() );
        table.setItems( sortedList );

        vBox.getChildren().addAll( table, hBox );

        Scene scene = new Scene( vBox, 400, 400 );
        window.setScene( scene );
        window.showAndWait();
    }

    private void setupChoiceBox( final String text, final ChoiceBox<String> choiceBox  )
    {
        //getitems gets items from list
        if( !text.equalsIgnoreCase("desserts") || !text.equalsIgnoreCase("drinks") )
        {
            choiceBox.getItems().add("All");
            choiceBox.getItems().add("Fish");
            choiceBox.getItems().addAll("Meat");
            choiceBox.getItems().addAll("Other");
            choiceBox.setValue("All"); //setDefault
        }
    }

    private ObservableList<Item> sortItemCategory(String buttonName )
    {
        final ObservableList<Item> items = FXCollections.observableArrayList();

        if( buttonName.equalsIgnoreCase( "starters" ) )
        {
            items.addAll(ItemDAOController.getAllItems().stream().filter(i -> i.getItemCategory() == Item.ItemCategory.STARTERS).collect(Collectors.toList()));
        }
        else if( buttonName.equalsIgnoreCase( "mains" ) )
        {
            items.addAll(ItemDAOController.getAllItems().stream().filter(i -> i.getItemCategory() == Item.ItemCategory.MAINS).collect(Collectors.toList()));
        }
        else if( buttonName.equalsIgnoreCase( "desserts" ) )
        {
            items.addAll(ItemDAOController.getAllItems().stream().filter(i -> i.getItemCategory() == Item.ItemCategory.DESSERTS).collect(Collectors.toList()));
        }
        else if( buttonName.equalsIgnoreCase( "kids" ) )
        {
            items.addAll(ItemDAOController.getAllItems().stream().filter(i -> i.getItemCategory() == Item.ItemCategory.KIDS).collect(Collectors.toList()));
        }
        else if( buttonName.equalsIgnoreCase( "drinks" ) )
        {
            items.addAll(ItemDAOController.getAllItems().stream().filter(i -> i.getItemCategory() == Item.ItemCategory.DRINKS).collect(Collectors.toList()));
        }

        return items;
    }


    private boolean checkForType( ChoiceBox<String> choiceBox, Item item )
    {
        if( item.getType() == Item.Type.MEAT && choiceBox.getValue().equalsIgnoreCase( String.valueOf( Item.Type.MEAT ) ) )
        {
            return true;
        }
        else if( item.getType() == Item.Type.FISH && choiceBox.getValue().equalsIgnoreCase( String.valueOf( Item.Type.FISH ) ) )
        {
            return true;
        }
        else if( item.getType() == Item.Type.OTHER && choiceBox.getValue().equalsIgnoreCase( String.valueOf( Item.Type.OTHER ) ) )
        {
            return true;
        }
        else if( choiceBox.getValue().equalsIgnoreCase( "all" ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}