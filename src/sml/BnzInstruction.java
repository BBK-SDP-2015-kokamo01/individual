package sml;

public class BnzInstruction extends Instruction {

    private String opcode;
    private  int register;

    public BnzInstruction(String label, String opcode) {
        super(label, opcode);
        this.opcode = super.opcode;
    }

    public BnzInstruction(String label, int register, String opcode) {
        this(label, "bnz");
        this.register = register;
        this.opcode = opcode;
    }

    @Override
    public void execute(Machine machine) {
        if (machine.getRegisters().getRegister(register) != 0) {
            Labels labels = machine.getLabels();
            int idx = labels.indexOf(opcode);
            machine.setProgramCounter(idx);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " jump instruction to " + opcode;
    }
}
