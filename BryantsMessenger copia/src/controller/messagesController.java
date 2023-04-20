package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.ConectaSql;
import model.Message;
import model.Person;

public class messagesController implements Initializable {

	@FXML
	private Button bBack;

	@FXML
	private ListView<Message> message;

	@FXML
	private Button send;

	@FXML
	private TextField tusMessages;

	@FXML
	private Label userName;
	Person person;
	Person person2;
	ConectaSql sql;
	Calendar date;
	
	
	
	
	@FXML
	void bController(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/logInFinal.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		Stage myStage = (Stage) this.bBack.getScene().getWindow();
		myStage.close();
	}

	@FXML
	void sendController(ActionEvent event) {
		
		String t = tusMessages.getText();
		
		Message m= new Message(this.person.getId(),person2.getId(), t);
		Boolean add= sql.addMessage(m);
		if(add) {
			System.out.println("Añadido");
		}else
			System.out.println("Error");
		
	}


	public void setPerson(Person person) {
		// TODO Auto-generated method stub
		this.person = person;
	}

	public void setPerson2(Person person2) {
		// TODO Auto-generated method stub
		this.person2 = person2;
	}

	public void setMessage() {
		System.out.println(this.person.getEmail()+" "+ person2.getEmail());
		ArrayList<Message> messages = sql.getMessages(this.person.getEmail(),person2.getEmail());
		for (int i = 0; i < messages.size(); i++) {
			message.getItems().add(messages.get(i));
		}
	}
	public void setuserName() {
		userName.setText(person2.getName());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			sql = new ConectaSql();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * ArrayList<Message> messages = sql.getMessages(person2.getEmail()); for(int
		 * i=0;i<messages.size();i++) { message.getItems().add(messages.get(i)); }
		 */
	}

}