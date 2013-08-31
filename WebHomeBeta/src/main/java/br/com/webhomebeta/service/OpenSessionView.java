package br.com.webhomebeta.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;

public class OpenSessionView extends OpenSessionInViewFilter {
	public void closeSession(Session session, SessionFactory sessionFactory){
		session.flush();
		super.closeSession(session, sessionFactory);
	}
}
