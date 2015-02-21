package sml;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class SubInstructionTest {

    private Machine machine;
    private Registers registers;
    private Translator translator;
    private Labels labels;
    private String label;
    private int register;
    private int op1;
    private int op2;

    @Before
    public void setUp() {
        machine = mock(Machine.class);
        translator = mock(Translator.class);
        when(translator.readAndTranslate(mock(Labels.class), mock(ArrayList.class))).thenReturn(true);


        registers = mock(Registers.class);
        labels = mock(Labels.class);
        translator.readAndTranslate(machine.getLabels(), machine.getProg());

    }

    @Test
    public void shouldBeAbleToExecuteSubtractInstruction() {
        /*
        //Registers registers = mock(Registers.class);

        Registers nRegisters = new Registers();

        label = "f0";
        register = 20;
        op1 = 20;
        op2 = 22;
        Instruction subInstruction = new SubInstruction(label, register, op1, op2);

        //int value1 = machine.getRegisters().getRegister(op1);
        //int value2 = machine.getRegisters().getRegister(op2);
        when(machine.setRegisters());

        when(machine.getRegisters()).thenReturn(nRegisters);
        int value = nRegisters.getRegister(20);

        when(machine.getRegisters()).thenReturn(registers);
        int value2 = nRegisters.getRegister(22);

        //machine.getRegisters().setRegister(result, value1 - value2);
        when(machine.getRegisters()).thenReturn(registers);

        registers.setRegister(anyInt(),value-value2);

        subInstruction.execute(machine);

        System.out.println(registers);
        */
    }

}
