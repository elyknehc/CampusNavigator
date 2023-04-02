import javax.swing.*;
import java.util.*;

public class Layers extends JLabel {
    private ArrayList<POI> poiList;

    public Layers() {
        poiList = new ArrayList<POI>();
        setLocation(0,0);
        setVisible(true);
    }

    public void addPOItoMap(MapPOI newPOI) {
        add(newPOI);
    }

    public void deletePOI(POI oldPOI) {
        poiList.remove(oldPOI);
    }

    public ArrayList<POI> getPOIs() {
        return poiList;
    }
}
