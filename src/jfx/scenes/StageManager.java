package jfx.scenes;

import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class StageManager {
    /**
     * @Description this class makes sure that there is only one stageManager instance throughout your application.
     * @usage whenever you create a new stage make sure to add it to the stageManager instance then you can stageMap list as you like
     * @example StageManager instance = StageManager.getInstance();
            instance.addStage("login", createdStage);
     */

    private static StageManager instance;
    private Map<String, Stage> stageMap;

    private StageManager() {
        stageMap = new HashMap<>();
    }

    public static StageManager getInstance() {
        if (instance == null) {
            instance = new StageManager();
        }
        return instance;
    }

    public void addStage(String name, Stage stage) {
        stageMap.put(name, stage);
    }

    public Stage getStage(String name) {
        return stageMap.get(name);
    }

    public void removeStage(String name) {
        stageMap.remove(name);
    }

    public void printStages() {
        for (Map.Entry<String, Stage> entry : stageMap.entrySet()) {
            String name = entry.getKey();
            Stage stage = entry.getValue();
            System.out.println("Name: " + name + ", Stage: " + stage);
        }
    }
    public HashMap<String, Stage> filterStage(Stage stage) {
        HashMap<String, Stage> filteredMap = new HashMap<>();
        for (Map.Entry<String, Stage> entry : stageMap.entrySet()) {
            Stage listedStage = entry.getValue();
            String correspondentKey = entry.getKey();
            if (listedStage != stage) {
                filteredMap.put(correspondentKey,stage);
            }
        }
        return filteredMap;
    }
    public void renderStage(String currenStage, String stageToBeRendered){
        instance.getStage(stageToBeRendered).show();
        instance.getStage(currenStage).close();
    }
}
