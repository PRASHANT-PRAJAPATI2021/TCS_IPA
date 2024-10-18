import java.util.*;

public class Solution
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    NavalVessel[] arr = new NavalVessel[4];
    for(int i = 0; i<4; i++){
      int a = sc.nextInt(); sc.nextLine();
      String b = sc.nextLine();
      int c = sc.nextInt(); sc.nextLine();
      int d = sc.nextInt(); sc.nextLine();
      String e = sc.nextLine();
      
      arr[i] = new NavalVessel(a,b,c,d,e);
    }
    
    int inputPercent = sc.nextInt(); sc.nextLine();
    String inputPurpose = sc.nextLine();
    
    /*--------------------------------------------------------*/
    int val1 = findAvgVoyagesByPct(arr, inputPercent);
    if(val1 != 0){
      System.out.println(val1);
    }
    
    /*----------------------------------------------------------*/
    findVesselByGrade(arr, inputPurpose);
    
    
  }
  
  public static int findAvgVoyagesByPct(NavalVessel[] arr, int inputPercent)
  {
    int count = 0, sum = 0;
    for(int i = 0; i<arr.length; i++)
    {
      int temp = (arr[i].noOfVoyageCompleted*100)/arr[i].noOfVoyagePlanned;
      if(temp == inputPercent){
        sum += arr[i].noOfVoyageCompleted;
        count++;
      }
      
    }
    return sum/count;
    
  }
  
  public static void findVesselByGrade(NavalVessel[] arr, String inputPurpose)
  {
    for(int i = 0; i<arr.length; i++)
    {
      if(arr[i].purpose.equalsIgnoreCase(inputPurpose)){
        int temp = (arr[i].noOfVoyageCompleted*100)/arr[i].noOfVoyagePlanned;
        if(temp == 100){
          System.out.println(arr[i].vesselName+" Star");
          return ;
        }else if(temp <=99 && temp >= 80){
          System.out.println(arr[i].vesselName + " Leader");
          return;
        }else if(temp <= 79 && temp >= 55){
          System.out.println(arr[i].vesselName + " Inspirer");
          return;
        }else{
          System.out.println(arr[i].vesselName +" Striver");
          return;
        }
      }
    }
    
     System.out.println("No Naval Vessel is available with the specified purpose");
     return;
    
    
  }
  
  
  
  
  
  
  
}

class NavalVessel
{
  int vesselId;
  String vesselName;
  int noOfVoyagePlanned;
  int noOfVoyageCompleted;
  String purpose;
  
  public NavalVessel(int vesselId, String vesselName, int noOfVoyagePlanned, int noOfVoyageCompleted, String purpose)
  {
    this.vesselId = vesselId;
    this.vesselName = vesselName;
    this.noOfVoyagePlanned=noOfVoyagePlanned;
    this.noOfVoyageCompleted = noOfVoyageCompleted;
    this.purpose = purpose;
  }
}
