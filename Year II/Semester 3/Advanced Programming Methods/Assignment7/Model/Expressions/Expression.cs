using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ConsoleApp1.Model.ADT;

namespace ConsoleApp1.Model.Expressions
{
    public interface Expression
    {
        int Eval(ISymbolTable<string, int> dict);
    }
}
