package Processes;

class VirtualMachine extends ProcessDescriptor {
    public ProcessPriority priority;
    public ProcessState state;

    public void work() { /**Ar reikia to work*/
        switch (processCase) {
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
