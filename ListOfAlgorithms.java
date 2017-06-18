import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ListOfAlgorithms {

  ArrayList<Integer> f = new ArrayList<>();

  List<List<Integer>> t = new ArrayList<>();

  public static void main(String[] args) {
    ListOfAlgorithms LoA = new ListOfAlgorithms();
    ArrayList<Integer[]> arr = new ArrayList<>();

/*    int[][] W = new int[][]{
        {0, 7, 4, 6, 1},
        {Integer.MAX_VALUE, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
        {Integer.MAX_VALUE, 2, 0, 5, 6},
        {Integer.MAX_VALUE, 3, Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
        {Integer.MAX_VALUE, 2, Integer.MAX_VALUE, 1, 0}
    };*/
    int[][] W = new int[][] {
        {0, 10, 1},
        {10, 0, 5 },
        {40, 25, 0}
    };

    int[] test = new int[] {2,3,6,7};

    List<List<Integer>> cool = LoA.combinationSum(test, 7);
    int k = 90;
  }

  /*Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is: [7], [2,2,3] */



  // facts:
  // Backtracking should be used.
  // positive integers only allows us to use backtracking.


  // if promising
  // sub-problem: How to determine if a candidate is promising?
  //     sub-sub-problem: do we use recursion? YES, If so, target = target - candidate[i]
  //          do we use for-loop for candidates.length? Maybe. Let's try it. (a)


  // pseudo-code (a)
  // foreach candidate
  //    if candidate.promising
  //        if target - candidate == 0
  //            add list to list of lists
  //        else
  //        combinationSum(candidates, target - candidate)
  //    else

  // [2,3,6,7] -> 7
  // [2]
  // [2,3,6,7] -> 5
  // [2,2]
  // [2,3,6,7] -> 3
  // [2,2,2]
  // [2,3,6,7] -> 1
  // backtrack to 3
  // [2,3,6,7]
  // [3]
  // [2,3,6,7] -> 0
  // [2,2,3]

  // problem, using backtracking, how do we "backtrack" to the previous state of the list?


  // problem



  public List<List<Integer>> combinationSum(int[] candidates, int target) {

    listOperations(candidates, target);


    return t;

  }

  // problem, deal with permutations, as combinations isn't cool.

  // explore not using a for loop

  // explore using a for loop but with the continue keyword.


  public void listOperations(int[] candidates, int target){

    for (int i = 0; i < candidates.length; i++) {
      f.add(candidates[i]);

      if (target - candidates[i] > 0) {


        listOperations(candidates, target - candidates[i]);
      }

      if (target - candidates[i] == 0) {
        if (notPermutation())
          t.add(new ArrayList<Integer>(f));
      }

      f.remove(f.size() - 1);

    }

  }

  public boolean notPermutation(){

    for (int i = 0; i < t.size(); i++ ){
      ArrayList x = new ArrayList<Integer>(f);
      ArrayList y = new ArrayList(t);

      if ( f.size() == t.get(i).size() ){

        for (int j = 0; j < f.size(); j++){

          if ( x.contains(t.get(i).get(j)) ){
              x.remove(t.get(i).get(j));
          }
        }

        if ( x.size() == 0) return false;


      }
    }

    return true;
  }

    /*Christy is interning at HackerRank. One day she has to distribute some chocolates to her colleagues.
      She is biased towards her friends and may have distributed the chocolates unequally.
      One of the program managers gets to know this and orders Christy to make sure everyone gets equal number of chocolates.

      But to make things difficult for the intern, she is ordered to equalize the number of chocolates
      for every colleague in the following manner,

      For every operation, she can choose one of her colleagues and can do one of the three things.

        She can give one chocolate to every colleague other than chosen one.
        She can give two chocolates to every colleague other than chosen one.
        She can give five chocolates to every colleague other than chosen one.

      Calculate minimum number of such operations needed to ensure that every colleague has the same number of chocolates.  */

  private int minimumOperations(ArrayList arr, int count) {

    for (int i = 1; i < arr.size(); i++) {

      int minimumElement = (int) arr.get(0);
      int currentElement = (int) arr.get(i);


      while (minimumElement != currentElement) {
        if (currentElement - minimumElement == 1) {
          count += 1;
          currentElement = minimumElement;
        } else if (currentElement - minimumElement < 5) {
          count++;
          currentElement += -2;
        } else {
          count++;
          currentElement += -5;
        }
      }
    }


    return count;

  }


  private int lengthOfLongestSubstring(String s) {
    HashMap<Character, Character> mp = new HashMap<>();
    int p = 0;
    int q = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < s.length(); j++) {
        if (q > p) {
          p = q;
        }
        if (mp.containsKey(s.charAt(i))) {
          mp.clear();
          mp.put(s.charAt(j), s.charAt(j));
          q = 1;
        } else {
          q++;
          mp.put(s.charAt(j), s.charAt(j));
        }
      }
    }
    if (q > p) {
      p = q;
    }
    mp.clear();
    q = 0;

    for (int i = s.length() - 1; i >= 0; i--) {
      if (q > p) {
        p = q;
      }
      if (mp.containsKey(s.charAt(i))) {
        mp.clear();
        mp.put(s.charAt(i), s.charAt(i));
        q = 1;
      } else {
        q++;
        mp.put(s.charAt(i), s.charAt(i));
      }
    }

    if (q > p) {
      p = q;
    }

    return p;

  }

    /*Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
    "pwke" is a subsequence and not a substring. */

  private int lengthOfLongestSubstring2(String s) {
    int f = 0;
    int p = 0;
    int q = 0;
    HashMap<Character, Character> mp = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      p = 0;
      f = i;
      mp.clear();

      while (f != s.length() && !mp.containsKey(s.charAt(f))) {
        mp.put(s.charAt(f), s.charAt(f));
        f++;
        p++;
      }


      if (p > q) {
        q = p;
      }
    }
    if (q == 0 && s.length() == 1)
      return 1;
    else
      return q;
  }

  private int findSmallestMetricSpace(ArrayList<Integer> arr) {
    int a = Integer.MAX_VALUE;
    int b;
    for (int i = 0; i < arr.size() - 1; i++) {
      b = Math.abs(arr.get(i) - arr.get(i + 1));
      if (b < a) a = b;
    }
    return a;
  }

    /*
    Given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.
     */

  private ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    int sum = 0;
    ListNode cur = new ListNode(0);
    ListNode l3 = cur;

    while (l1 != null || l2 != null || sum != 0) {
      if (l1 == null && l2 == null) {
      } else if (l1 == null) {
        sum += l2.val;
        l2 = l2.next;
      } else if (l2 == null) {
        sum += l1.val;
        l1 = l1.next;
      } else {
        sum += l1.val + l2.val;
        l1 = l1.next;
        l2 = l2.next;
      }
      if (sum >= 10) {
        l3.val = sum - 10;
        sum = 1;
      } else {
        l3.val = sum;
        sum = 0;
      }
      if (l1 != null || l2 != null || sum != 0) {
        l3.next = new ListNode(0);
        l3 = l3.next;
      }
    }
    return cur;
  }

  /*
      Determine whether an integer is a palindrome.
   */
  private boolean numberIsPalindrome(int x) {
    int y = 0;
    int mult = 1;
    String str = Integer.toString(x);

    if (x < 0) {
      return false;
    }
    for (int i = 0; i < str.length(); i++) {
      y += Character.getNumericValue(str.charAt(i)) * mult;
      mult *= 10;
    }
    if (x - y != 0) {
      return false;
    }
    return true;
  }

  /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
   */
  private int[] twoSum(int[] nums, int target) {

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    int[] arr = new int[2];

    for (int i = 0; i < nums.length; i++) {
      hashMap.put(target - nums[i], nums[i]);

      if (hashMap.containsKey(nums[i])) {
        arr[0] = nums[i];
        arr[1] = hashMap.get(nums[i]);
      }
    }
    return arr;
  }

  /*
    Dijkstra's shortest path algorithm
    Problem: Determine the shortest paths from v1 to all other vertices in a weighted, directed graph.
    Inputs: integer n ≥ 2, and a connected, weighted, directed graph containing n vertices. The graph is
     represented by a two-dimensional array W, which has both its rows and columns indexed from 1 to n,
     where W[i][j] is the weight on the edge from the ith vertex to the jth vertex.
    Outputs: set of edges F containing edges in shortest paths.
   */
  private ArrayList dijkstra(int n,
                        int[] W[],
                        ArrayList<Integer[]> setOfEdges) {
    int i, vNear = 0;
    int[] touch = new int[n];
    int[] length = new int[n];

    for (i = 1; i < n; i++) {
      touch[i] = 0;
      length[i] = W[0][i];
    } // The vertex being examined.

    for (int f = 1; f <= n - 1; f++) {
      int min = Integer.MAX_VALUE;

      for (i = 1; i < n; i++) {
        if (0 <= length[i] && length[i] < min) {
          min = length[i];
          vNear = i;
        }
      }
      Integer edge[] = {touch[vNear]+1, vNear+1};
      setOfEdges.add(edge);

      for(i = 1; i < n; i++)
        // length + W is using the length of the intermediate node(s?). W[vNear][i] is the intermediate node(s?).
        if(length[vNear] + W[vNear][i] < length[i]){
          length[i] = length[vNear] + W[vNear][i]; // if length[i]
          touch[i] = vNear;
        } // else, the next shortest path must still reside somewhere in the current graph.
      length[vNear] = -1;

    }
    return setOfEdges;
  }

    public String convert(String s, int numRows) {
      // p     i     n
      // a   l s   i g
      // y a   h r
      // p     i


      // p        h
      // a      s i
      // y    i   r
      // p  l     i  g
      // a        n

      // 2(n) where n = numRows - row #?


      int totalNumberOfPossibleHopsPerTurn = 2 * (numRows - 1);

      if ( totalNumberOfPossibleHopsPerTurn == 0 ) {
        totalNumberOfPossibleHopsPerTurn = 1;
      }

      String newString = "";

      for (int rowNum = 0; rowNum < numRows; rowNum++){

        int totalHopsForThisRow = rowNum;
        int whatevs = 0;
        int hopAmount = 2 * ( numRows - ( rowNum+1 ) );
        if ( hopAmount == 0 ) {
          hopAmount = totalNumberOfPossibleHopsPerTurn;
        }

        while ( totalHopsForThisRow < s.length() ) {

          newString += s.charAt( totalHopsForThisRow );

          if ( hopAmount - totalNumberOfPossibleHopsPerTurn == 0 ) {
            totalHopsForThisRow += hopAmount;
          } else{
            if ( whatevs == 0 ) {
              totalHopsForThisRow += hopAmount;
              whatevs = 1;
            } else {
              totalHopsForThisRow += totalNumberOfPossibleHopsPerTurn - hopAmount;
              whatevs = 0;
            }

          }
        }
      }

      return newString;

    }

}
