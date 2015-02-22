package sml;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class AddInstructionTest {

    private Machine machine;
    private Registers registers;
    private Instruction addInstruction;
    private String label;
    private int register1;
    private int register2;
    private int resultRegister;

    @Before
    public void setUp() {
        machine = mock(Machine.class);
        registers = mock(Registers.class);

        label = "f0";
        register1 = 20;
        register2 = 21;
        resultRegister = 20;

        addInstruction = new AddInstruction(label, resultRegister, register1, register2);
    }

    @Test
    public void shouldBeAbleToExecuteSubtractInstruction() {
        int val1 = 6;
        int val2 = 1;
        int expected = val1 + val2;

        when(machine.getRegisters()).thenReturn(registers);
        when(registers.getRegister(register1)).thenReturn(val1);
        when(registers.getRegister(register2)).thenReturn(val2);

        addInstruction.execute(machine);
        verify(registers).setRegister(resultRegister, expected);
    }

    @Test
    public void shouldBeAbleToGetToString() {
        String expected = "f0: add" + " " + register1 + " + " + register2 + " output to register " + resultRegister;
        assertEquals(expected, addInstruction.toString());
    }
}
