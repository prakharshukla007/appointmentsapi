package com.appoinmentsapi.appointmentsapi.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appoinmentsapi.appointmentsapi.entity.Appointment;

public interface AppointmentsRepository extends JpaRepository<Appointment, Integer>{
	
	List<Appointment> findAppointmentByAppointmentTimeStampBetween(Date date1, Date date2);

}
