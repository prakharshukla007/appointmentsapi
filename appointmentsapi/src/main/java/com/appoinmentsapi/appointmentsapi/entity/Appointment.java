package com.appoinmentsapi.appointmentsapi.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message = "{appointment.appointmentTimeStamp.empty}")
	@Future(message = "{appointment.appointmentTimeStamp.invalid}")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date appointmentTimeStamp;
	
	@NotNull(message = "{appointment.appointmentDuration.empty}")
	private Float appointmentDuration;
	
	@NotBlank(message = "{appointment.purpose.empty}")
	private String purpose;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getAppointmentTimeStamp() {
		return appointmentTimeStamp;
	}

	public void setAppointmentTimeStamp(Date appointmentTimeStamp) {
		this.appointmentTimeStamp = appointmentTimeStamp;
	}

	public Float getAppointmentDuraton() {
		return appointmentDuration;
	}

	public void setAppointmentDuraton(Float appointmentDuraton) {
		this.appointmentDuration = appointmentDuraton;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
}
