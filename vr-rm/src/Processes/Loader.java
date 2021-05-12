package Processes;

class Loader extends ProcessDescriptor{
    public ProcessPriority priority;
    public ProcessState state;
    public void work(){ /**Ar reikia to work*/
        switch (processCase){
            case 1:
                //Procesas pradeda savo darbą laukdamas ,,InfoAboutPaths’’ resurso iš JobGovernor proceso.
                // Resurse laikoma informacija apie išorinės atminties bei vartotojo atminties takelius.
                break;
            case 2:
                //Procesas laukia ,,ChannelDevice’’ resurso.
                break;
            case 3:
                //Procesas dirba su kanalų įrenginiu: nustato atitinkamus kanalų įrenginio registrus,
                // kiekvienam takeliui įvykdo komandą XCHG.
                break;
            case 4:
                //Resursas ,,ChannelDevice’’ atlaisvinamas.
                break;
            case 5:
                //Sukuriamas ir atlaisvinamas pranešimas JobGovernor procesui (resursas ,,FromLoader’’)
                break;
            default:
        }
    }
}
