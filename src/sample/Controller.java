package sample;

import javafx.fxml.FXML;

import java.awt.*;
import java.awt.font.ShapeGraphicAttribute;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import javafx.stage.Stage;

public class Controller {
    @FXML
    private AnchorPane stage1;
    @FXML
    private TextField t;
    @FXML
    private AnchorPane anchor_detail;
    @FXML
    private Label label;
    @FXML
    private Label cgpaMeter;
    @FXML
    private Button refresh;


    public Button submit = new Button("Submit");


    public void exitbutton() {
        System.exit(0);
    }

    public void currentCGPA() {
        anchor_detail.getChildren().clear();

        final int[] y = {0};
        TextField t = new TextField();
        t.setPromptText("Enter the no. of course");
        Button b = new Button("Enter");

        /*VBox v = new VBox(10);

        ListView l = new ListView();


       v.getChildren().addAll(t, b, l);
        v.setAlignment(Pos.TOP_CENTER);*/
        ;

        Label[] labelArray = new Label[100];
        TextField[] textFieldArray = new TextField[100];
        TextField[] textFieldArray2 = new TextField[100];

        VBox vb = new VBox(t, b);
        vb.setAlignment(Pos.CENTER);
        HBox[] hb = new HBox[100];


        b.setOnAction(event -> {

            label.setVisible(false);
            String x = t.getText();
            System.out.println(x);
            y[0] = Integer.parseInt(x);

            if (y[0] > 10) {

                label.setVisible(true);
                return;

            }

            for (int j = 0; j < y[0]; j++) {
                int flag = j + 1;
                hb[j] = new HBox(50);

                // buttonArray[j] = new Button("Course : "+flag);
                labelArray[0] = new Label("Course : " + flag);
                labelArray[0].setFont(Font.font(20));
                labelArray[0].setTextFill(new Color(0.9804, 0.9529, 1, 1));

                textFieldArray[j] = new TextField();
                textFieldArray[j].setPromptText("Enter the GPA");

                textFieldArray2[j] = new TextField();
                textFieldArray2[j].setPromptText("Enter the Credit");


                hb[j].getChildren().addAll(labelArray[0], textFieldArray[j], textFieldArray2[j]);


            }
            for (int i = 0; i < y[0]; i++) {
                vb.getChildren().add(hb[i]);
            }

            submit.setAlignment(Pos.CENTER);
            vb.getChildren().addAll(submit);

            submit.setOnAction(event1 -> {
                String temp;
                double storage = 0.00, gpa, cgpa, credit, totalCredit = 0.00;
                for (int i = 0; i < y[0]; i++) {
                    temp = textFieldArray[i].getText();
                    gpa = Double.parseDouble(temp);
                    temp = textFieldArray2[i].getText();
                    credit = Double.parseDouble(temp);

                    storage += (gpa * credit);
                    totalCredit += credit;

                }

                cgpa = storage / totalCredit;

                Label resultLabel = new Label("Your CGPA is " + cgpa);
                resultLabel.setFont(Font.font(40));
                resultLabel.setTextFill(new Color(0.9804, 0.9529, 1, 1));

                vb.getChildren().add(resultLabel);


            });


        });


        anchor_detail.getChildren().addAll(vb);


    }

    public void setRefresh() {
        anchor_detail.getChildren().clear();
    }

    public void setTotalCGPA() {

        anchor_detail.getChildren().clear();
        Label l1 = new Label("CGPA till Last Semester");
        l1.setFont(Font.font(20));
        l1.setTextFill(new Color(0.9804, 0.9529, 1, 1));

        TextField t1 = new TextField();
        t1.setPromptText("Enter Last CGPA");

        Label l = new Label("Credit Completed ?");
        l.setFont(Font.font(20));
        l.setTextFill(new Color(0.9804, 0.9529, 1, 1));

        TextField t = new TextField();
        t.setPromptText("Credit Completed");

        Label l2 = new Label("Current Semester CGPA");
        l2.setFont(Font.font(20));
        l2.setTextFill(new Color(0.9804, 0.9529, 1, 1));

        TextField t2 = new TextField();
        t2.setPromptText("Current Semester CGPA");

        Label l3 = new Label("Current Semester completed credit");
        l3.setFont(Font.font(20));
        l3.setTextFill(new Color(0.9804, 0.9529, 1, 1));

        TextField t3 = new TextField();
        t3.setPromptText("Current Semester completed credit");

        Button submit = new Button("Submit");


        VBox vBox = new VBox(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(l1, t1, l, t, l2, t2, l3, t3, submit);

        submit.setOnAction(event -> {
            String temp;
            double lastCG, lastCredit, presentCG, presentCredit;
            temp = t1.getText();
            lastCG = Double.parseDouble(temp);
            temp = t.getText();
            lastCredit = Double.parseDouble(temp);
            temp = t2.getText();
            presentCG = Double.parseDouble(temp);
            temp = t3.getText();
            presentCredit = Double.parseDouble(temp);

            double result1 = (lastCG * lastCredit) + (presentCG * presentCredit);
            double result2 = lastCredit + presentCredit;
            double result = result1 / result2;

            Label resultLabel = new Label("Your CGPA is " + result);
            resultLabel.setFont(Font.font(40));
            resultLabel.setTextFill(new Color(0.9804, 0.9529, 1, 1));

            vBox.getChildren().add(resultLabel);
        });

        anchor_detail.getChildren().add(vBox);


    }


}
