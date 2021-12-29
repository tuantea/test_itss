package controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.ConnectionUtil;

public class SignupController implements Initializable {
	    @FXML
	    private Label lblErrors;

	    @FXML
	    private TextField txtUsername;

	    @FXML
	    private TextField txtPassword;
        
	    
	    @FXML 
	    private Button Signup;
	    Connection con = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	public void handleButtonAction(MouseEvent event) {

	        if (event.getSource() == Signup) {
	            //login here
	            if (Signup().equals("Success")) {
	                try {

	                    //add you loading or delays - ;-)
	                    Node node = (Node) event.getSource();
	                    Stage stage = (Stage) node.getScene().getWindow();
	                    //stage.setMaximized(true);
	                    stage.close();
	                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Login.fxml")));
	                    stage.setScene(scene);
	                    stage.show();

	                } catch (IOException ex) {
	                    System.err.println(ex.getMessage());
	                }

	            }
	        }
	       
	    }
	    @Override
	public void initialize(URL location, ResourceBundle resources) {
		if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }
	}
    public SignupController() {
        con = ConnectionUtil.conDB();
    }

    //we gonna use string to check for status
    private String Signup() {
        String status = "Success";
        String email = txtUsername.getText();
        String password = txtPassword.getText();
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error";
        } else {
            //query
            String sql = "INSERT INTO Users(name,password)" + "VALUES(?,?)";
            try {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
//                if (!resultSet.next()) {
//                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
//                    status = "Error";
//                } else {
//                    setLblError(Color.GREEN, "Signup Successful..Redirecting..");
//                }
            } catch (SQLException ex) {
                System.out.println("HIHI");
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        
        return status;
    }
    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }
}

