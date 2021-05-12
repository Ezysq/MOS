package Processes;

class Interrupt extends ProcessDescriptor {
    public ProcessPriority priority;
    public ProcessState state;

    public void work() { /**Ar reikia to work*/
        switch (processCase) {
            case 1:
                //Procesas laukia ,,Interrupt’’ resurso, kurį siunčia procesas VirtualMachine.
                break;
            case 2:
                //Procesas nuskaito pertraukimo tipą apklausdamas sisteminių kintamųjų reikšmes,
                // kurias nustato pertraukimo programos.
                break;
            case 3:
                //Nustatomas procesas JobGovernor, kuris atsakingas už pertrauktos virtualios mašinos darbą.
                break;
            case 4:
                //Kuriamas ir atlaisvinamas ,,FromInterrupt’’ resursas, kuris yra skirtas
                // nustatytam JobGovernor procesui.
            default:
        }
    }
}
