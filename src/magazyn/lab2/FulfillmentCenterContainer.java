package magazyn.lab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FulfillmentCenterContainer {
    private Map<String, FulfillmentCenter> magazinesMap;

    public FulfillmentCenterContainer() {
        this.magazinesMap = new HashMap<>();
    }

    public Map<String, FulfillmentCenter> getMagazinesMap() {
        return magazinesMap;
    }

    public void addCenter(String name, double maxCapacity) {
        magazinesMap.put(name, new FulfillmentCenter(name, maxCapacity));
    }

    public List<String> getMagazinesNames() {
        return new ArrayList<>(magazinesMap.keySet());
    }
}
