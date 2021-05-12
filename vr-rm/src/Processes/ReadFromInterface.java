package Processes;

class ReadFromInterface extends ProcessDescriptor{
    public ProcessPriority priority;
    public ProcessState state;
    public void work(){ /**Ar reikia to work*/
        switch (processCase){
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

