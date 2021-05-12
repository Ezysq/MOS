package Processes;

class StartStop extends ProcessDescriptor{
    public ProcessPriority priority;
    public ProcessState state;
    public void work(){ /**Ar reikia to work*/
        switch (processCase){
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

