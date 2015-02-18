package sml;

import lombok.Data;

import java.util.ArrayList;
/*
 * The machine language interpreter
 */
@Data
public class Machine {
	// The labels in the SML program, in the order in which
	// they appear (are defined) in the program
	private Labels labels;

	// The SML program, consisting of prog.size() instructions, each
	// of class Instruction (or one of its subclasses)
	private ArrayList<Instruction> prog;

	// The registers of the SML machine
	private Registers registers;

	// The program counter; it contains the index (in prog) of
	// the next instruction to be executed.
	private int programCounter;

	{
		labels = new Labels();
		prog = new ArrayList<>();
		programCounter = 0;
	}

	public static void main(String[] args) {

		Machine machine = new Machine();
		Translator translator = new Translator(args[0]);
        translator.readAndTranslate(machine.getLabels(), machine.getProg());

        System.out.println("Here is the program; it has " + machine.getProg().size() + " instructions.");
		System.out.println(machine);

		System.out.println("Beginning program execution.");
		machine.execute();
		System.out.println("Ending program execution.");

		System.out.println("Values of registers at program termination:");
		System.out.println(machine.getRegisters() + ".");
    }

	// Print the program
	@Override
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i != getProg().size(); i++)
            stringBuffer.append(getProg().get(i) + "\n");
        return stringBuffer.toString();
	}

	// Execute the program in prog, beginning at instruction 0.
	// Precondition: the program and its labels have been store properly.
	public void execute() {
        this.setProgramCounter(0);
		setRegisters(new Registers());
		while (this.getProgramCounter() < getProg().size()) {
            Instruction ins = getProg().get(this.getProgramCounter());
			this.setProgramCounter(this.getProgramCounter() + 1);
            System.out.println("Executing: " + ins);
            ins.execute(this);
        }
	}
}
