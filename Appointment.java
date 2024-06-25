/**
   Made by Anton Tikhonov.
   April 20, version 1.0
   Program that simulates a design of an appointment calendar.
   An appointment includes the date, starting time,
   ending time, and a description; for example:
      Dentist 2016/10/1 17:30 18:30
      CS1 class 2016/10/2 08:30 10:00
      Wash the car 2026/8/1 8:5 9:15
*/
public class Appointment
{
   //Intitalizing variables
   private String description = ""; 
   private AppointmentDate date;
   private AppointmentTime time;
   
   /**
      Constructs an Appointment object.
   */
   public Appointment(String s)
   {
      String[] appointment_array = s.split(" ");
/**
I have to make an assumption here. It’s impossible to fix all possible mistakes when a person enters the text 
b/c we receive 4 arguments in a line. We can’t separate descriptions from, let’s say, 
the date if it is put like this: Description of things101 January 15. 
So, I assume the user will enter the program in a perfect format. But, I don’t assume that date of time is correct. 
*/
      for(int i = 0; i < ((appointment_array.length) - 3); i++ )
      {
         description = description + appointment_array[i] + " ";          
         /**
         We don't know how many words description has, but b/c we are separated by whitespace
         we have an array where the last 3 elements are date and time, so everything else is
         description. So by for loop we have it done.
          */
      }

      String fulltime = ""; // making time sting to pass it to the class.
      fulltime = fulltime + appointment_array[(appointment_array.length)-2] + ":";
      // I add : between so in future i can easily separate it by : in date class
      fulltime = fulltime + appointment_array[(appointment_array.length)-1];
      
      //Passing strings to sub-classes
      date = new AppointmentDate( appointment_array[(appointment_array.length)-3] );
      time = new AppointmentTime(fulltime);
   }

   /**
      Determines if this appointment is the same as another appointment.
      @param other the other appointment
      @return true if the appointments are equal, false otherwise
   */
   public boolean equals(Object other)
   {
      Appointment otherObject  = (Appointment) other;
      boolean checker_for_equality = true; // We assume that is true

      if (!(description.equals(otherObject.description))) { checker_for_equality = false;}
      else   if (!(date.equals(otherObject.date)))        { checker_for_equality = false;}
      else   if (!(time.equals(otherObject.time)))        { checker_for_equality = false;}
      // Unless some part of the class is not equal, then we changing it to false. 
      return (checker_for_equality);
   }

   /**
      Determines if an appointment falls on a certain day.
      @param d the appointment date
      @return true if the appointment date falls on a
          certain day false, otherwise
   */
   public boolean fallsOn(AppointmentDate d)
   {
      if(date.equals(d))
      {
         return(true);
      }
      else
      {
         return(false);
      }
   }

   /**
      Formats the appointment.
   */
  //I think that we should use here toString(), b/c it doesn't make sense otherwise
  // What toformat() should do? But we need for sure toString(). So I took a liberty and changed it.
   public String toString()
   {      
      return(description  + date.toString() + " " + time.toString());
   }
}
