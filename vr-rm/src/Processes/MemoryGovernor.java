package Processes;

class MemoryGovernor extends ProcessDescriptor {
    public ProcessPriority priority;
    public ProcessState state;

    public void work() { /**Ar reikia to work*/
        switch (processCase) {
            case 1:
                //Blokavimas laukiant ,,Semaphore'' resurso
                break;
            case 2:
                //Veiksmai su duomenimis
                break;
            case 3:
                //Vykdomas nuskaitymas
                break;
            case 4:
                //Vykdomas įrašymas
            case 5:
                //Atlaisvinama nustatyta bendros atminties sritis
            case 6:
                //Sukuriamas ir atlaisvinamas resursas ,,FromMemoryGovernor''
            default:
        }
    }
}
