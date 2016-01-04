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

import java.util.InputMismatchException;
import java.util.Scanner;
import com.sun.jna.Native;
public class WinmmAbrir {
	static int op=1;
	public static void Abrir(){			
		Winmm openClose = (Winmm) Native.loadLibrary("winmm.dll", Winmm.class);	
			do{
								
				switch(op){
				case 1: 
					    openClose.mciSendStringA("Set cdaudio door open wait", 0, 0, 0);
		    	        System.out.println("\nGaveta Aberta...");
			            break;
				case 2:
			            openClose.mciSendStringA("Set cdaudio door closed wait", 0, 0, 0);
		    	        System.out.println("\nGaveta Fechada...");
		                break;
		        default:
		    	        break;		            
		       }	
				System.out.println();
		   }while(op < 1 || op > 2); 			
	}
}