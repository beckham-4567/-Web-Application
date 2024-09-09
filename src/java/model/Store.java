package model;

public class Store {

    private String name;
    private String Type;
    private String Filter;
    private String Popularity;
    private int price;

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
        public String getType() {
        return Type;
    }


    public void setType(String Type) {
        this.Type = Type;
    }
    
    public String getFilter() {
        return Filter;
    }

    public void setFilter(String Filter) {
        this.Filter = Filter;
    }

    public String getPopularity() {
        return Popularity;
    }
    
    public void setPopularity(String Popularity) {
        this.Popularity = Popularity;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPopularity(int popularity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
