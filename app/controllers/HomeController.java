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
 * Manage a database of Accouts
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
     * Handle default path requests, redirect to account list
     */
    public Result index() {
        return GO_HOME;
    }

    /**
     * Display the paginated list of Accounts.
     *
     * @param page Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order Sort order (either asc or desc)
     * @param filter Filter applied on account number
     */
	
    public Result list() {
		List<Account> acc = Account.find.all();
		return ok(
		views.html.list.render(acc)
        );
    }
    
    /**
     * Display the 'edit form' of a existing Accounts.
     *
     * @param id Id of the Account to edit
     */
    public Result edit(Long id) {
		Account acc = Account.find.byId(id);
        return ok(
            views.html.edit.render(acc)
        );
    }
    
	public Result checkbox() {
          String[] postAction = request().body().asFormUrlEncoded().get("action");
          String action = postAction[0];
          if (postAction == null || postAction.length == 0) { 
			return badRequest("Please Select a Valid Action!");
		} else
          {  
  /* Actions With Params  */
        String[] accounts = request().body().asFormUrlEncoded().get("chkItems"); 
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
              } else {
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

	static public String currentSpecificDate() {
           Date now = new Date();  
           SimpleDateFormat date_pattern = new SimpleDateFormat("dd-MM-yyy__HH_mm_ss");
           return date_pattern.format(now);
	}
	
	public Result GenerateReport(String selected, String type) {
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

	public Result GenerateReport2(String selected, String type) {
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
            
