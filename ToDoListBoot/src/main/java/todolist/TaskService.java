package todolist;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class TaskService {
	
	public TaskService() {}
	
	@Autowired
	TaskRepository tRep;
	
	public Iterable<Task> findAll()
	{
		return tRep.findAll(new Sort(Sort.Direction.DESC,"expirationDate"));
	}
	
	public Iterable<Task> findTodo()
	{
		List<Task> tasks = new ArrayList<Task>();
		for(Task t : tRep.findByToDoOrderByExpirationDateDesc(true))
		{
			if(t.getExpirationDate().getTime() >= Calendar.getInstance().getTimeInMillis())
				tasks.add(t);
		}
		return tasks;
	}
	
	public Iterable<Task> findExpired()
	{
		List<Task> tasks = new ArrayList<Task>();
		for(Task t : findAll())
		{
			if(t.getExpirationDate().getTime() < Calendar.getInstance().getTimeInMillis())
				tasks.add(t);
		}
		
		return tasks;
	}
	
	public Task findOne(long id)
	{
		return tRep.findOne(id);
	}
	
	public void save(Task t)
	{
		tRep.save(t);
	}
	
	public void delete(long id)
	{
		tRep.delete(id);
	}
}
