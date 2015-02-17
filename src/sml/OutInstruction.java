package sml;

public class OutInstruction extends Instruction {

    private int result;

    public OutInstruction(String label, String opcode) {
        super(label, opcode);
    }

    public OutInstruction(String label, int result) {
        this(label, "out");
        this.result = result;
    }

    @Override
    public void execute(Machine machine) {
        int output = machine.getRegisters().getRegister(result);
        System.out.println("output is: " + output);
    }

    @Override
    public String toString() {
        return super.toString() + " output to register " + result;
    }
}
