package todolist;

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
	
	public void save(Task t)
	{
		tRep.save(t);
	}
}
