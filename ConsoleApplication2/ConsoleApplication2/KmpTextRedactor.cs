using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;
using System.Text.RegularExpressions;

namespace CIA
{
   public class KmpTextRedactor
   {
      public static readonly string REPLACER = "XXXX";

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

      //Returns a string containing the user provided document text, with all instances of given keywords
      //and phrases replaced with XXX
      //Parameters:
      //patterns -  a string containing words and phrases to be taken out, separated by whitespace or commas. 
      //tt - The text of the document
      public static string GetRedactedText(string patterns, string tt)
      {
         //extract the patterns to match from the user input
         IEnumerable<string> keyCol = ExtractKeys(patterns);

         //Get a Knuth-Morris-Pratt string matcher
         KmpStringMatcher stm = new KmpStringMatcher();

         //iterate over the patterns
         foreach (string pp in keyCol)
         {
            stm.Pattern = pp;

            //Search for instances of the pattern in the text

            int i = 0; //start searching at the beginning of the text
            while (true)
            {
               stm.Text = tt;
               i = stm.search(i);

               //pattern not found
               if (i == -1) break;

               //found an instance
               else
               {
                  int prefixLength = i;

                  //mark start of the text after the matched pattern instance
                  int suffixStart = i + pp.Length;
                  int suffixLength = tt.Length - pp.Length - (i + 1);

                  //replace the instance with the replacer string
                  tt = tt.Substring(0, prefixLength) + REPLACER +
                        tt.Substring(suffixStart, suffixLength);

                  //Resume search at the character following
                  //the place where the pattern used to be
                  i += REPLACER.Length;
               }
            }
         }
         return tt;
      }

      //for testing
       static void Main(string[] args)
      {
         string text = "Hello world hi baby bye \"Boston Red Sox\" " +
                           "'Pepperoni Pizza', is a bull 'Cheese Pizza', This beer";

         String patterns = "Hello world \"Boston Red Sox\" " +
                           "'Pepperoni Pizza', 'Cheese Pizza', beer";

         string newText = GetRedactedText(patterns, text);

         Console.WriteLine("Patterns:\n" + patterns);
         Console.WriteLine();
         Console.WriteLine("Text:\n" + text);
         Console.WriteLine();
         Console.WriteLine("New text:\n" + newText);
      }
   }
}


