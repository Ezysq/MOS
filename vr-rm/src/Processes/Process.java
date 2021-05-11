package Processes;

import Resources.ResourceQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

enum ProcessState{
    RUNNING,
    WAITING, //blokuotas
    WAITING_STOPPED, //blokuotas sustabdytas
    READY_STOPPED,   //pasiruošęs sustabdytas
    READY
}
/**Kodel tokia tvarka? Kur dėti JCL, JOB_TO_DISK, IDLE?*/
enum ProcessPriority{
    JOB_GOVERNOR,
    VIRTUAL_MACHINE,
    OUTPUT,
    INPUT,
    LOADER,
    READ_FROM_INTERFACE,
    MAIN_PROC,
    MEMORY_GOVERNOR,
    INTERRUPT,
    IDLE /**?*/,
    START_STOP
}

class ProcessQ{
    public ProcessState state;
    public void work() {}; /**ar reikia?**/
    public ArrayList<ProcessQ> children = new ArrayList<ProcessQ>(); /**man children pavad nepatinka*//
    public ArrayList<ResourceQueue> resources = new ArrayList<ResourceQueue>();
}

/** Išsiaiškinti kaip veikia, manau, kad */
class ProcessComparator implements Comparator<ProcessQ> {
    @Override
    public int compare(ProcessQ p1, ProcessQ p2) {
        if (p1.state.ordinal() < p2.state.ordinal())
            return 1;
        else if (p1.state.ordinal() > p2.state.ordinal())
            return -1;
        return 0;
    }
}

public class Process {
    private ArrayList<ProcessQ> runningProcesses = new ArrayList<ProcessQ>();
    private PriorityQueue<ProcessQ> blocked = new PriorityQueue<ProcessQ>(5, new ProcessComparator());
    private PriorityQueue<ProcessQ> ready = new PriorityQueue<ProcessQ>(5, new ProcessComparator());
    private ProcessQ current; //einamasis procesas
    private int descriptorSpace = 4; /** kiek */
    private int[] descriptor = new int[descriptorSpace];

