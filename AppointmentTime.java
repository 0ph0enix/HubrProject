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
public class AppointmentTime
{  
   //Initializing variables.
   private int start_hours;
   private int start_minute; 
   private int end_hours;
   private int end_minute;

   /**
      Constructs an AppointmentTime object
      @param t the time
   */
   public AppointmentTime(String t)
   {  
      String[] time_array = t.split(":");
      boolean cheching_for_right_time = false;
      if (time_array.length != 4) //Should have only 4 things
      {
         cheching_for_right_time = false;
      }
      else
      {
      start_hours = Integer.parseInt(time_array[0]);
      start_minute = Integer.parseInt(time_array[1]); 
      end_hours = Integer.parseInt(time_array[2]);
      end_minute = Integer.parseInt(time_array[3]);
      }
      //cheking if time is wrong
      if ( ( -1 < start_hours && start_hours < 24) && ( -1 < end_hours && end_hours < 24) )
      {
         if ( ( -1 < start_minute && start_minute < 60) && ( -1 < end_minute && end_minute < 60) )
         {
            cheching_for_right_time = true;
         }
      }

      if (cheching_for_right_time == false)
      {
         start_hours = -1;
         start_minute = -1;
         end_hours = -1;
         end_minute = -1;
      }

   }

   /**
      Determines if the appointment times are equal.
      @param other the other time
      @return true if the appointment times are equal,
           false otherwise
   */
   public boolean equals(Object other)
   {

      AppointmentTime otherObject  = (AppointmentTime) other;
      boolean checker_for_equality = true;

      if ( start_hours != otherObject.start_hours )        
      { 
         checker_for_equality = false;
      }
      if ( start_minute != otherObject.start_minute )        
      { 
         checker_for_equality = false;
      }
      if ( end_hours != otherObject.end_hours )        
      { 
         checker_for_equality = false;
      }
      if ( end_minute != otherObject.end_minute )        
      { 
         checker_for_equality = false;
      }

      return (checker_for_equality);

   }

   /**
      Prints a string representation of the time.
      @return the time
   */
   public String toString()
   {
      String return_string = "";
      // We need this so 8:5 would be presented as 08:05
      if( -1 < start_hours && start_hours < 10)  {return_string = return_string + "0" + start_hours + ":";}
      else                  {return_string = return_string  + start_hours + ":";}
      if( -1 < start_minute && start_minute < 10) {return_string = return_string + "0" + start_minute + " ";}
      else                  {return_string = return_string  + start_minute + " ";}
     
      if(-1 < end_hours && end_hours < 10)  {return_string = return_string + "0" + end_hours + ":";}
      else                {return_string = return_string  + end_hours + ":";}
      if(-1 < end_minute && end_minute < 10) {return_string = return_string + "0" + end_minute;}
      else                {return_string = return_string  + end_minute ;}     

      return return_string; 
   }
}
