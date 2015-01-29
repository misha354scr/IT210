using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
using System.Text.RegularExpressions;

namespace CIA
{
   class TextRedactor
   {
      public static const string REPLACER = "XXXX";

         //Returns an array of strings, each of which is a
         //word or phrase in the parameter
         //Parameters
         //input - string containing keywords and phrases.
         //        Phrases are enclosed in single quotes or double
         //        quotes.  Words and phrases are separated by commas and spaces
         //        Here is an example of valid input:
         //        input = "Hello world /"Boston Red Sox/"  'Pepperoni Pizza', 'Cheese Pizza', beer"
         private static IEnumerable<string> ExtractKeys(string input)
         {
            //create the regex string
            string strRegex = @"(?:""(?<cptr>.*?)"")|(?:'(?<cptr>.*?)')|(?<cptr>[^\s,]+)";
            //This regex:
            //matches "..." where inside the double quotes are zero or more characters and 
            //stores those characters in a capture group named "cptr"
            //OR 
            //matches '...' where inside the single quotes are zero or more characters and 
            //stores those characters in a capture group named "cptr"
            //OR
            //matches one or more characters surrounded by commas or spaces 
            //Example:
            //input = "Hello world /"Boston Red Sox/"  'Pepperoni Pizza', 'Cheese Pizza', beer"
            //genenerates the following captures:
            //    {"Hello", "world", "Boston Red Sox", "Pepperoni Pizza", "Cheese Pizza", "beer"}

            //create the regex object
            Regex myRegex = new Regex(strRegex, RegexOptions.None);

            //run the regular expression and select all captures
            //we need to order the keys by length in descending order by length
            //to avoid the problem that occurs when one key is a substring of another.
            //In that case, if the smaller key is processed first, the larger key won't 
            //ever match
            var queryResult = from Match match in myRegex.Matches(input)
                              let txt = (match.Groups["cptr"].Value)
                              where match.Success && !String.IsNullOrWhiteSpace(txt)
                              orderby txt.Length descending
                              select txt;

            return queryResult;
         }

         private string Replace();

       public static string GetRedactedText(string keys, string tt)
       {
         IEnumerable<string> keyCol = ExtractKeys(keys);
         KmpStringMatcher stm = new KmpStringMatcher();

         foreach (string pp in keyCol)
         {
            int lp = pp.Length;
            int lt = tt.Length;

            stm.Pattern = pp;

            int i = 0; 

            while (true)
            {
               stm.Text = tt;
               i = stm.search(i);
               if (i == -1) break;
               else
               {
                  tt = tt.Substring(0, i - 1) + REPLACER;
                  i += REPLACER.Length;
               }
            }
         }

         return tt;
         }
        
         int i = 0;
         while (i < n);
            return null;
         }


      private char[] p, t;       // pattern, text
      private int m, n;          // pattern length, text length
      private String matches;    // string of match positions
      private char[] showmatches;// char array that shows matches
      private int[] b;           // used by the KMP algorithm
      private static String name = "Knuth-Morris-Pratt";
     // private static 

      /** searches the text tt for the pattern pp
 */
      public void search(String tt, String pp)
      {
         setText(tt);
         setPattern(pp);
         kmpSearch();
      }

     

      /** sets the text
       */
      public void setText(String tt)
      {
         n = tt.Length;
         t = tt.ToCharArray();
         initmatches();
      }

      /** sets the pattern
       */
      public void setPattern(String pp)
      {
         m = pp.Length;
         p = pp.ToCharArray();
         b = new int[m + 1];
         kmpPreprocess();
      }

      /** initializes match positions and the array showmatches
       */
      private void initmatches()
      {
         matches = "";
         showmatches = new char[n];
         for (int i = 0; i < n; i++)
            showmatches[i] = ' ';
      }


      /** returns the match positions after the search
    */
      public String getMatches()
      {
         return matches;
      }



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

      private void report(int i)
      {
         matches += i + " ";
         showmatches[i] = '^';
      }


      /* searches the text for all occurences of the pattern*/
      //The search works like this:
      //There is a text pointer (i) and a pattern pointer(j)
      //while i < n (outer loop){
         //(inner loop condition: t[i] == p[j]){
            //if true, break;
            //else, move j pointer back j - b[j] steps, then continue;
               //This slides the start of the pattern forward along the text
               //to the next place where the pattern has at least a chance to match
         //}
         //move i and j one one step forward
         //if j == m, found a match
      //} 
      private int kmpSearch()
      {
         int i = 0, j = 0;
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

      static void Main(string[] args)
      {
        KmpStringMatcher stm=new KmpStringMatcher();
        Console.WriteLine(name);
        String tt, pp;
        tt="abcdabcd";
        pp="abc";
        stm.search(tt, pp);
        Console.WriteLine(pp);
        Console.WriteLine(tt);
        Console.WriteLine(stm.showmatches);
        Console.WriteLine(stm.getMatches());
        tt="abababaa";
        pp="aba";
        stm.search(tt, pp);
        Console.WriteLine(pp);
        Console.WriteLine(tt);
        Console.WriteLine(stm.showmatches);
        Console.WriteLine(stm.getMatches());      }

      /*

      // Construct matcher

      string_match::string_match(const char * t, int tlen = -1)
      {
          target = save_string(t, tlen);
          retarget = make_retarget(target);
          index = 0;
      }


      // Do the search

      int
      string_match::match(char c)
      {
          if (retarget == 0) return 0;

          while (c != target[index]) {
         if (index == 0) return 0; // fell all the way back, have to give up
         index = retarget[index]; // more positions to fall back to, keep trying
          }
          if (target[++index] != '\0') return 0;	// partial match
          else {
         index = retarget[index]; // full match, but keep going
         return 1;
          }
      }

      /*

      ** match - linear time string match algorithm
      ** David Eppstein / Columbia University / 29 Jan 1988


      #include "match.h"
      #include <string.h>

      // Make copy of string in a safe place
      const char * save_string(const char * s, int slen = -1)
      {
          if (s == 0) return 0;
          if (slen < 0) slen = strlen(s);
          char * new_s = new char[slen + 1];
          if (new_s == 0) return 0;
          memcpy(new_s, s, slen);
          new_s[slen] = '\0';
          return new_s;
      }

      // Make jump table for mismatches (the usual finite state automaton).
      //
      // The inner loop works by checking the prefixes the next character of
      // the target can continue, longest first, chaining back by way of the
      // previously filled retarget entries, until it either finds one that
      // matches (the != clause) or runs out of prefixes (the > 0 clause).

      static int * make_retarget(const char * target)
      {
          if (target == 0) return 0;
          int * retarget = new int[strlen(target)+1];
          if (retarget == 0) return 0;
          retarget[0] = -1;		// set up for loop below; unused by match()

          for (int i = 0; target[i] != '\0'; i++) {
         retarget[i + 1] = retarget[i] + 1;
         while (retarget[i + 1] > 0 &&
                target[i] != target[retarget[i + 1] - 1])
             retarget[i + 1] = retarget[retarget[i + 1] - 1] + 1;
          }
          return retarget;
      }*/
   }
}