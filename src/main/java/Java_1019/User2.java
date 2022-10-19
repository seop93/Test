package Java_1019;

public class User2 {
    private String id;
    private String name;
    private String password;

    User2(){

    }
    User2(String id,String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
