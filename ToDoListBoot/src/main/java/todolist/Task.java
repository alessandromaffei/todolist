package todolist;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tasks")
public class Task {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name= "taskid")
	private long id;
	
	@Column(name= "description")
	private String description;
	
	@Column(name = "expiration_date")
	private Timestamp expirationDate;
	
	@Column(name= "to_do")
	private boolean toDo;

	
	protected Task() {}
	
	public Task(String description, Timestamp expirationDate, boolean toDo) {
		this.description = description;
		this.expirationDate = expirationDate;
		this.toDo = toDo;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public Timestamp getExpirationDate(){
		return this.expirationDate;
	}
	
	public void setExpirationDate(Timestamp expirationDate){
		this.expirationDate = expirationDate;
	}
	
	public boolean getToDo(){
		return this.toDo;
	}
	
	public void setToDo(boolean toDo){
		this.toDo = toDo;
	}
}
