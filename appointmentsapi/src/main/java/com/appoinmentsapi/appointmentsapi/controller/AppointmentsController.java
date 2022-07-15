package com.appoinmentsapi.appointmentsapi.controller;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appoinmentsapi.appointmentsapi.entity.Appointment;
import com.appoinmentsapi.appointmentsapi.service.AppointmentsService;

@RestController
public class AppointmentsController {
	
	@Autowired
	private AppointmentsService service;
	
	@GetMapping("/appointments")
	private ResponseEntity<List<Appointment>> getAllAppointments() throws Exception {
		List<Appointment> appointments = service.getAllAppointments();
		return new ResponseEntity<>(appointments, HttpStatus.OK);
	}
	
	@GetMapping("/appointments/{id}")  
	private ResponseEntity<Appointment> getAppointment(@PathVariable("id") Integer id) throws Exception {
		Appointment appointment = service.getAppointmentById(id);
		return new ResponseEntity<>(appointment, HttpStatus.OK);  
	}
	
	@DeleteMapping("/appointments/{id}")  
	private ResponseEntity<Integer> deleteAppointment(@PathVariable("id") Integer id) throws Exception {
		service.deleteAppointment(id);  
		return new ResponseEntity<>(id, HttpStatus.OK);
	}
	
	@PostMapping("/appointments")
	private ResponseEntity<Appointment> saveAppointment(@Valid @RequestBody Appointment appointment) throws Exception {
		service.addAppointment(appointment);
		return new ResponseEntity<>(appointment, HttpStatus.CREATED);
	}
	
	@PutMapping("/appointments/{id}")
	private ResponseEntity<Appointment> updateAppointmet(@PathVariable Integer id, @RequestBody Appointment appointment) throws Exception {
		service.updateAppointment(id, appointment.getAppointmentDuraton());
		return new ResponseEntity<>(appointment, HttpStatus.OK);
	}
	
	@GetMapping("/appointments/{date1}/{date2}")
	private ResponseEntity<List<Appointment>> getAppointmentsBetweenDates(@PathVariable("date1") Date date1, @PathVariable("date2") Date date2) throws Exception {
		List<Appointment> appointments = service.findAppointmentBetweenDates(date1, date2);
		return new ResponseEntity<>(appointments, HttpStatus.OK);
	}
	
}
