package Processes;

class JobGovernor extends ProcessDescriptor{
    public ProcessPriority priority;
    public ProcessState state;
    public void work(){ /**Ar reikia to work*/
        switch (processCase){
            case 1:
                //Blokavimasis laukiant resurso ,,UserMemory’’ -
                break;
            case 2:
                //Atlaisvinamas resursas ,,InfoAboutPaths''
                break;
            case 3:
                //Blokavimasis laukiant resurso ,,FromLoader’’
                break;
            case 4:
                //Atlaisvinamas resursas ,,ExternalMemory''
                break;
            case 5:
                //Blokavimasis laukiant resurso ,,UserMemory’’ ????
                break;
            case 6:
                //Kuriamas procesas ,,VirtualMachine''
                break;
            case 7:
                //Blokavimasis laukiant resurso ,,FromInterrupt''
                break;
            case 8:
                //Proceso ,,VirtualMachine'' stabdymas
                break;
            case 9:
                //Įvedimo-išvedimo pertraukimas? -->Taip:10; Ne:14
                break;
            case 10:
                //Ar tai ivedimo pertraukimas? -->Taip:11, ne:12
                break;
            case 11:
                //Atlaisvinamas resursas ,,WaitingForInput''
                break;
            case 12:
                //Ar tai isvedimo pertraukimas? -->Taip:21, ne:7
                break;
            case 13:
                //Proceso ,,VirtualMachine'' aktyvavimas
                break;
            case 14:
                //Semaforo pertraukimas
                break;
            case 15:
                //Atlaisvinamas resursas ,,Sempahore''
                break;
            case 16:
                //Blokavimasis laukiant ,,FromMemoryGovernor'' resurso
                break;
            case 17:
                //Naikinamas procesas ,,VirtualMachine''
                break;
            case 18:
                //Atlaisvinamas resursas ,,UserMemory''
                break;
            case 19:
                //Atlaisvinamas resursas ,,TaskActivated''
                break;
            case 20:
                //Blokavimasis laukiant ,,UserInput'' resurso
                break;
            case 21:
                //Blokavimasis laukiant ,,FromOutput'' resurso
                break;
            default:
        }
    }
}
