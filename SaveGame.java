package HomeWork.IO_Streams_Working_With_Files_Serialization.Task_2_Conservation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveGame {
    public static void saveGame(String pathSave, GameProgress progress) {
        try (ObjectOutputStream saveProgress = new ObjectOutputStream(new FileOutputStream(pathSave))) {
            saveProgress.writeObject(progress);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
