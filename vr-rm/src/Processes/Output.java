package Processes;

class Output extends ProcessDescriptor{
    public ProcessPriority priority;
    public ProcessState state;

    public void work() { /**Ar reikia to work*/
        switch (processCase) {
            case 1:
                //Blokavimas laukiant ,,LineInMemory'' resurso
                break;
            case 2:
                //Blokavimas laukiant ,,ChannelDevice'' resurso
                break;
            case 3:
                //Nustatinėjami kanalų įrenginio registrai ir įvykdoma komanda XCHG
                break;
            case 4:
                //Atlaisvinamas ,,Channel Device'' resursas
            case 5:
                //Sukuriamas ir atlaisvinamas resursas ,,FromOutput''
            default:
        }
    }
}