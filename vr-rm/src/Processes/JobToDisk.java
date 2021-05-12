package Processes;

class JobToDisk extends ProcessDescriptor{
    public ProcessPriority priority;
    public ProcessState state;
    public void work(){ /**Ar reikia to work*/
        switch (processCase){
            case 1:
                //Blokavimasis laukiant resurso ,,TaskInSuperMemory''
                break;
            case 2:
                //Blokavimasis laukiant resurso ,,TaskExecutionParmetersInSuperMemory''
                break;
            case 3:
                //Blokavimasis laukiant resurso ,,ExternalMemory''
                break;
            case 4:
                //Blokavimasis laukiant resurso ,,ChannelDevice''
                break;
            case 5:
                //Nustatinėjami kanalų įrenginio registrai
                break;
            case 6:
                //Atlaisvinamas resursas ,,ChannelDevice''
            case 7:
                //Atlaisvinamas resursas ,,TaskActivated''
            default:
        }
    }
}

