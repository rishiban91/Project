package com.farmfinder.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

public class PaymentService {
	@POST
	@Path("/createFarm")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPayment(String data){
		/* We are getting application context and repo here*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		PaymentRepo repo = (PaymentRepo) ctx.getBean(PaymentRepo.class) ;
		/* here we convert Payment class to match JSON*/
		ObjectMapper map = new ObjectMapper();
		try{ 
			Payment p = map.readValue(data, Payment.class) ;
		}catch (Exception e){
			e.printStackTrace();
		}
		
		/*Create new payment class*/ 
		Payment pay = new Payment() ;
		pay.setName("Buy your products") ;		
		repo.save(pay) ;
		return Response.status(201).entity(pay).build() ;
	}
	public Response getAllPayment() {
		/* We are getting application context and repo here*/
		ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
		PaymentRepo repo = (PaymentRepo) ctx.getBean(PaymentRepo.class) ;
		List<Payment> getpay = repo.findAll();
		return Response.status(201).entity(getpay).build();
		}
	}
	
	
	
	
	
	


