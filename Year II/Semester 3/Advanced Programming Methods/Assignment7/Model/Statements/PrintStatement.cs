using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ConsoleApp1.Model.Expressions;

namespace ConsoleApp1.Model.Statements
{
    public class PrintStatement : Statement
    {
        private Expression expr;

        public PrintStatement(Expression e)
        {
            this.expr = e;
        }

        public PrgState Execute(PrgState p)
        {
            int res = this.expr.Eval(p.Dict);
            p.Messages.AddValue(res);
            return p;
        }

        public override string ToString()
        {
            return "print(" + this.expr + ")\n";
        }
    }
}
