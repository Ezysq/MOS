package Resources;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class ResourceQueue {
    Queue<Process> queue = new LinkedList<Process>();
    void addToQueue(Process process){
        queue.add(process);
    }
}
public class Resource{
    public HashMap<UUID, ResourceQueue> resourceList = new HashMap<UUID, ResourceQueue>();
    class MOSEnd extends ResourceQueue{}
    class fromUserInterface extends ResourceQueue{}
    class Duomenu_vieta extends ResourceQueue{
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

    class TaskInSuperMemory extends ResourceQueue{}
    class InfoAboutPaths extends ResourceQueue{}
    class ChannelDevice extends ResourceQueue{}
    class FromLoader extends ResourceQueue{}
    class LineInMemory extends ResourceQueue{}
    class WaitingForInput extends ResourceQueue{}
    class TaskExecutionParametersInSuperMemory extends ResourceQueue{}
    class ExternalMemory extends ResourceQueue{}
    class TaskActivated extends ResourceQueue{}
    class UserMemory extends ResourceQueue{}
    class FromInterrupt extends ResourceQueue{}
    class UserInput extends ResourceQueue{}
    class Semaphore extends ResourceQueue{}
    class FromMemoryGovernor extends ResourceQueue{}
    class Interrupt extends ResourceQueue{}
}





