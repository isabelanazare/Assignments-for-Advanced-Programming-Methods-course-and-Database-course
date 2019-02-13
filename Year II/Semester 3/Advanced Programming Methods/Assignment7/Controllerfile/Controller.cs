using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ConsoleApp1.Repository;
using ConsoleApp1.Model.Statements;
using ConsoleApp1.Model;
namespace ConsoleApp1.Controllerfile
{
    public class Controller
    {
        private IPrgRepository repo;

        public Controller(IPrgRepository r)
        {
            this.repo = r;
        }

        public void executeOneStep()
        {
            PrgState p = repo.getCurrentPrgState();
            Statement stmt = p.Stack.pop();

            stmt.Execute(p);
            Console.WriteLine(p);
        }

        public void executeAllSteps()
        {
            PrgState p = repo.getCurrentPrgState();
            while (!p.Stack.IsEmpty())
            {
                this.executeOneStep();
                repo.logPrgState();
            }
        }

    }
}
