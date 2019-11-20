package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.model.VendorPerson;

public class VendorPersonDao {
	//connection establishment with the database
	
		JdbcTemplate template;
		public void setTemplate(JdbcTemplate template)
		{
			this.template=template;
		}


	// Insert vendor
		
		public int insertVendor(VendorPerson bean)
		{
		String sql = "insert into ust_VendorTable(vendorName,vendorAddress,location,service,pincode,isActive) values(?,?,?,?,?,'yes')";
		
		template.update(sql, new Object[] { bean.getVendorName(), bean.getVendorAddress(),
		bean.getLocation(), bean.getService(), bean.getPincode() });

		String sql1 = "select max(vendorId) from ust_VendorTable";
		
		int vendorId = template.queryForObject(sql1, Integer.class);
		
		String sql2 = "insert into ust_PersonTable(vendorId,contactName,department,email,phone) values(?,?,?,?,?)";
		return template.update(
		sql2,
		new Object[] { vendorId, bean.getContactName(),bean.getDepartment(),
		bean.getEmail(),bean.getPhone() });

		}

	//View vendor details
		
		
		public List<VendorPerson> vendorList() {
		return template.query("select vendorId,vendorName,vendorAddress,location,service,pincode,isActive,contactId,contactName,department,email,phone from ust_VendorTable join ust_PersonTable using(vendorId) where isActive!='0'",new RowMapper<VendorPerson>() {

		@Override
		public VendorPerson mapRow(ResultSet rs, int row)throws SQLException
		{

		VendorPerson obj_vendorperson = new VendorPerson();
		obj_vendorperson.setVendorId(rs.getInt(1));
		obj_vendorperson.setVendorName(rs.getString(2));
		obj_vendorperson.setVendorAddress(rs.getString(3));
		obj_vendorperson.setLocation(rs.getString(4));
		obj_vendorperson.setService(rs.getString(5));
		obj_vendorperson.setPincode(rs.getInt(6));
		obj_vendorperson.setIsActive(rs.getString(7));
		obj_vendorperson.setContactId(rs.getInt(8));
		obj_vendorperson.setContactName(rs.getString(9));
		obj_vendorperson.setDepartment(rs.getString(10));
		obj_vendorperson.setEmail(rs.getString(11));
		obj_vendorperson.setPhone(rs.getString(12));
		return obj_vendorperson;
		}
		});

		}

	//Edit vendor details
		
		public int updateVendor(VendorPerson bean)
		{
		String sql="update ust_VendorTable set vendorName=?,vendorAddress=?,location=?,service=?,pincode=?,isActive=? where vendorId=?";
		template.update(sql,new Object[] {bean.getVendorName(),bean.getVendorAddress(),bean.getLocation(),bean.getService(),bean.getPincode(),bean.getIsActive(),bean.getVendorId()});
		
		String sql1="update ust_PersonTable set contactName=?,department=?,email=?,phone=? where contactId=?";
		return template.update(sql1, new Object[] {bean.getContactName(),bean.getDepartment(),bean.getEmail(),bean.getPhone(),bean.getContactId()});
		}


	//Disable vendor
		
		public int disableVendor(int vendorId) {
		  String sql = "update ust_VendorTable set isActive = '0'  where vendorId = '" + vendorId + "'";
		  return template.update(sql);
		  }

	//Search
		
		public List<VendorPerson> searchVendor(String searchString) {
		return template.query("select vendorId,vendorName,vendorAddress,location,service,pincode,isActive,contactId,contactName,department,email,phone from ust_VendorTable join ust_PersonTable using(vendorId) where location like'"
		+ searchString + "%' or vendorName like'" + searchString + "%' or service like'" + searchString + "%'"  ,new RowMapper<VendorPerson>() {

		@Override
		public VendorPerson mapRow(ResultSet rs, int row)throws SQLException {
		VendorPerson obj_vendorPerson = new VendorPerson();
		obj_vendorPerson.setVendorId(rs.getInt(1));
		obj_vendorPerson.setVendorName(rs.getString(2));
		obj_vendorPerson.setVendorAddress(rs.getString(3));
		obj_vendorPerson.setLocation(rs.getString(4));
		obj_vendorPerson.setService(rs.getString(5));
		obj_vendorPerson.setPincode(rs.getInt(6));
		obj_vendorPerson.setIsActive(rs.getString(7));
		obj_vendorPerson.setContactId(rs.getInt(8));
		obj_vendorPerson.setContactName(rs.getString(9));
		obj_vendorPerson.setDepartment(rs.getString(10));
		obj_vendorPerson.setEmail(rs.getString(11));
		obj_vendorPerson.setPhone(rs.getString(12));
		return obj_vendorPerson;
		}

		});
		}

	//Sort by vendorId
		
		public List<VendorPerson> sortByVendorId()
		{
		return template.query("select vendorId,vendorName,vendorAddress,location,service,pincode,isActive,contactId,contactName,department,email,phone from ust_VendorTable join ust_PersonTable using(vendorId) order by vendorId",
		new RowMapper<VendorPerson>() 
		{

		@Override
		public VendorPerson mapRow(ResultSet rs, int row)
		throws SQLException {
		// TODO Auto-generated method stub

		VendorPerson obj_vendorPerson = new VendorPerson();
		obj_vendorPerson.setVendorId(rs.getInt(1));
		obj_vendorPerson.setVendorName(rs.getString(2));
		obj_vendorPerson.setVendorAddress(rs.getString(3));
		obj_vendorPerson.setLocation(rs.getString(4));
		obj_vendorPerson.setService(rs.getString(5));
		obj_vendorPerson.setPincode(rs.getInt(6));
		obj_vendorPerson.setIsActive(rs.getString(7));
		obj_vendorPerson.setContactId(rs.getInt(8));
		obj_vendorPerson.setContactName(rs.getString(9));
		obj_vendorPerson.setDepartment(rs.getString(10));
		obj_vendorPerson.setEmail(rs.getString(11));
		obj_vendorPerson.setPhone(rs.getString(12));
		return obj_vendorPerson;
		}
		});

		}

	//Sort by vendorName
		
		public List<VendorPerson> sortByVendorName() {
		return template.query("select vendorId,vendorName,vendorAddress,location,service,pincode,isActive,contactId,contactName,department,email,phone from UST_VendorTable join UST_PersonTable using(vendorId) order by vendorName",new RowMapper<VendorPerson>() {

		@Override
		public VendorPerson mapRow(ResultSet rs, int row)
		throws SQLException {
		// TODO Auto-generated method stub

		VendorPerson obj_vendorPerson= new VendorPerson();
		obj_vendorPerson.setVendorId(rs.getInt(1));
		obj_vendorPerson.setVendorName(rs.getString(2));
		obj_vendorPerson.setVendorAddress(rs.getString(3));
		obj_vendorPerson.setLocation(rs.getString(4));
		obj_vendorPerson.setService(rs.getString(5));
		obj_vendorPerson.setPincode(rs.getInt(6));
		obj_vendorPerson.setIsActive(rs.getString(7));
		obj_vendorPerson.setContactId(rs.getInt(8));
		obj_vendorPerson.setContactName(rs.getString(9));
		obj_vendorPerson.setDepartment(rs.getString(10));
		obj_vendorPerson.setEmail(rs.getString(11));
		obj_vendorPerson.setPhone(rs.getString(12));
		return obj_vendorPerson;
		}
		});

		}

		






}
