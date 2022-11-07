package com.upgrad.bookmyconsultation.controller;

import com.upgrad.bookmyconsultation.entity.Appointment;
import com.upgrad.bookmyconsultation.exception.InvalidInputException;
import com.upgrad.bookmyconsultation.exception.SlotUnavailableException;
import com.upgrad.bookmyconsultation.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;


	    //create a method post method named bookAppointment with return type ReponseEntity
		//method has paramter of type Appointment, use RequestBody Annotation for mapping
	
		//save the appointment details to the database and save the response from the method used
		//return http response using ResponseEntity

		@PostMapping("/bookAppointment")
		public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) throws InvalidInputException {
			appointmentService.appointment(appointment);
			return ResponseEntity.ok(appointment);
		}

	
	
	
	//create a get method named getAppointment with return type as ResponseEntity
		//method has appointmentId of type String. Use PathVariable annotation to identity appointment using the parameter defined
		
		//get the appointment details using the appointmentId
		//save the response
		//return the response as an http response

	@GetMapping("/getAppointment/{appointmentId}")
	public ResponseEntity<Appointment> getAppointment(@PathVariable String appointmentId){
			Appointment appointment = appointmentService.getAppointment(appointmentId);
			return ResponseEntity.ok(appointment);

	}
	
	

}