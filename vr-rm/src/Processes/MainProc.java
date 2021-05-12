package Processes;

class MainProc extends ProcessDescriptor {
    public ProcessPriority priority;
    public ProcessState state;

    public void work() { /**Ar reikia to work*/
        switch (processCase) {
            case 1://Blokavimas laukiant resurso ,,TaskActivated''
                break;
            case 2:
                //Vykdymo laikas nelygus nuliui? -->Taip: 3; ne:4.
                break;
            case 3:
                //Kuriamas procesas JobGovernor
                break;
            case 4:
                //Naikinamas procesas JObGovernor
                break;
            default:
        }
    }
}
