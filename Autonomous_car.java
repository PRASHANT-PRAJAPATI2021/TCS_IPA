import java.util.*;

public class Solution{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    AutonomousCar[] arr = new AutonomousCar[4];
    for(int i = 0; i<arr.length; i++){
      int a = sc.nextInt(); sc.nextLine();
      String b = sc.nextLine();
      int c = sc.nextInt(); sc.nextLine();
      int d = sc.nextInt(); sc.nextLine();
      String e = sc.nextLine();
      
      arr[i] = new AutonomousCar(a, b, c, d, e);
      
    }
    
    String inputEnv = sc.nextLine();
    String inputbrand = sc.nextLine();
    
    int val1 = findTestPassedByEnv(arr, inputEnv);
    if(val1 != 0){
      System.out.println(val1);
    }else{
      System.out.println("There are no tests passed in this particular environment");
    }
    
    updateCarGrade(arr, inputbrand);
    
    
    
  }
  
  public static int findTestPassedByEnv(AutonomousCar[] arr, String inputEnv){
    int sum = 0;
    for(int i = 0; i<arr.length; i++){
      if(arr[i].environment.equalsIgnoreCase(inputEnv)){
        sum += arr[i].noOfTestsPassed;
      }
    }
    return sum;
    
  }
  
  public static void updateCarGrade(AutonomousCar[] arr, String inputbrand)
  {
    
    for(int i = 0; i<arr.length; i++)
    {
      if(arr[i].brand.equalsIgnoreCase(inputbrand))
      {
        String grade = "";
        int rating = (arr[i].noOfTestsPassed*100)/arr[i].noOfTestConducted;
        if(rating >= 80){
          grade = "A1";
        }else{
          grade = "B2";
        }
        
        System.out.println(arr[i].brand+"::"+ grade);
      }
    }
    
    
    
  }
}


class AutonomousCar{
  int carId;
  String brand;
  int noOfTestConducted;
  int noOfTestsPassed;
  String environment;
  
  public AutonomousCar(int carId, String brand, int noOfTestConducted, int noOfTestsPassed, String environment){
    this.carId = carId;
    this.brand = brand;
    this.noOfTestConducted = noOfTestConducted;
    this.noOfTestsPassed = noOfTestsPassed;
    this.environment = environment;
  }
}