    public ProcessQ newInstance(String externalName){
        Class<?> process = null;
        try {
            process = Class.forName(externalName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (!ProcessQ.class.isAssignableFrom(process)) {
            throw new IllegalArgumentException();
        }
        return (ProcessQ) newInstance(externalName);
    }

    public void createProcess(ProcessQ parent, ProcessState initialState, ProcessPriority priority,
                              ArrayList<String> elements, String externalName){
         ProcessQ process = newInstance(externalName);//sukuriamas procesas
         runningProcesses.add(process); //registruojamas bendrajame procesų sąraše
         parent.children.add(process);  //registruojamas tėvo-sūnų sąraše
         /**skaičiuojamas vidinis identifikacijos numeris*/
         process.children.clear();  //sukuriamas tuščias jo vaikų procesų sąrašas
         process.resources.clear(); //sukurtų resursų sąrašas
         planner();
    }
    /*public void killProcess(){
         for (int i = 0; i < process.children.size(); i++){ //pradedami naikinti proceso sukurti resursai ir vaikai.
         killProcess(process.children.get(i));
      }*/
        /*Procesas išmetamas iš tėvo
        sukurtų procesų sąrašo, iš bendro procesų sąrašo ir, jei reikia, iš pasiruošusių
        procesų sąrašo. Naikinami visi procesui perduoti resursai ir proceso deskriptorius. */
    }
    public void stopProcess(){
       /* proceso būsena keičiama iš blokuotos į blokuotą sustabdytą
       arba iš pasiruošusios į pasiruošusią sustabdytą. */
    }
    public void activateProcess(){
        /*proceso būsena keičiama iš blokuotos sustabdytos į blokuotą arba iš pasiruošusios
         sustabdytos į pasiruošusią.*/
    }
    public void planner(){
        /*Planuotojas atima procesorių iš proceso, peržvelgia pasiruošusių procesų sąrašą,
         išrenka planuotojo manymų tinkamiausią procesą ir perduoda procesorių procesui. */
        switch(){
            case 1:
                //Ar einamasis procesas blokuotas? Taip ->2; Ne->3
                break;
            case 2:
                //Einamasis procesas įtraukiamas į blokuotų procesų sąrašą;
                break;
            case 3:
                //Ar yra pasiruošusių procesų? Taip-->4, ne -->7
                break;
            case 4:
                //Imamas pirmas pasiruošęs aukščiausio prioriteto procesas
                break;
            case 5:
                //Valdymas perduodamas paimtam procesui
                break;
            case 6:
                //Vykdomas procesas
                break;
            case 7:
                //Atlaisvinams resursas ,,Idle''
                break;
            default:
        }
    }

    /*
    public void createResource(Process self, String name){}
    public void destroyResource(Resource resource){}
    public void askForResource(Process self, Resource resource){}
    public void allocateResource(Resources resource, Resources element){}
     */
    public void resourcesDistributor(){}

    class StartStop extends ProcessQ{
        public ProcessPriority priority;
        public ProcessState state;
        public void work(){ /**Ar reikia to work*/
            switch (){
                case 1:
                    //Sisteminių procesų inicializacija - procesui gavus procesorių
                    // ir pradėjus darbą sukuriami visi sisteminiai resursai.

                    break;
                case 2:
                    //Sisteminių permanentinių procesų inicializacija - sukuriami procesai,
                    // kurie būna aktyvūs visą MOS gyvavimo laiką (t.y. permanentiniai procesai).
                    break;
                case 3:
                    //Blokavimas laukiant ,,MOSEnd” resurso - prašoma resurso ,,MOSEnd”. Procesas
                    // StartStop blokuojasi ir laukia, kol bus atlaisvintas pranešimas apie MOS darbo pabaigą.
                    break;
                case 4:
                    //Sisteminių procesų naikinimas - sunaikinami visi sistemoje esantys procesai.
                    break;
                case 5:
                    //Sisteminių resursų naikinimas - sunaikinami visi sistemoje esantys resursai.
                    break;
                default:
            }
        }
    }

    class ReadFromInterface extends ProcessQ{
        public ProcessPriority priority;
        public ProcessState state;
        public void work(){ /**Ar reikia to work*/
            switch (){
                case 1:
                   //Blokavimas laukiant resurso ,,FromUserInterface’’ - laukiama įvedimo
                    // srauto (failo pavadinimas, kuriame ir yra vartotojiška programa).
                    break;
                case 2:
                   //Failo nuskaitymas ir suskaldymas blokais. Apdorojimo rezultatas - blokų sąrašas.
                    break;
                case 3:
                    //Blokavimas laukiant supervizorinės atminties resurso.
                    break;
                case 4:
                    //Blokų kopijavimas į supervizorinę atmintį - gavus supervizorinės atminties
                    // resursą, blokų sąrašas kopijuojamas atmintin.
                    break;
                case 5:
                    //Atlaisvinamas resursas ,,TaskInSuperMemory’’, skirtas procesui JCL - šiame
                    // resurse yra informacija apie blokų padėtį atmintyje.
                    break;
                default:
            }
        }
    }

    class Loader extends ProcessQ{
        public ProcessPriority priority;
        public ProcessState state;
        public void work(){ /**Ar reikia to work*/
            switch (){
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

    class JCL extends ProcessQ{
        public ProcessPriority priority;
        public ProcessState state;
        public void work(){ /**Ar reikia to work*/
            switch (){
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
                    break;
                case 13:
                    //Atlaisvinti resursą ,,lineInMemory'' su pranešimu apie $END bloko nebuvimą
                    // virtualios mašinos programoje ir atminties tipu ,,Supervisor''.
                    break;
                case 14:
                    //Ar programų sąrašas tuščias? ---> Taip: 16, ne: 15
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
    class JobToDisk extends ProcessQ{
        public ProcessPriority priority;
        public ProcessState state;
        public void work(){ /**Ar reikia to work*/
            switch (){
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
    class MainProc extends ProcessQ {
        public ProcessPriority priority;
        public ProcessState state;

        public void work() { /**Ar reikia to work*/
            switch () {
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

    class JobGovernor extends ProcessQ{
        public ProcessPriority priority;
        public ProcessState state;
        public void work(){ /**Ar reikia to work*/
            switch (){
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
    class VirtualMachine extends ProcessQ {
        public ProcessPriority priority;
        public ProcessState state;

        public void work() { /**Ar reikia to work*/
            switch () {
                case 1:
                    //Procesorius perjungiamas į vartotojo režimą virtualios mašinos darbo pradžioje.
                    break;
                case 2:
                    //Vykdyma vartotojo programa
                    break;
                case 3:
                    //Apdorojus pertraukimą, atlaisvinamas resursas ,,Interrupt''
                    break;
                default:
            }
        }
    }
    class Interrupt extends ProcessQ {
        public ProcessPriority priority;
        public ProcessState state;

        public void work() { /**Ar reikia to work*/
            switch () {
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
    class MemoryGovernor extends ProcessQ {
        public ProcessPriority priority;
        public ProcessState state;

        public void work() { /**Ar reikia to work*/
            switch () {
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
    class Input extends ProcessQ {
        public ProcessPriority priority;
        public ProcessState state;

        public void work() { /**Ar reikia to work*/
            switch () {
                case 1:
                    //Blokavimas laukiant ,,WaitingForInput'' resurso
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
                    //Sukuriamas ir atlaisvinamas resursas ,,UserInput''
                default:
            }
        }
    }
    class Output extends ProcessQ{
        public ProcessPriority priority;
        public ProcessState state;

        public void work() { /**Ar reikia to work*/
            switch () {
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
    class Idle extends ProcessQ{
        //procesas stabdomas laukiant resurso ,,Idle''
    }
}
