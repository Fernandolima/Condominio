package br.com.webhomebeta.controller;

import java.sql.Date;

import javax.mail.Address;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.webhomebeta.to.UsuarioTO;

public class UsuarioValidator implements Validator {
	 /**
	   * Return true if this object can validate objects of the given class. This is cargo-cult
	   * code: all implementations are the same and can be cut 'n' pasted from earlier examples.
	   */
	  @Override
	  public boolean supports(Class<?> clazz) {

	    return clazz.isAssignableFrom(UsuarioTO.class);
	  }

	  /**
	   * Validate an object, which must be a class type for which the supports() method returned
	   * true.
	   *
	   * @param obj The target object to validate
	   * @param errors contextual state info about the validation process (never null)
	   */
	  @Override
	  public void validate(Object obj, Errors errors) {

	    Date date = (Date) obj;
	    int data = date.getDate();
	    
	  }

}
