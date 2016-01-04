/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.AbriBandeja;

/**
 *
 * @author Diogo
 */
import com.sun.jna.win32.StdCallLibrary;
public interface Winmm extends StdCallLibrary {
	void mciSendStringA(String command, int returnValue, int returnLength, int winHandle);
}
