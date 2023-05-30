/* A good meal is a meal that contains exactly two different food items with a sum of deliciousness equal to a 
power of two. You can pick any two different foods to make a good meal. Given an array of integers deliciousness 
where deliciousness[i] is the deliciousness of the i​​​​​​th​​​​​​​​ item of food, return the possible number of good meals. 
Note that items with different indices are considered different even if they have the same deliciousness value. 
* Eg 1 :  deliciousness = [1,3,5,7,9]                       Output = 4
* Eg 2 :  deliciousness = [1,1,1,3,3,3,7]                   Output = 15
*/
import java.util.*;
public class GoodMeals
{
      public int CountDeliciousPairs(int deliciousness[])
      {
            int count = 0;      // Counting the number of pairs... //*  Variable => O(1)
            Arrays.sort(deliciousness);    //! Sorting => O(N log N)
            for(int i = 0; i < deliciousness.length - 1; i++)    //! Comparison => O(N)
            {
                  for(int j = i + 1; j < deliciousness.length; j++)    //! Comparison => O(N)
                  {
                        if(ExponentialDivisible(deliciousness[i] + deliciousness[j]))  // Function call...
                              count++;    // Incrementing the counter variable...
                  }
            }
            return count;    // Returning the number of good meals...
      }
      public boolean ExponentialDivisible(int value)    // Function to check if the number is a power of two...
      {
            int i = 0;    // Variable  //*  Variable => O(1)
            while(value >= i)      //! Comparison => O(N)
            {
                  if((Math.pow(2, i) / value) == 1)    // Condition checking...
                        return true;    // return the answer as true...
                  i++;
            }
            return false;     // return the answer as false...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int x;
            System.out.print("Enter the number of food items : ");
            x = sc.nextInt();
            int food[] = new int[x];
            for(int i = 0; i < food.length; i++)
            {
                  System.out.print("Enter deliciousness of "+(i+1)+"th food : ");
                  food[i] = sc.nextInt();
            }
            GoodMeals goodmeals = new GoodMeals();
            System.out.println("The Number of good meals : "+goodmeals.CountDeliciousPairs(food));
            sc.close();
      }
}


//! Time Complexity => O(N x N)
//* Variable => O(1)

/** //? DEDUCTIONS :-
 * ? Sorting the array, then checking the elements row wise to find the possible combinations of two numbers whose
 * ? sum is equal to the power of two...
 */