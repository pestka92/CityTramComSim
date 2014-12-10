/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author jaoles
 */
public class KamienMilowyZaDuzoOdnogException extends Exception
{
    public KamienMilowyZaDuzoOdnogException()
    {
        System.out.println("Kamien milowy nie moze miec wiecej niz 2 odnogi!");
    }
}
