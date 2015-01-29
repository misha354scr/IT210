using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Diagnostics;

namespace CIA
{
   class KmpStringMatcher
   {
      // This code is adapted from
      //1) http://www.inf.fh-flensburg.de/lang/algorithmen/pattern/stringmatchingclasses/KmpStringMatcher.java
      //See also 
      //2) Sedgewick, Algorithms, 4th ed. p. 758
      //3) http://www.ics.uci.edu/~eppstein/161/960227.html
      //4) Goodrich and Tomassia, Data Structures and Algorithms in Java

      private char[] p, t;       // pattern, text
      private int m, n;          // pattern length, text length
      private String matches;    // string of match positions
      private char[] showmatches;// char array that shows matches
      private int[] b;           // used by the KMP algorithm
      private static String name = "Knuth-Morris-Pratt";

      //Properties

      public string Text
      {
         set
         {
            n = value.Length;
            t = value.ToCharArray();
         }
      }

      public string Pattern
      {
         set
         {
            m = value.Length;
            p = value.ToCharArray();
            b = new int[m + 1];
            kmpPreprocess();
         }
      }

      //public methods
      public int search(int start)
      {
         return kmpSearch(0);
      }

      //private methods

      //The pre-processing phase of the KMP algorithm
      //At the end of the run, b[i] holds the length of the
      //the longest border of p.Substring(0, i-1).
      //
      //p.Substring(0, i - 1) is the first i characters of the pattern.
      //
      //A string's border is a substring that is both a proper prefix and a proper suffix
      //of the string
      //Eg. The border of "abbab"  is "ab" and the border of "abbabb" is "abb"
      //(The 'proper' in the definition of border means that a string cannot be
      //considered its own border)
      private void kmpPreprocess()
      {
         int i = 0, j = -1;

         //b[0] = -1 is just a starting point for calculating b[i]
         // b[0] isn't used in the search algorithm
         b[0] = -1;

         while (i < m)
         {
            //To calculate b[i + 1]

            //Iterate over all borders of p.Substring(0, i - 1)
            //Borders are iterated through in the order of decreasing length
            //The loop condition checks each border if it can be extended by p[i]
            //If so, b[i] = the length of that border + 1
            //
            //To loop through all borders, this loop uses the following fact:
            //Let bord = the longest border of p.Substring(0, i - 1)
            //All shorter borders of p.Substring(0, -1) are also borders of bord
            while (j >= 0 && p[i] != p[j])
               j = b[j];
            i++;
            j++;
            b[i] = j;
         }

#if DEBUG
         for (i = 1; i <= p.Length; i++)
         {
            Debug.WriteLine("{0} ", b[i]);
         }
#endif

      }


      // searches the text for all occurences of the pattern p
      // in text t, starting from t[start], using the Knuth-Morris-Pratt
      //algorithm
      //Parameter
      //start - the character in the text at which to start the search

      //The search works like this:
      //There is a text pointer (i) and a pattern pointer(j)
      
      //while i < n (outer loop){
         //(inner loop condition: t[i] == p[j]){
            //if true, break;
            //else, move j pointer back j - b[j] steps, then continue;
            //This slides the start of the pattern forward along the text
            //to the next place where the pattern has at least a chance to match
         //} end inner loop
         //move i and j one one step forward
         //if j == m, found a match
      //} end outer loop
      private int kmpSearch(int start)
      {
         int i = start, j = 0;
         while (i < n)
         {
            while (j >= 0 && t[i] != p[j])
               j = b[j];
            i++;
            j++;
            if (j == m) // a match is found
            {
               return (i - m);
               j = b[j];
            }
         }
         return -1;
      }

      //***************************************************************************
      //private methods for debugging only

      /** initializes match positions and the array showmatches
       */
      private void initmatches()
      {
         matches = "";
         showmatches = new char[n];
         for (int i = 0; i < n; i++)
            showmatches[i] = ' ';
      }
      /** reports a match */
      private void report(int i)
      {
         matches += i + " ";
         showmatches[i] = '^';
      }

      private void DebugSearch(string tt, string pp)
      {
         Text = tt;
         Pattern = pp;
         initmatches();

         int i = 0;
         while (true)
         {
            i = kmpSearch(i);
            if (i == -1)
               break;
            else
            {
               report(i);
               i++;
            }
         }
      }


      /** returns the match positions after the search
    */
      public String getMatches()
      {
         return matches;
      }


      static void Main(string[] args)
      {
         KmpStringMatcher stm = new KmpStringMatcher();
         Console.WriteLine(name);
         String tt, pp;
         tt = "abcdabcd";
         pp = "abc";
         stm.DebugSearch(tt, pp);
         Console.WriteLine(pp);
         Console.WriteLine(tt);
         Console.WriteLine(stm.showmatches);
         Console.WriteLine(stm.getMatches());
         tt = "abababaa";
         pp = "aba";
         stm.DebugSearch(tt, pp);
         Console.WriteLine(pp);
         Console.WriteLine(tt);
         Console.WriteLine(stm.showmatches);
         Console.WriteLine(stm.getMatches());
      }

   }
}

