package br.com.webhomebeta.controller;


import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.cpr.BroadcasterFactory;
import org.atmosphere.cpr.HeaderConfig;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AtmoController {
	
private final Logger log = LoggerFactory.getLogger(AtmoController.class);

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ModelAndView show(){
		return new ModelAndView("SimplePage");
	}
	
	@RequestMapping(value="/dates", method = RequestMethod.GET)
	@ResponseBody
	public void getCurrentDate(AtmosphereResource atmosphereResource){
		System.out.println("Entering");
		log.info("===== Entering AtmoController method =====");
		this.suspend(atmosphereResource);
		
		String transportUsed = 
				atmosphereResource.getRequest().getHeader(HeaderConfig.X_ATMOSPHERE_TRANSPORT);
		
		System.out.println("====== Tranport to be used : " + transportUsed + " ======");
		
		Broadcaster broadcaster = BroadcasterFactory.getDefault().get();
		System.out.println("=========== broadcaster is:"+broadcaster.toString());
		broadcaster.addAtmosphereResource(atmosphereResource);
		
		atmosphereResource.addEventListener(new OnDisconnectListener(broadcaster));
				
		log.info("===== Broadcasting the Current Date =====");
		broadcaster.scheduleFixedBroadcast(new DateProvider(), 10, TimeUnit.SECONDS);
		System.out.println("Done");
	}
	
	
	/**
	 * Mainly used because by the time we try to suspend, the {@link AtmosphereResource} 
	 * could be yet not suspended
	 */
	private void suspend(final AtmosphereResource atmosphereResource){
		final CountDownLatch latch = new CountDownLatch(1);
		
		atmosphereResource.addEventListener(new AtmosphereResourceEventListenerAdapter(){
			public void onSuspend(AtmosphereResourceEvent event){
				latch.countDown();
				atmosphereResource.removeEventListener(this);
			}
		});
		
		atmosphereResource.suspend(-1);
		
		try{
			latch.await();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
	private static final class DateProvider implements Callable<String>{
		public String call(){
			System.out.println("Getting date" + DateTime.now().toString("yyyy-MM-dd<->hh:mm:ss"));
			return DateTime.now().toString("yyyy-MM-dd<->hh:mm:ss");
		}
	}
	
	/**
	 * When the browser is shut down we need to stop broadcasting
	 * @author eugenrabii
	 *
	 */
	private static final class OnDisconnectListener extends AtmosphereResourceEventListenerAdapter {
		
		private final Broadcaster broadcaster;
		
		public OnDisconnectListener(Broadcaster broadcaster){
			this.broadcaster = broadcaster;
		}
		
		@Override
		public void onDisconnect(AtmosphereResourceEvent evet){
			System.out.println("===== onDisconnect, closing the connection =====");
			broadcaster.destroy();
		}
	}

	
}
