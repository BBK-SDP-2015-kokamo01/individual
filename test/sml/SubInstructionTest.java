package sml;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;


public class SubInstructionTest {

    private Machine machine;
    private Registers registers;
    private Labels labels;

    @Before
    public void setUp() {
        machine = mock(Machine.class);

        labels = mock(Labels.class);
        registers = mock(Registers.class);


    }

    @Test
    public void shouldBeAbleToExecuteSubtractInstruction() {

        int register1 = 20;
        int register2 = 21;
        int resultRegister = 20;
        int val1 = 6;
        int val2 =1;
        int expected = val1 - val2;

        Instruction subInstruction = new SubInstruction("sub", resultRegister, register1, register2);

        when(machine.getRegisters()).thenReturn(registers);
        when(registers.getRegister(register1)).thenReturn(val1);
        when(registers.getRegister(register2)).thenReturn(val2);

        subInstruction.execute(machine);
        verify(registers).setRegister(resultRegister, expected);
    }
}
