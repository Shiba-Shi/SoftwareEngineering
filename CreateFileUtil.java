package SoftwareEngineering;

import org.json.JSONObject;
 
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
 
public class CreateFileUtil {
    public CreateFileUtil(String filename, String text) {
        String path = filename + ".json";

        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        JSONObject json = new JSONObject();
        json.put("Name", "sean");
        CreateFileUtil test = new CreateFileUtil("testing", json.toString());
    }
}