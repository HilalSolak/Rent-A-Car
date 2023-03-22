package kodlama.io.rentacar.entities.concretes;

public class Brand {
    //Lombok
    private int id;
    private String Name;

    public Brand() {
    }

    public Brand(int id, String name) {
        this.id = id;
        Name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
