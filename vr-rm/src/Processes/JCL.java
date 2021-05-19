package Processes;

class JCL extends ProcessDescriptor{
    public ProcessPriority priority;
    public ProcessState state;
    public void work(){ /**Ar reikia to work*/
        switch (processCase){
            case 1:
                //Blokavimasis laukiant resurso ,,taskInSuperMemory’’ -
                break;
            case 2:
                //Programos sąrašo inicijavimas -
                break;
            case 3:
                //Imamas blokas iš supervizorinės atminties
                break;
            case 4:
                //Ar tai $STR blokas? ->Ne:5; Taip:6
                if (command == "$STR" ){this.processCase=6;}
                else this.processCase=5;
                break;
            case 5:
                //Atlaisvinti resursą ,,lineInMemory'' su pranešimu apie $STR bloko nebuvimą
                // virtualios mašinos programoje ir atminties tipu ,,Supervisor''
                break;
            case 6:
                //Ar $STR blokas korektiškas? --> Taip:8, Ne:7
                break;
            case 7:
                //Atlaisvinti resursą ,,lineInMemory'' su pranešimu apie $STR bloko nekorektiškumą
                // virtualios mašinos programoje ir atminties tipu ,,Supervisor''
                break;
            case 8:
                //Atlaisvinamas resursas ,,TaskExecuctionParametersInSuperMemory''
                break;
            case 9:
                //Imamas blokas iš supervizorinės atminties
                break;
            case 10:
                //Ar tai $END blokas arba nėra blokų? -->Taip:12; Ne:11
                break;
            case 11:
                //blokas prijungiamas prie programu saraso
                break;
            case 12:
                //Ar tai $END blokas? --->Taip:14; Ne:13
                if (command == "$END" ){this.processCase=14;}
                else this.processCase=13;
                break;
            case 13:
                //Atlaisvinti resursą ,,lineInMemory'' su pranešimu apie $END bloko nebuvimą
                // virtualios mašinos programoje ir atminties tipu ,,Supervisor''.
                break;
            case 14:
                //Ar programų sąrašas tuščias? ---> Taip: 16, ne: 15
                if (/*programų sąrašas tuščias*/){this.processCase=16;}
                else this.processCase=15;
                break;
            case 15:
                //Atlaisvinamas resursas ,,TaskInSuperMemory’’.
                break;
            case 16:
                //Atlaisvinamas resursas ,,lineInMemory'' su pranešimu apie programos nebuvimą ir
                // atminties tipu ,,Supervisor''
                break;
            default:
        }
    }
}
