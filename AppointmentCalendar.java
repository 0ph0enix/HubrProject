/**
   Made by Anton Tikhonov.
   April 20, version 1.0
   Program that simulates a design of an appointment calendar.
   An appointment includes the date, starting time,
   ending time, and a description; for example:
      Dentist 2016/10/1 17:30 18:30
      CS1 class 2016/10/2 08:30 10:00
      Wash the car 2016/8/1 8:5 9:15
*/
// importing for future use.
import java.util.ArrayList;

public class AppointmentCalendar
{  
   //Initializing variables.
   private ArrayList<Appointment> calendar;

   /**
      Constructs an AppointmentCalendar object.
   */
   public AppointmentCalendar()
   {
      calendar = new ArrayList<Appointment>();
   }

   /**
      Adds an appointment to the calendar.
      @param a the appointment to add
   */
   public void add(Appointment a)
   {
      calendar.add(a);
   }

   /**
      Cancels (removes) an appointment from the calendar.
      @param a the appointment to cancel
   */
   public void cancel(Appointment a)
   {

      for (int i =0; i < calendar.size(); i++)
      {  
         if(calendar.get(i).equals(a))
         {
            calendar.remove(i);
         }
      }
   }

   /**
      Gets all appointment for a certain date.
      @param d the date
      @return the appointments for that day
   */
   public ArrayList<Appointment> getAppointmentsForDay(AppointmentDate d)
   {
      ArrayList <Appointment> AppointmentsForDay = new ArrayList<Appointment>(); 
      for(int i =0; i < calendar.size(); i++)
      {
         if(calendar.get(i).fallsOn(d))
         {
            AppointmentsForDay.add(calendar.get(i));
         }
      }
      return(AppointmentsForDay);
   }
}
