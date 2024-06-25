//HIDE
public class AppointmentTester
{
   public static void main(String[] args)
   {
      System.out.println("Checking Appointment class ---");
      Appointment a3 = new Appointment("Wash the car 2025/8/1 8:5 9:15");
      System.out.println("Checking toString: " + a3);
      System.out.println("Expected: Wash the car 2025/8/1 08:05 09:15");
   }
}
