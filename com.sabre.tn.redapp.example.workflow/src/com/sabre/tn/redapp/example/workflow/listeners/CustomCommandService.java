package com.sabre.tn.redapp.example.workflow.listeners;

import java.util.Random;

import org.eclipse.jface.dialogs.Dialog;

import com.sabre.edge.cf.common.service.ContextStatusAdvisor;
import com.sabre.edge.cf.emu.data.EmulatorCommand;
import com.sabre.edge.cf.emu.data.EmulatorResponse;
import com.sabre.edge.cf.emu.data.requests.EmulatorCommandRequest;
import com.sabre.edge.cf.emu.data.responses.EmulatorCommandResponse;
import com.sabre.edge.cf.model.IRequest;
import com.sabre.edge.cf.model.IService;
import com.sabre.edge.cf.model.IServiceContext;
import com.sabre.edge.cf.model.ServiceStatus;
import com.sabre.edge.cf.model.element.ServiceContext;
import com.sabre.edge.platform.core.sso.base.IAgentProfileService;
import com.sabre.edge.platform.core.ui.handlers.OpenViewHandler;
import com.sabre.edge.platform.core.ui.threading.UiThreadInvoker;
import com.sabre.tn.redapp.example.workflow.uiparts.CfServicesHelper;
import com.sabre.tn.redapp.example.workflow.uiparts.CoreServicesHelper;
import com.sabre.tn.redapp.example.workflow.uiparts.OpenThingsHelper;


public class CustomCommandService implements IService {
	
	final String[] quotes = {
			"�All journeys have secret destinations of which the traveler is unaware.� � Martin Buber",
			"�Though we travel the world over to find the beautiful, we must carry it with us or we find it not.� � Ralph Waldo Emerson",
			"�A man of ordinary talent will always be ordinary, whether he travels or not; but a man of superior talent will go to pieces if he remains forever in the same place.� � Wolfgang Amadeus Mozart",
			"�If you�re not living on the edge, you�re taking up too much space.�",
			"�A journey of a thousand miles must begin with a single step.� � Lao Tzu",
			"�A ship is safe in the harbor, but that�s not what ships are built for.� � Gael Attal",
			"�I have found out that there ain�t no surer way to find out whether you like people or hate them than to travel with them.� � Mark Twain",
			"�Once in a while it really hits people that they don�t have to experience the world in the way they have been told to.� � Alan Keightley"
	};

	@Override
	public void process(IServiceContext context) {

		
		Random rGen = new Random();
		int rInt = rGen.nextInt(quotes.length);
		

		
		new UiThreadInvoker<Object>() {
			@Override
			protected Object invoke() {
				//Straight forward ShowView method, just give the viewId from extensions (plugin.xml)...
				OpenViewHandler.showView("com.sabre.tn.redapp.example.workflow.redapp.view");
				return null;
			};
		}.asyncExec();
		
		
		IRequest rq = context.getRequest();
		EmulatorCommandResponse cmdResponse = new EmulatorCommandResponse();
		((ServiceContext) context).setResponse(cmdResponse);


	}

}
