package org.nandish.examples.MessengerOne.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.nandish.examples.MessengerOne.Model.Model;
import org.nandish.examples.MessengerOne.service.Service;


@Path("/message")
public class Resource 
{
	Service s = new Service();
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Model> test(@PathParam("messageId")int messageId)
	{
		return s.getMessage(messageId);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Model addMessage(Model message)
	{
		return s.sendMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void delMsg(@PathParam("messageId")int id)
	{
		s.deleteMessage(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Model> allMsg()
	{
		return s.getAllMessages();
	}

}
