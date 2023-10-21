/**
 *
 * @author neville
 */
package electricity_bill;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Electricity_bill_generator extends Application {

    private TextField txtElectricityUnit = new TextField();
    private TextField txtPricePerUnit = new TextField();
    private Label lblOutput = new Label();

    private Button btnGenerateBill = new Button("Calculate bill");

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create UI
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("ELECTRICITY UNITS"), 0, 0);
        gridPane.add(txtElectricityUnit, 1, 0);

        gridPane.add(new Label("PRICE PER UNIT"), 0, 1);
        gridPane.add(txtPricePerUnit, 1, 1);

        gridPane.add(new Label("TOTAL BILL"), 0, 2);
        gridPane.add(lblOutput, 1, 2);

        gridPane.add(btnGenerateBill, 1, 3);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        txtElectricityUnit.setAlignment(Pos.BOTTOM_RIGHT);
        txtElectricityUnit.setAlignment(Pos.BOTTOM_RIGHT); 
        lblOutput.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane.setHalignment(btnGenerateBill, HPos.RIGHT);

        // Process events
        btnGenerateBill.setOnAction(new javafx.event.EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent t) {
                generateBill();
            }
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 500, 300);
        primaryStage.setTitle("ELECTRICITY BILL CALCULATOR"); // Set title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private void generateBill() {
        if(txtElectricityUnit.getText().isEmpty()){
            txtElectricityUnit.requestFocus();  
        }
        if(txtPricePerUnit.getText().isEmpty()){
           txtElectricityUnit.requestFocus();  
        }
        // Get values from text fields
        try{
        double electricity_units = Double.parseDouble(txtElectricityUnit.getText());
        double price_per_unit = Double.parseDouble(txtPricePerUnit.getText());
        double total = electricity_units * price_per_unit;
        // Display monthly payment and total payment
        lblOutput.setText(String.format("R%.2f", total));
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "ERROR!!\n ONLY NUMBERS ALLOWED "+" \n THE ERROR IS "+e.getMessage().toString() );
            
        }
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
