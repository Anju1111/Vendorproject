package com.ust.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.LoginDao;
import com.ust.dao.VendorPersonDao;
import com.ust.model.Login;



@RestController
public class FrontController {

	@Autowired
	LoginDao log;
	
	@Autowired
	VendorPersonDao vendor;

/************************************* Login Part *********************************************************/

// Authorisation

	@RequestMapping(value = "/api/login/{userName}/{password}", method = RequestMethod.GET)
	public Login getUserDetails(@PathVariable("userName") String userName,
			@PathVariable("password") String password) 
	{
		return log.LoginAuth(userName, password);
	}
	
	
/************************************ Vendor Part*********************************************************************/

	
//View details of vendor

	@RequestMapping(value="/api/vendor/vendordetails",method=RequestMethod.GET)
	public List vendorDetails()
	{
	List list=vendor.vendorList();
	return list;
	}

//Search method

	@RequestMapping(value="/api/vendor/{searchString}",method=RequestMethod.GET)
	public List viewsearch(@PathVariable("searchString") String searchString)
	{
	List list=vendor.searchVendor(searchString);
	return list;
	}

//Add or update details of vendor
	
	@RequestMapping(value="/api/vendor/insert",method={RequestMethod.POST,RequestMethod.PUT})
	public void insertProduct(@RequestBody VendorPerson obj_vendorPerson)
	{
	if(obj_vendorPerson.getVendorId()==0)
	{
	vendor.insertVendor(obj_vendorPerson);
	}
	else
	{
	vendor.updateVendor(obj_vendorPerson);
	}

	}
	
//Sort by vendorId
	
		@RequestMapping(value="/api/vendor/vendordetails/sortbyvendorid",method=RequestMethod.GET)
		public List sortById()
		{
		List list=vendor.sortByVendorId();
		return list;
		}

//Disabling vendor
	
	@RequestMapping(value = "/api/vendor/disablevendor/{vendorId}", method = RequestMethod.PUT)
	public void staffDisable(@PathVariable("vendorId") int vendorId) 
	{
	vendor.disableVendor(vendorId);
	}



//Sort by vendorName
	
	@RequestMapping(value="/api/vendor/vendordetails/sortbyname",method=RequestMethod.GET)
	public List sortByName()
	{
	List list=vendor.sortByVendorName();
	return list;
	}


	}




