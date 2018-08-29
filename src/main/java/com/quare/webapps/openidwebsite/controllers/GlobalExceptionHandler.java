package com.quare.webapps.openidwebsite.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import exception.PermissionDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
	@ExceptionHandler(value = NoHandlerFoundException.class)
	public ModelAndView handleNotFound(HttpServletRequest req, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav = populateExceptionModel(mav, ex);
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.addObject("status", 404);
		return mav;
		
	}

	@ExceptionHandler(value = PermissionDeniedException.class)
	public ModelAndView handlePermissionDenied(HttpServletRequest req, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav = populateExceptionModel(mav, ex);
		mav.addObject("status", 401);

		return mav;
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav = populateExceptionModel(mav, ex);
		mav.addObject("status", 500);
		mav.addObject("exception", ex.getClass().getName());

		return mav;
	}

	private ModelAndView populateExceptionModel(ModelAndView model, Exception ex) {
		model.addObject("timestamp", new Date());
		model.addObject("message", ex.getMessage());
		model.setViewName("error");
		return model;
	}
}