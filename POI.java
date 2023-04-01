public class POI {
    private String name, description, category;
    private int ID;
    private boolean favourite;

    public static void main(String[] args) {
        POI info = new POI("null", "null", "null",5);
       
    }

    public POI(String name, String description, String category, int ID) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "POI Info:\n name: " + name + "\n" + " description: " + description + "\n" + " category: " + category
                + "\n" + " favourite: " + favourite + "\n" + " id: " + ID;
    }
    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean getFavourite() {
        return this.favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

}
