
package todolist;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TaskController {
	
	@Autowired
	TaskService service;
	
    @RequestMapping("/list")
    public String list(Model model) {
    	   	
    	try
    	{
    		model.addAttribute("tasks", service.findAll());
    		
    	}catch(Exception ecc)
    	{
    		model.addAttribute("errorMessage", ecc.getMessage());
    	}
    	
    	return "list";
    }
    
    @RequestMapping("/add")
    public String add(Model model){
    	
    	model.addAttribute("formData", new TaskForm());
    	
    	return "add";
    }
    
    @RequestMapping(value = "/add", method=RequestMethod.POST)
    public String addPost(@ModelAttribute TaskForm formData, BindingResult result, Model model){
    	
    	if(result.hasErrors())
    	{
    		FieldError descError = result.getFieldError("description");
    		FieldError expDateError = result.getFieldError("expirationDate");
    		if(descError != null)
    			formData.setDescriptionError(
    					descError.getDefaultMessage());
    		if(expDateError != null)
    			formData.setExpirationDateError(
    				expDateError.getDefaultMessage());
    		
    		model.addAttribute("formData",formData);
    		
    		return "add";
    	}	
    	else
    	{
	    	try{
	    		Date d = formData.getExpirationDate();
	    	Task t = new Task(formData.getDescription(),
	    			new Timestamp(d.getTime())
	    	, true);
	    	
	    	service.save(t);
	    	}catch(Exception ecc){
	    		formData.setDescriptionError(ecc.getMessage()); 
	    		model.addAttribute("formData",formData);
	    		
	    		return "add";
	    	}
    	}

    	return "redirect:list";
    }
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        CustomDateEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
        binder.registerCustomEditor(Date.class, editor);
    }
  //@RequestParam(value="name", required=false, defaultValue="World")
}