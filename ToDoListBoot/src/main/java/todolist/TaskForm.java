package todolist;

import java.util.Date;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class TaskForm{
	
	@NotBlank
	private String description;
	
	@NotNull
	private Date expirationDate;
	
	private boolean todo;
	
	private String descriptionError;
	
	private String expirationDateError;
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public Date getExpirationDate()
	{
		return this.expirationDate;
	}
	
	public void setExpirationDate(Date expirationDate)
	{
		this.expirationDate = expirationDate;
	}

	public String getDescriptionError() {
		return descriptionError;
	}

	public void setDescriptionError(String descriptionError) {
		this.descriptionError = descriptionError;
	}

	public String getExpirationDateError() {
		return expirationDateError;
	}

	public void setExpirationDateError(String expirationDateError) {
		this.expirationDateError = expirationDateError;
	}

	public boolean getTodo() {
		return todo;
	}

	public void setTodo(boolean todo) {
		this.todo = todo;
	}

}
