using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Collections;


namespace ConsoleApplication1
{

   class Program
   {
      static void Main(string[] args)
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

         //For example the string
         //"Hello world /"Boston Red Sox/"  'Pepperoni Pizza', 'Cheese Pizza', beer"
         //genenerates the following captures:
         //{"Hello", "world", "Boston Red Sox", "Pepperoni Pizza", "Cheese Pizza", "beer"}

         //create the regex object
         Regex myRegex = new Regex(strRegex, RegexOptions.None);

         //the text to be analyzed
         string strTargetString = @"Is this, ., 'wh,at',at you call ""love, at first sight"" or 'love at second sight'," + 
            @"Hello world ""Boston Red Sox"" 'Pepperoni Pizza','' ""  "" 'Cheese Pizza', beer";

         Console.WriteLine("This input text:");
         Console.WriteLine(strTargetString);
         Console.WriteLine();

         Console.WriteLine("The matches:");
         //run the regular expression and select all captures
         var col = from Match match in myRegex.Matches(strTargetString)
                   let txt = (match.Groups["cptr"].Value)
                   where match.Success && !String.IsNullOrWhiteSpace(txt)
                   select txt;

         //print all captures
         foreach (String str in col)
            Console.WriteLine(str);
      }
   }
}