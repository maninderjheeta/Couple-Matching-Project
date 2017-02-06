package models;


import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.format.Formats;
import play.data.validation.Constraints;
import io.ebean.*;
import io.ebean.annotation.PrivateOwned;
import io.ebean.Query;
import play.db.ebean.*;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.*;
import java.util.Date;
import java.util.Map;
import java.util.List;
import java.util.HashMap;

import javax.persistence.Version;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.*;

@Entity 
public class Account extends Model {
		
	@Id	
	public Long id;

	@OneToMany(mappedBy = "account", cascade=CascadeType.ALL)
    public List<AccountDetails> accountdetails;  
 	
    public static final Finder<Long, Account> find = new Finder<>(Account.class);
 
    
}

