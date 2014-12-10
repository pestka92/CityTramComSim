/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exceptions;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author jaoles
 */
public class InproperTableIndexException extends Exception
{
    public InproperTableIndexException()
    {
        System.out.println("Nie prawidlowy indeks tablicy. Wykraczasz poza tablice.");
    }
}