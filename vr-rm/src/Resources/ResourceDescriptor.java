package Resources;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class ResourceDescriptor {
    Queue<Process> queue = new LinkedList<Process>();
    void addToQueue(Process process){
        queue.add(process);
    }
}
public class Resource{
    public HashMap<UUID, ResourceDescriptor> resourceList = new HashMap<UUID, ResourceDescriptor>();
    class MOSEnd extends ResourceDescriptor{}
    class fromUserInterface extends ResourceDescriptor{}
    class Duomenu_vieta extends ResourceDescriptor{
        UUID id;
        //resurso elementai
        /** Duomenu_vieta resursas, mes jo neturim, ar reikia? Loader naudojamas**/
        Duomenu_vieta createResource(Process process){
            this.id = UUID.randomUUID(); //priskiriamas unikalus vidinis vardas
            resourceList.put(this.id, this); //pridedamas prie bendro resursu saraso
            /**Sukuriamas resurso elementu sarasas**/
            /**Sukuriami laukiančiųjų procesų sąrašai.**/
            return this; //grazinama, kad prisidetu prie tėvo sukurtų resursų sąrašo
        }
        void destroyResource(){
            /**Resurso deskriptorius išmetamas iš jo tėvų sukurtų resursų sąrašo**/
            this.queue = null; // naikinamas resurso elementų sąrašas
            /**atblokuojami naikinamo resurso laukiantys procesai**/
            resourceList.remove(this.id); //deskriptorius išmetamas iš bendro resursų sąrašo
            this.id = null; /**Deskriptorius sunaikinamas**/
        }
        void askForResource(Process process){
            /** Šį resurso primityvą iškvietęs procesas yra užblokuojamas ir įtraukiamas į resurso laukiančių
             *  procesų sąrašą. Šis primityvas kviečia resurso paskirstytoją.*/
             this.addToQueue(process);
        }
        void releaseResource(){
            /**Šį resurso primityvą iškvietęs procesas nori atlaisvinti atlaisvinti jam nereikalingą resursą
             * arba perduoti pranešimą kitam procesui. Resurso elementas resurso primityvui perduodamas
             * kaip funkcijos parametras, jis pridedamas prie resurso elementų sąrašo. Šio resurso primityvo
             * pabaigoje yra kviečiamas resursų paskirstytojas.**/
             }
    }

    class TaskInSuperMemory extends ResourceDescriptor{}
    class InfoAboutPaths extends ResourceDescriptor{}
    class ChannelDevice extends ResourceDescriptor{}
    class FromLoader extends ResourceDescriptor{}
    class LineInMemory extends ResourceDescriptor{}
    class WaitingForInput extends ResourceDescriptor{}
    class TaskExecutionParametersInSuperMemory extends ResourceDescriptor{}
    class ExternalMemory extends ResourceDescriptor{}
    class TaskActivated extends ResourceDescriptor{}
    class UserMemory extends ResourceDescriptor{}
    class FromInterrupt extends ResourceDescriptor{}
    class UserInput extends ResourceDescriptor{}
    class Semaphore extends ResourceDescriptor{}
    class FromMemoryGovernor extends ResourceDescriptor{}
    class Interrupt extends ResourceDescriptor{}
}





