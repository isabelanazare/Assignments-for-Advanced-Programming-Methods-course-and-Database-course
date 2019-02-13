using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ConsoleApp1.Model;

namespace ConsoleApp1.Repository
{
    public interface IPrgRepository
    {
        //void setPrgState(PrgState p);
        PrgState getCurrentPrgState();

        void logPrgState();
    }
}
