package javafxapplication4;

/**
 *
 * @author Laki
 */
import javafx.beans.property.SimpleStringProperty;

public class Record {
    private SimpleStringProperty name = new SimpleStringProperty("");
    private SimpleStringProperty phone = new SimpleStringProperty("");

    public Record() {
        this("", "");
    }

    public Record(String name, String phone) {
        setName(name);
        setPhone(phone);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String fName) {
        name.set(fName);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String fName) {
        phone.set(fName);
    }
}


