package com.farmfinder.services;

import java.util.List;

import javax.ws.rs.Consumes;
<<<<<<< HEAD
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
=======
import javax.ws.rs.POST;
import javax.ws.rs.Path;
>>>>>>> 11fa7ec3bbaa63df47eab80281ee93659d6ee4b4
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.farmfinder.commands.CategoryRepo;
import com.farmfinder.commands.PaymentRepo;
import com.farmfinder.config.MongoConfig;
import com.farmfinder.model.Category;
import com.farmfinder.model.Payment;
<<<<<<< HEAD
import com.sun.xml.bind.v2.model.core.ID;

public class PaymentService {
	@POST
	@Path("/createPayment")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPayment(String data) {
=======

public class PaymentService {
	@POST
	@Path("/createFarm")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPayment(String data){
>>>>>>> 11fa7ec3bbaa63df47eab80281ee93659d6ee4b4
		/* We are getting application context and repo here*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		PaymentRepo repo = (PaymentRepo) ctx.getBean(PaymentRepo.class) ;
		/* here we convert Payment class to match JSON*/
		ObjectMapper map = new ObjectMapper();
<<<<<<< HEAD
		try { 
			Payment p = map.readValue(data, Payment.class) ;
		}
		catch (Exception e) {
=======
		try{ 
			Payment p = map.readValue(data, Payment.class) ;
		}catch (Exception e){
>>>>>>> 11fa7ec3bbaa63df47eab80281ee93659d6ee4b4
			e.printStackTrace();
		}
		
		/*Create new payment class*/ 
		Payment pay = new Payment() ;
		pay.setName("Buy your products") ;		
		repo.save(pay) ;
		return Response.status(201).entity(pay).build() ;
<<<<<<< HEAD
	  }
	@GET
	@Path("/geAllPayment")
	@Produces(MediaType.APPLICATION_JSON)
=======
	}
>>>>>>> 11fa7ec3bbaa63df47eab80281ee93659d6ee4b4
	public Response getAllPayment() {
		/* We are getting application context and repo here*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		PaymentRepo repo = (PaymentRepo) ctx.getBean(PaymentRepo.class) ;
		List<Payment> getpay = repo.findAll();
		return Response.status(201).entity(getpay).build();
<<<<<<< HEAD
	}
	/*rest service for find all payments*/
	@GET
	@Path("/findID/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findId(@PathParam("id")String id) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		PaymentRepo repo = (PaymentRepo) ctx.getBean(PaymentRepo.class) ;
		repo.findOne(id);
		return Response.status(201).entity(id).build();
	}
	
	/*rest service for delete payment*/
	@DELETE
	@Path("/deletePayment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteid(@PathParam("id")String id) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		PaymentRepo repo = (PaymentRepo) ctx.getBean(PaymentRepo.class) ;
		repo.delete(id);
		return Response.status(200).entity(id).build();
	}
	
}	
=======
		}
	}
	
>>>>>>> 11fa7ec3bbaa63df47eab80281ee93659d6ee4b4
	
	
	
	
	


