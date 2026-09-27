import java.io.Serializable;

public class Item implements Serializable {

    private int id;
    private String type;
    private String name;
    private String description;
    private String location;
    private String date;
    private boolean claimed;

    public Item(int id, String type, String name, String description,
                String location, String date) {

        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        this.location = location;
        this.date = date;
        this.claimed = false;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void markClaimed() {
        claimed = true;
    }

    @Override
    public String toString() {

        return "\nID: " + id +
               "\nType: " + type +
               "\nItem: " + name +
               "\nDescription: " + description +
               "\nLocation: " + location +
               "\nDate: " + date +
               "\nStatus: " + (claimed ? "CLAIMED" : "AVAILABLE") +
               "\n-------------------------";
    }
}