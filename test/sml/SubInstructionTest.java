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
        
        Instruction subInstruction = new SubInstruction("sub", 20, 20, 21);

        when(machine.getRegisters()).thenReturn(registers);
        when(registers.getRegister(20)).thenReturn(6);

        when(registers.getRegister(22)).thenReturn(1);

        subInstruction.execute(machine);
        verify(registers).setRegister(20, 6);
    }
}
