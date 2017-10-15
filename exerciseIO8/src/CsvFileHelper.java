import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvFileHelper {

    private static final String EMPLOYEFILECSV = "employe.csv";

    public static String getResourcePath(String fileName) {
        final File f = new File("");
        final String dossierPath = f.getAbsolutePath() + File.separator + fileName;
        return dossierPath;
    }

    public static File getResource(String fileName) {
        final String completeFileName = getResourcePath(fileName);
        File file = new File(completeFileName);
        return file;
    }

    public static File getEmployeFileCSV(){
        return getResource(EMPLOYEFILECSV);
    }

    public static List<String> readFile(File file) {

        List<String> result = new ArrayList<String>();

        FileReader fr = null;

        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                result.add(line);
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    //public static void
}