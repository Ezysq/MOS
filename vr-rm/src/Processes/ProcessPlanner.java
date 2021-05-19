package Processes;

public class ProcessPlanner {
      /*Planuotojas atima procesorių iš proceso, peržvelgia pasiruošusių procesų sąrašą,
         išrenka planuotojo manymų tinkamiausią procesą ir perduoda procesorių procesui.*/
        switch(){
            case 1:
                //Ar einamasis procesas blokuotas? Taip ->2; Ne->3
                if (/*einmasis procesas blokuotas*/){this.processCase=2;}
                else this.processCase=3;
                break;
            case 2:
                //Einamasis procesas įtraukiamas į blokuotų procesų sąrašą;
                break;
            case 3:
                //Ar yra pasiruošusių procesų? Taip-->4, ne -->7
                if (/*yra pasiruosusiu procesu*/){this.processCase=4;}
                else this.processCase=7;
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
