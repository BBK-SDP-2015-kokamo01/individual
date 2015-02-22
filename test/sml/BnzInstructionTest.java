package sml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BnzInstructionTest {

    private Machine machine;
    private Registers registers;
    private Instruction bnzInstruction;
    private String label;
    private int register1;
    private String nextLabel;

    @Before
    public void setUp() {
        machine = mock(Machine.class);
        registers = mock(Registers.class);

        label = "f0";
        nextLabel = "f3";
        register1 = 20;

        bnzInstruction = new BnzInstruction(label, register1, nextLabel);
    }

    @Test
    public void shouldBeAbleToExecuteSubtractInstruction() {
        int pcVal = 6;

        Labels labels = mock(Labels.class);

        when(machine.getRegisters()).thenReturn(registers);
        when(registers.getRegister(register1)).thenReturn(register1);

        when(machine.getLabels()).thenReturn(labels);
        when(labels.indexOf(nextLabel)).thenReturn(pcVal);

        bnzInstruction.execute(machine);
        verify(machine).setProgramCounter(pcVal);
    }


    @Test
    public void shouldBeAbleToGetToString() {
        String expected = "f0: bnz " + "jump instruction to " + nextLabel;
        String actual = bnzInstruction.toString();

        assertEquals(expected, actual);
    }
}
