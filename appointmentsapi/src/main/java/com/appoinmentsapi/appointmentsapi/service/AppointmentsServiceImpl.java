package com.appoinmentsapi.appointmentsapi.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appoinmentsapi.appointmentsapi.entity.Appointment;
import com.appoinmentsapi.appointmentsapi.repository.AppointmentsRepository;
import com.appoinmentsapi.appointmentsapi.utility.AppointmentsException;

@Service
@Transactional
public class AppointmentsServiceImpl implements AppointmentsService {
	
	public static final Log LOGGER = LogFactory.getLog(AppointmentsServiceImpl.class);
	
	@Autowired
	AppointmentsRepository repository;

	//Fetches all appointments from DB
	@Override
	public List<Appointment> getAllAppointments() throws AppointmentsException {
		List<Appointment> appointments = new ArrayList<>();
		repository.findAll().forEach(appointment -> appointments.add(appointment));
		if(appointments.isEmpty())
			throw new AppointmentsException("Service.APPOINTMENTS_NOT_FOUND");
		else
			LOGGER.info("Appointments found!");
		return appointments; 
	}
	
	//Fetches appointment based on id
	@Override
	public Appointment getAppointmentById(Integer id) throws AppointmentsException {
		Optional<Appointment> opt = repository.findById(id);
		Appointment appointment = opt.orElseThrow(() -> new AppointmentsException("Service.APPOINTMENT_NOT_FOUND"));
		return appointment;
	}
	
	//Deletes appointment based on id
	@Override
	public void deleteAppointment(Integer id) throws AppointmentsException {
		Optional<Appointment> opt = repository.findById(id);
		opt.orElseThrow(() -> new AppointmentsException("Service.APPOINTMENT_NOT_FOUND"));
		repository.deleteById(id);
	}

	//Adds a new appointment
	@Override
	public void addAppointment(Appointment appointment) throws AppointmentsException {
		repository.save(appointment);
		LOGGER.info("Appointment added");
	}
	
	//Fetches appointment in a date range
	@Override
	public List<Appointment> findAppointmentBetweenDates(Date date1, Date date2) throws AppointmentsException {
		List<Appointment> appointments = repository.findAppointmentByAppointmentTimeStampBetween(date1, date2);
		if(appointments.isEmpty())
			throw new AppointmentsException("Service.APPOINTMENTS_NOT_FOUND");
		else
			LOGGER.info("Appointments found within the given range!");
		return repository.findAppointmentByAppointmentTimeStampBetween(date1, date2);
	}
	
	//Updates an appointment's duration
	@Override
	public void updateAppointment(Integer id, Float duration) throws AppointmentsException {
		Optional<Appointment> opt = repository.findById(id);
		Appointment toUpdate = opt.orElseThrow(() -> new AppointmentsException("Service.APPOINTMENT_NOT_FOUND"));
		if(toUpdate != null)
			LOGGER.info("Appointment to be updated found!");
		toUpdate.setAppointmentDuraton(duration);
	}

}
