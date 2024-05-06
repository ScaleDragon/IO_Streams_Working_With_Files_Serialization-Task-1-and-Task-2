package HomeWork.IO_Streams_Working_With_Files_Serialization.Task_2_Conservation;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class OpenZip {
    public static void openZip(String pathZip, String pathDirectory) {
        try (ZipInputStream saveZip = new ZipInputStream(new FileInputStream(pathZip))) {
            ZipEntry entry;
            String name;
            while ((entry = saveZip.getNextEntry()) != null) {
                name = pathDirectory + "\\" + entry.getName();

                FileOutputStream save = new FileOutputStream(name);

                for (int i = saveZip.read(); i != -1; i = saveZip.read()) {
                    save.write(i);
                }
                save.flush();
                saveZip.closeEntry();
                save.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
