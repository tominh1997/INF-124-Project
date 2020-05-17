import java.sql.Blob;

public class Item {
    String id;
    String name;
    String description;
    String price;
    String type;
    Blob image1;
    Blob image2;
    Blob image3;

    public Item(String name, String id){
        this.name = name;
        this.id = id;
    }

    public Item(String name, String id, String price){
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Blob getImage1() {
        return image1;
    }

    public void setImage1(Blob image1) {
        this.image1 = image1;
    }

    public Blob getImage2() {
        return image2;
    }

    public void setImage2(Blob image2) {
        this.image2 = image2;
    }

    public Blob getImage3() {
        return image3;
    }

    public void setImage3(Blob image3) {
        this.image3 = image3;
    }
}
