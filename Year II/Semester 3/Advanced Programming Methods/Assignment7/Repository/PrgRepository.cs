using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ConsoleApp1.Model;
using ConsoleApp1.Model.Statements;
using System.IO;
namespace ConsoleApp1.Repository
{
    public class PrgRepository : IPrgRepository
    {
        private PrgState p;
        public PrgRepository(PrgState p)
        {
            this.p = p;
        }

        public PrgState getCurrentPrgState()
        {
            return this.p;
        }
        public void logPrgState()
        {
            PrgState p = this.getCurrentPrgState();

            using (StreamWriter log = File.AppendText("D:\\Year II\\Metode avansate de programare\\ConsoleApp1\\ConsoleApp1\\log.txt"))
            {

                log.WriteLine("ExeStack:\r");
                foreach (Statement st in p.Stack)
                {
                    log.WriteLine(st);
                }
                log.WriteLine("SymbolTable:\r");
                foreach (KeyValuePair<string, int> v in p.Dict)
                {
                    log.WriteLine(v.Key + "->" + v.Value);
                }
                log.WriteLine("Output list:\r");
                foreach (int v in p.Messages)
                {
                    log.WriteLine(v);
                }
                log.WriteLine("\n");

            }

        }
    }
}
