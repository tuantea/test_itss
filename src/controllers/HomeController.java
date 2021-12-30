package controllers;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
import java.io.IOException;
import java.net.URL;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ResourceBundle;
	import javafx.beans.property.SimpleStringProperty;
	import javafx.beans.value.ObservableValue;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.DatePicker;
	import javafx.scene.control.Label;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableColumn.CellDataFeatures;
	import javafx.scene.control.TableView;
	import javafx.scene.control.TextField;
	import javafx.scene.input.MouseEvent;
	import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
	import utils.ConnectionUtil;

	/**
	 * FXML Controller class
	 *
	 * @author oXCToo
	 */
	public class HomeController implements Initializable {

	    @FXML
	    private Label welcome;
	    @FXML
	    private Button Parking;
	    @FXML
	    private Button Bike;
	    @FXML
	    private Button Logout;
	    @FXML
	    private Button Pay;

	    PreparedStatement preparedStatement;
	    Connection connection;

	    public HomeController() {
	        connection = (Connection) ConnectionUtil.conDB();
	    }

	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	      
	    }
	    public void setUserInformation(String username) {
	    	welcome.setText("Welcome"+username+"!");
	    } 
	

	    @FXML
	    private void HandleEvents(MouseEvent event) {
	       if(event.getSource() == Parking)
	       { try {

               //add you loading or delays - ;-)
               Node node = (Node) event.getSource();
               Stage stage = (Stage) node.getScene().getWindow();
               //stage.setMaximized(true);
               stage.close();
               Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Parking.fxml")));
               stage.setScene(scene);
               stage.show();

           } catch (IOException ex) {
               System.err.println(ex.getMessage());
           }}
	       else if(event.getSource() == Bike) { try {

               //add you loading or delays - ;-)
               Node node = (Node) event.getSource();
               Stage stage = (Stage) node.getScene().getWindow();
               //stage.setMaximized(true);
               stage.close();
               Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/Bike.fxml")));
               stage.setScene(scene);
               stage.show();

           } catch (IOException ex) {
               System.err.println(ex.getMessage());
           }}
	       else if(event.getSource() == Pay) {
	    	   try {

	               //add you loading or delays - ;-)
	               Node node = (Node) event.getSource();
	               Stage stage = (Stage) node.getScene().getWindow();
	               //stage.setMaximized(true);
	               stage.close();
	               Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/fxml/User.fxml")));
	               stage.setScene(scene);
	               stage.show();

	           } catch (IOException ex) {
	               System.err.println(ex.getMessage());
	           }
	       }
	       else if(event.getSource()==Logout) {
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
//	    private void clearFields() {
//	        txtFirstname.clear();
//	        txtLastname.clear();
//	        txtEmail.clear();
//	    }

//	    private String saveData() {
//
//	        try {
//	            String st = "INSERT INTO wip_users ( firstname, lastname, email, gender, dob) VALUES (?,?,?,?,?)";
//	            preparedStatement = (PreparedStatement) connection.prepareStatement(st);
//	            preparedStatement.setString(1, txtFirstname.getText());
//	            preparedStatement.setString(2, txtLastname.getText());
//	            preparedStatement.setString(3, txtEmail.getText());
//	            preparedStatement.setString(4, txtGender.getValue().toString());
//	            preparedStatement.setString(5, txtDOB.getValue().toString());
//
//	            preparedStatement.executeUpdate();
//	            lblStatus.setTextFill(Color.GREEN);
//	            lblStatus.setText("Added Successfully");
//
//	            fetRowList();
//	            //clear fields
//	            clearFields();
//	            return "Success";
//
//	        } catch (SQLException ex) {
//	            System.out.println(ex.getMessage());
//	            lblStatus.setTextFill(Color.TOMATO);
//	            lblStatus.setText(ex.getMessage());
//	            return "Exception";
//	        }
//	    }
//
//	    private ObservableList<ObservableList> data;
//	    String SQL = "SELECT * from wip_users";
//
//	    //only fetch columns
//	    private void fetColumnList() {
//
//	        try {
//	            ResultSet rs = connection.createStatement().executeQuery(SQL);
//
//	            //SQL FOR SELECTING ALL OF CUSTOMER
//	            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//	                //We are using non property style for making dynamic table
//	                final int j = i;
//	                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1).toUpperCase());
//	                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//	                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
//	                        return new SimpleStringProperty(param.getValue().get(j).toString());
//	                    }
//	                });
//
//	                tblData.getColumns().removeAll(col);
//	                tblData.getColumns().addAll(col);
//
//	                System.out.println("Column [" + i + "] ");
//
//	            }
//
//	        } catch (Exception e) {
//	            System.out.println("Error " + e.getMessage());
//
//	        }
//	    }
//
//	    //fetches rows and data from the list
//	    private void fetRowList() {
//	        data = FXCollections.observableArrayList();
//	        ResultSet rs;
//	        try {
//	            rs = connection.createStatement().executeQuery(SQL);
//
//	            while (rs.next()) {
//	                //Iterate Row
//	                ObservableList row = FXCollections.observableArrayList();
//	                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//	                    //Iterate Column
//	                    row.add(rs.getString(i));
//	                }
//	                System.out.println("Row [1] added " + row);
//	                data.add(row);
//
//	            }
//
//	            tblData.setItems(data);
//	        } catch (SQLException ex) {
//	            System.err.println(ex.getMessage());
//	        }
//	    }
//
//	}
