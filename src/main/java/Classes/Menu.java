package Classes;

import DAO.ItemDAOController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anil on 10/06/2016.
 */
public class Menu {
    private List<Item> items;

    public void mainMenu()
    {
        items = new ArrayList<>();
        items = getAllItems();

        for (Item item : items)
        {

        }
    }

    private List<Item> getAllItems()
    {
        return ItemDAOController.getAllItems();
    }
}
