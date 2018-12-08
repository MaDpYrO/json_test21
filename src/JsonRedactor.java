import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonRedactor extends JFrame {
    private JPanel mainPanel;
    private JButton openButton;
    private JButton saveButton;
    private JEditorPane jsonPole;
    private JButton addButton;
    private JTextField cUsersUser1IdeaProjectsjson_test2fruit;

    public JsonRedactor(){
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setVisible(true);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String soderjimoe = new String (Files.readAllBytes(Paths.get("fruit.json")));
                    jsonPole.setText(soderjimoe);
                } catch (IOException e1) {
                    System.out.println("cancel");
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String izPolia = jsonPole.getText();


                try {
                    String izPolia = jsonPole.getText();
                   Writer writer = new FileWriter("fruit.json", false);
                    writer.write(izPolia);
                    writer.flush();
                } catch (IOException el) {
                    el.printStackTrace();
                }
                //writer.println(jsonPole.getText());
                //jsonPole.getText();
                //writer.close();

            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //String izPolia = jsonPole.getText();



                    JSONObject jo = new JSONObject();
                    jo.put("fruit","pinaple");
                    jo.put("size","Medium");
                    jo.put("color","N/a");
                    jo.put("weight",900);
                    JSONArray ja = new JSONArray();
                    ja.add(jo);
                    jo = new JSONObject();
                jo.put("fruit","Melon");
                jo.put("size","Large");
                jo.put("color","Yellow");
                jo.put("weight",2300);
                ja.add(jo);



                jo = new JSONObject();
                jo.put("fruits",ja);
                jsonPole.setText(jo.toJSONString());

                //writer.println(jsonPole.getText());
                //jsonPole.getText();
                //writer.close();

            }
        });
    }
}
