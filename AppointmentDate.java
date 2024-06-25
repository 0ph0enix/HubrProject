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
public class AppointmentDate
{  
   //Initializing variables.
   private int year;
   private int month; 
   private int day;

   /**
      Constructs an AppointmentDate object.
      @param d the date
   */
   public AppointmentDate(String d)
   {

   // checking for a right format from now on.
   boolean cheching_for_right_format = true; // checker
   for (char c : d.toCharArray()) // making an array of chars from the initial string
   { 
      if( !(c != '/' || !(Character.isDigit(c))) )
      {
         //Only "/" and numbers are allowed in a date.
         cheching_for_right_format = false;
         break; // for efficiency 
      }
   }
   //checking if we have only 3 numbers, if it's true that we have to separate data.
   if(cheching_for_right_format == true) // if it's false already we don't have to check.
   {
      String[] data_array = d.split("/");//separation of the data
      if(data_array.length != 3) //only years, months and days exist.
      {
         cheching_for_right_format = false;
      } 
      else
      {
         //variables are now initialized 
         year = Integer.parseInt(data_array[0]);
         month = Integer.parseInt(data_array[1]);
         day = Integer.parseInt(data_array[2]);
         
         //We still have to check if all of the numbers are correct dates.
         if (year < 2024) { cheching_for_right_format = false;} // you can't make an Appointment in past
         if ( (0 < month && month < 13) && cheching_for_right_format == true) // we have to check days
         {
            if(day > 31 || day < 1) // There are no month that contains more that 31 day or less than 1
            {
               cheching_for_right_format = false;
            }
            else // Now we check if month has proper amount of days
               // Not all of them have 31 day in it.
            {
               switch (month) {
                  case 2:  if( leap_year(year)) // checking if it leap year by calling a method, if it is than it's 29 days
                           {
                              if(day > 29){cheching_for_right_format = false;}; 
                           }
                           else
                           {
                              if(day > 28){cheching_for_right_format = false;}; 
                           };
                           break;
                  case 4:  if(day == 31){cheching_for_right_format = false;};
                           break;
                  case 9:  if(day == 31){cheching_for_right_format = false;};
                           break;
                  case 11: if(day == 31){cheching_for_right_format = false;};
                           break;
              }
            }
         }
         else // we only have 12 months
         {
            cheching_for_right_format = false;
         }
      }
   }
   // if something is wrong, that we have it gone back to default
   if(cheching_for_right_format == false)
   {
      year = -1;
      month = -1;
      day = -1;
   }


   }
   /**
      Determines if years is leap.
      @param year is the year
      @return true if years is leap, false otherwise
   */
   public boolean leap_year(int year)
   {
      boolean leap = false;

    if (year % 4 == 0) 
    {
      if (year % 100 == 0) 
      {
        if (year % 400 == 0)
        {
          leap = true;
        }
        else
        {
          leap = false;
        }
      }
      else
      {
        leap = true;
      } 
    }
    else
    {
      leap = false;
    }
   return(leap);
   }

   /**
      Determines if dates are equal.
      @param the other date
      @return true if the dates are equal, false otherwise
   */
   public boolean equals(Object other)
   {

      AppointmentDate otherObject  = (AppointmentDate) other;
      boolean checker_for_equality = true;

      
      if ( year != otherObject.year )        
      { 
         checker_for_equality = false;
      }
      if ( month != otherObject.month )        
      { 
         checker_for_equality = false;
      }
      if ( day != otherObject.day )        
      { 
         checker_for_equality = false;
      }

      return (checker_for_equality);
   }

   /**
      Prints a string representation of the date.
      @return the date
   */
   public String toString()
   {
      return (year + "/" + month + "/" + day);
   }
}
