import java.io.*;
import java.util.ArrayList;

public class LostFoundSystem {

    private ArrayList<Item> items;
    private int nextId = 1;

    private final String FILE_NAME = "items.dat";

    public LostFoundSystem() {

        items = loadItems();

        if (!items.isEmpty()) {
            nextId = items.get(items.size() - 1).getId() + 1;
        }
    }

    public void addItem(String type, String name, String description,
                         String location, String date) {

        Item item = new Item(
                nextId,
                type,
                name,
                description,
                location,
                date
        );

        items.add(item);
        nextId++;

        saveItems();

        System.out.println("\nItem added successfully!");
        System.out.println("Item ID: " + item.getId());
    }

    public void displayItems() {

        if (items.isEmpty()) {
            System.out.println("\nNo items found.");
            return;
        }

        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void searchItem(String keyword) {

        boolean found = false;

        for (Item item : items) {

            if (item.getName().toLowerCase().contains(keyword.toLowerCase())
                    || item.getDescription().toLowerCase().contains(keyword.toLowerCase())
                    || item.getLocation().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(item);
                found = true;
            }
        }

        if (!found) {
            System.out.println("\nNo matching items found.");
        }
    }

    public void claimItem(int id) {

        for (Item item : items) {

            if (item.getId() == id) {

                if (item.isClaimed()) {
                    System.out.println("\nThis item is already claimed.");
                } else {
                    item.markClaimed();
                    saveItems();
                    System.out.println("\nItem marked as claimed!");
                }

                return;
            }
        }

        System.out.println("\nItem ID not found.");
    }

    public void removeItem(int id) {

        for (Item item : items) {

            if (item.getId() == id) {

                items.remove(item);
                saveItems();

                System.out.println("\nItem removed successfully!");
                return;
            }
        }

        System.out.println("\nItem ID not found.");
    }

    private void saveItems() {

        try {

            FileOutputStream file =
                    new FileOutputStream(FILE_NAME);

            ObjectOutputStream output =
                    new ObjectOutputStream(file);

            output.writeObject(items);

            output.close();
            file.close();

        } catch (IOException e) {

            System.out.println("Error saving data.");
        }
    }

    @SuppressWarnings("unchecked")
    private ArrayList<Item> loadItems() {

        try {

            FileInputStream file =
                    new FileInputStream(FILE_NAME);

            ObjectInputStream input =
                    new ObjectInputStream(file);

            ArrayList<Item> savedItems =
                    (ArrayList<Item>) input.readObject();

            input.close();
            file.close();

            return savedItems;

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }
}