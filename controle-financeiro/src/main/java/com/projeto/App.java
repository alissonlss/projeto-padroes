package com.projeto;

import com.SQLManager.*;

public class App 
{
    public static void main( String[] args )
    {
        SQLManager manager = SQLManager.getInstance();
        manager.mostrarClientes();
    }
}
