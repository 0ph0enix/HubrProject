public class AppointmentDateTimeTester
{
   public static void main(String[] args)
   {
      System.out.println("Checking AppointmentDate class ---");
      AppointmentDate d = new AppointmentDate("2016/3/15");
      System.out.println("Checking good date: " + d);
      System.out.println("Expected: 2016/3/15");
      // bad format
      d = new AppointmentDate("Jan 15, 2016");
      System.out.println("Checking bad format: " + d);
      System.out.println("Expected: -1/-1/-1");
     /// System.out.println("Invalid date format: " + AppointmentDate.BAD_DATE);
      System.out.println("Expected: -1/-1/-1");
      ///System.out.println(d.equals(AppointmentDate.BAD_DATE));
      System.out.println("Expected: true");
      // bad date - only 28/29 in Feb
      d = new AppointmentDate("2016/02/30");
      System.out.println("Checking invalid date: " + d);
      System.out.println("Expected: -1/-1/-1");
      d = new AppointmentDate("2016/02/02"); // groundhog day
      AppointmentDate d2 = new AppointmentDate("2016/02/02"); // also
      System.out.println("Checking equals: " + d.equals(d2));
      System.out.println("Expected: true");
      System.out.println("Checking equals (shouldn't crash): " + d.equals(null));
      System.out.println("Expected: false");
      System.out.println("Checking equals (shouldn't crash): " + d.equals("2016/02/02"));
      System.out.println("Expected: false");

      System.out.println();
      System.out.println("Checking AppointmentTime class ---");
      AppointmentTime t1 = new AppointmentTime("8:15"); // 8:15 pm
      System.out.println("Checking good time: " + t1);
      System.out.println("Expected: 08:15");
      t1 = new AppointmentTime("7:05");
      System.out.println("Checking good time: " + t1);
      System.out.println("Expected: 07:05");
      ///System.out.println("Invalid time format: " + AppointmentTime.BAD_TIME);
      System.out.println("Expected: -1:-1");
      t1 = new AppointmentTime("7:60"); // bad time
      System.out.println("Checking bad time: " + t1);
      System.out.println("Expected: -1:-1");
      t1 = new AppointmentTime("24:05"); // bad time
      System.out.println("Checking bad time: " + t1);
      System.out.println("Expected: -1:-1");
      t1 = new AppointmentTime("8:15");
      System.out.println("Checking equals: " + t1.equals(new AppointmentTime("8:15")));
      System.out.println("Expected: true");
      System.out.println("Checking equals (shouldn't crash): " + t1.equals(null));
      System.out.println("Expected: false");
      System.out.println("Checking equals (shouldn't crash): " + t1.equals("8:15"));
      System.out.println("Expected: false");
   }
}
