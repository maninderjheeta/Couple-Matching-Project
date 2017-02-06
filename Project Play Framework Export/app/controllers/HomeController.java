package controllers;

import io.ebean.Ebean;
import io.ebean.Transaction;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import play.Play;
import play.Logger;
import play.db.DB;
import models.*;

import javax.sql.DataSource;
import java.sql.Connection;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.HashMap;
import java.util.Date;  
import java.text.SimpleDateFormat;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Iterator;
import gui.ava.html.link.*;
import gui.ava.html.image.util.*;
import gui.ava.html.image.generator.*;
import org.apache.commons.mail.EmailAttachment;
import play.libs.mailer.Email;
import play.libs.mailer.MailerClient;

import io.ebean.*;

/**
 * Manage a database of computers
 */
@SuppressWarnings("deprecation")
public class HomeController  extends Controller {

    
    private final JasperReport jasperreport;
    
    private FormFactory formFactory;

    @Inject MailerClient mailerClient;

    @Inject
    public HomeController(FormFactory formFactory, JasperReport jasperreport) {
        this.formFactory = formFactory;
		this.jasperreport = jasperreport;
    }

    /**
     * This result directly redirect to application home.
     */
    public Result GO_HOME = Results.redirect(
        routes.HomeController.list()
    );
    
    /**
     * Handle default path requests, redirect to computers list
     */
    public Result index() {
        return GO_HOME;
    }

    /**
     * Display the paginated list of computers.
     *
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on computer names
     */
	 
	 /*
	     public Result list(int page, String sortBy, String order, String filter) {
        return ok(
            views.html.list.render(
                Computer.page(page, 10, sortBy, order, filter),
                sortBy, order, filter
            )
        );
    }
	*/
	
	
    public Result list() {


List<Account> acc = Account.find.all();

		return ok(
		views.html.list.render(acc)

        );
    }
    
    /**
     * Display the 'edit form' of a existing Computer.
     *
     * @param id Id of the computer to edit
     */
    public Result edit(Long id) {
        
Account acc = Account.find.byId(id);


        return ok(
            views.html.edit.render(acc)
        );
    }
    
    /**
     * Handle the 'edit form' submission 
     *
     * @param id Id of the computer to edit
     */
    /*public Result update(Long id) throws PersistenceException {
        Form<Computer> computerForm = formFactory.form(Computer.class).bindFromRequest();
        if(computerForm.hasErrors()) {
            return badRequest(views.html.editForm.render(id, computerForm));
        }

        Transaction txn = Ebean.beginTransaction();
        try {
            Computer savedComputer = Computer.find.byId(id);
            if (savedComputer != null) {
                Computer newComputerData = computerForm.get();
                savedComputer.company = newComputerData.company;
                savedComputer.discontinued = newComputerData.discontinued;
                savedComputer.introduced = newComputerData.introduced;
                savedComputer.name = newComputerData.name;

                savedComputer.update();
                flash("success", "Computer " + computerForm.get().name + " has been updated");
                txn.commit();
            }
        } finally {
            txn.end();
        }

        return GO_HOME;
    }*/
    
    /**
     * Display the 'new computer form'.
     */
    /*public Result create() {
        Form<Computer> computerForm = formFactory.form(Computer.class);
        return ok(
                views.html.createForm.render(computerForm)
        );
    }*/
    
    /**
     * Handle the 'new computer form' submission 
     */
    /*public Result save() {
        Form<Computer> computerForm = formFactory.form(Computer.class).bindFromRequest();
        if(computerForm.hasErrors()) {
            return badRequest(views.html.createForm.render(computerForm));
        }
        computerForm.get().save();
        flash("success", "Computer " + computerForm.get().name + " has been created");
        return GO_HOME;
    }*/
    
    /**
     * Handle computer deletion
     */
	 
	 /*
    public Result delete(Long id) {
        Computer.find.ref(id).delete();
        flash("success", "Computer has been deleted");
        return GO_HOME;
    }

*/







public Result checkbox() 
{



           
          String[] postAction = request().body().asFormUrlEncoded().get("action");

Logger.debug("---->"+postAction);
          
          String action = postAction[0];

          if (postAction == null || postAction.length == 0) 
          {return badRequest("Please Select a Valid Action!");} 
        
          else
          {  

  /* Actions With Params  */
              String[] accounts = request().body().asFormUrlEncoded().get("chkItems"); 
                  
Logger.debug("---->"+accounts);				  
              
              if (
                  accounts != null && ("PDF Report".equals(action) 
                                         || 
                                        "HTML Report".equals(action) 
                                         || 
                                        "XLS Report".equals(action) 
										||
                            		"General Report".equals(action)
                                        )  
                  ) 
              {
                  String ids = ListUtils.mkString(accounts, s -> "" + s, ";");
                  Logger.info("ids Selected are : "+ids);
           
                  switch (action) 
                  {

                       
                       case     "PDF Report"       : return GenerateReport(ids,"pdf");
                       case     "XLS Report"       : return GenerateReport(ids,"xls");
                       case     "HTML Report"      : return GenerateReport(ids,"html");
					   case     "General Report"      : return GenerateReport2(ids,"pdf");
                       default                     : return ok("default switch : Action <<"+action+">> avec Parametres Error>>"); 
                  } 
              }

  /* Actions Without Params  */
              else if (accounts == null && ("General Report".equals(action) || "PDF Report".equals(action) || "HTML Report".equals(action) || "XLS Report".equals(action))  ) 
              {
               return ok("This Action requires at Least one item Selected");     
              } 

            
              else
              {
                  switch (action) 
                  {


                       case     "Add New"             : return GO_HOME;                       
                    default                           : return ok("default switch : Action <<"+action+">> sans Parametres Error>>"); 
                  } 

              }  



          }

}


    
    public static class ListUtils 
    {
        static public <E> String mkString(E[] list, Function<E,String> stringify, String delimiter) {
            int i = 0;
            StringBuilder s = new StringBuilder();
            for (E e : list) {
                if (i != 0) { s.append(delimiter); }
                s.append(stringify.apply(e));
                i++;
            }
            return s.toString();
        }
    }


	static public String currentSpecificDate() 
{
           Date now = new Date();  
           SimpleDateFormat date_pattern = new SimpleDateFormat("dd-MM-yyy__HH_mm_ss");
           return date_pattern.format(now);

}

	
	public Result GenerateReport(String selected, String type) 
{
           String reportfolder     =  "Maninder/";
           String root_report_path =  "C:/temp/reports/"+reportfolder;
           String reportname       =  "ManinderReport";
           String exportpath       =  "C:/temp/exports/" + reportname +"     "+ currentSpecificDate();

           HashMap<String, Object> params = new HashMap<String, Object>();  
           params.put("Play_ReportPath",root_report_path);
           params.put("param_ids", selected);                
           
           jasperreport.GenerateReport(params,reportfolder,reportname,type,exportpath);

           return ok(new java.io.File(exportpath+"."+type));
}


	
	public Result GenerateReport2(String selected, String type) 
{
           String reportfolder     =  "Maninder/";
           String root_report_path =  "C:/temp/reports/"+reportfolder;
           String reportname       =  "General";
           String exportpath       =  "C:/temp/exports/" + reportname +"     "+ currentSpecificDate();

           HashMap<String, Object> params = new HashMap<String, Object>();  
           params.put("Play_ReportPath",root_report_path);
           params.put("param_ids", selected);                
           
           jasperreport.GenerateReport(params,reportfolder,reportname,type,exportpath);

           return ok(new java.io.File(exportpath+"."+type));
}



}
            
