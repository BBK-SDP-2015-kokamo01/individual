package sml;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class SubInstructionTest {
    /**
    private Machine machine;
    private Registers registers;
    private Translator translator;
    private Labels labels;
    private String lable;
    private int register;
    private int op1;
    private int op2;

    @Before
    public void setUp() {
        machine = mock(Machine.class);
        registers = mock(Registers.class);
        translator = mock(Translator.class);
        labels = mock(Labels.class);
        translator.readAndTranslate(machine.getLabels(), machine.getProg());
        registers.setRegister(0, 5);
        registers.setRegister(1, 5);
    }

    @Test
    public void shouldBeAbleToExecuteSubtractInstruction() {

        Instruction sub = new SubInstruction(lable, register, op1, op2);

        when(translator.readAndTranslate(labels, (ArrayList<Instruction>) anyList())).thenReturn(true);
        sub.execute(machine);

        System.out.println(machine.getRegisters());
    }
    */
}
