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
enum ProcessPriority{
    JCL,
    JOB_TO_DISK,
    JOB_GOVERNOR,
    VIRTUAL_MACHINE,
    OUTPUT,
    INPUT,
    LOADER,
    READ_FROM_INTERFACE,
    MAIN_PROC,
    MEMORY_GOVERNOR,
    INTERRUPT,
    IDLE,
    START_STOP
}

public class ProcessDescriptor{
    public ProcessPlanner planner;

    public int processCase;
    public String id;
    public String state;
    public String parent;
    public int priority;

    /**Ar sarasams kuriam klases, ar listus*/
    public void work() {}; /**ar reikia?**/
    //public ArrayList<ProcessQ> children = new ArrayList<ProcessQ>(); /**man children pavad nepatinka*//
    public ArrayList<ResourceQueue> resources = new ArrayList<ResourceQueue>();

    public ProcessDescriptor() {}
    public ProcessDescriptor(String name, int priority, String parent, ProcessPlanner planner){
        //ProcesuSarasas ResursuSarasas resursai, VisuLaukianciuSarasas laukiantys, ResursuPrimityvai rveiksmai ){
        this.planner=planner;

        this.processCase= 0;
        this.state = "READY";
        setName(name);
        setPriority(priority);
        setParent(parent);


    }

    public void setName(String name){
        this.id=name;
    }

    public void setParent(String parent){
        this.parent=parent;
    }

    public void setPriority(int priority){
        this.priority=priority;
    }

}
/**
Išsiaiškinti kaip veikia, manau, kad
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
    private int descriptorSpace = 4;
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
         /**skaičiuojamas vidinis identifikacijos numeris
         process.children.clear();  //sukuriamas tuščias jo vaikų procesų sąrašas
         process.resources.clear(); //sukurtų resursų sąrašas
         planner();
    }
    /*public void killProcess(){
         for (int i = 0; i < process.children.size(); i++){ //pradedami naikinti proceso sukurti resursai ir vaikai.
         killProcess(process.children.get(i));
      }
        /*Procesas išmetamas iš tėvo
        sukurtų procesų sąrašo, iš bendro procesų sąrašo ir, jei reikia, iš pasiruošusių
        procesų sąrašo. Naikinami visi procesui perduoti resursai ir proceso deskriptorius.
    }
    public void stopProcess(){
       /* proceso būsena keičiama iš blokuotos į blokuotą sustabdytą
       arba iš pasiruošusios į pasiruošusią sustabdytą.
    }
    public void activateProcess(){
        /*proceso būsena keičiama iš blokuotos sustabdytos į blokuotą arba iš pasiruošusios
         sustabdytos į pasiruošusią.
    }
    public void planner(){
        /*Planuotojas atima procesorių iš proceso, peržvelgia pasiruošusių procesų sąrašą,
         išrenka planuotojo manymų tinkamiausią procesą ir perduoda procesorių procesui.
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


    public void createResource(Process self, String name){}
    public void destroyResource(Resource resource){}
    public void askForResource(Process self, Resource resource){}
    public void allocateResource(Resources resource, Resources element){}

    public void resourcesDistributor(){}


*/
