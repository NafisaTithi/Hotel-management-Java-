import Entity.*;
import EntityList.*;
import Interface.*;


import GUI.*;

import java.lang.*;
import java.time.LocalDate;

public class Start{
    public static void main(String[] args) {
		
		EmployeeList emplist = new EmployeeList();
		CustomerList cuslist = new CustomerList();
		RoomList roomlist = new RoomList();
		
		Login login = new Login(emplist, cuslist, roomlist);
		
		
    }
}
