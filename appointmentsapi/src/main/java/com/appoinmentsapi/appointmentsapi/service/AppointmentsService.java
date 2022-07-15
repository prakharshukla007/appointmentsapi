package com.appoinmentsapi.appointmentsapi.service;

import java.sql.Date;
import java.util.List;

import com.appoinmentsapi.appointmentsapi.entity.Appointment;
import com.appoinmentsapi.appointmentsapi.utility.AppointmentsException;

public interface AppointmentsService {
	
	public List<Appointment> getAllAppointments() throws AppointmentsException;
	
	public Appointment getAppointmentById(Integer id) throws AppointmentsException;
	
	public void deleteAppointment(Integer id) throws AppointmentsException;

	public void addAppointment(Appointment appointment) throws AppointmentsException;
	
	public List<Appointment> findAppointmentBetweenDates(Date date1, Date date2) throws AppointmentsException;
	
	public void updateAppointment(Integer id, Float duration) throws AppointmentsException;
	
}
