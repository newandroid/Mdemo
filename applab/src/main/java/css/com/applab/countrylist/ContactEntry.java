package css.com.applab.countrylist;

import java.util.HashMap;
import java.util.Map.Entry;

public class ContactEntry implements Entry<String, HashMap<String, Object>> {
    private String key;
    private HashMap<String, Object> value;

    public ContactEntry(String key, HashMap<String, Object> value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }

    public HashMap<String, Object> getValue() {
        return this.value;
    }

    public HashMap<String, Object> setValue(HashMap<String, Object> object) {
        this.value = object;
        return this.value;
    }

    public String toString() {
        HashMap<String, Object> map = new HashMap();
        map.put(this.key, this.value);
        return map.toString();
    }
}
