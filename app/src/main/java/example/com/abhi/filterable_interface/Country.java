package example.com.abhi.filterable_interface;

/**
 * Created by abhimanyu on 22/8/17.
 */

public class Country {

    String name;
    String iso_code;
    int flag;

    Country(String name, String iso_code, int flag) {
        this.name = name;
        this.iso_code = iso_code;
        this.flag = flag;
    }

    public String getIso_code() {
        return iso_code;
    }

    public void setIso_code(String iso_code) {
        this.iso_code = iso_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
