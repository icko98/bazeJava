package main;

import java.util.Scanner;

import dto.Zad1dto;
import zadaci.zad1;
import zadaci.zad4;

public class ApplicationWinWin {

	

	public static void main(String[] args) {
		System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "WARN");
		
		
		
		
		
		zad1 zad1 = new zad1();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("ZADATAK 3:");
		zad1.zadJEDAN();
		
		
		System.out.println("ZADATAK 4:");
		zad4 zad4 = new zad4();
		zad4.zadCETIRI();
		
		System.out.println("ZADATAK 5:");
		
		String answer;
		answer = sc.nextLine();
		
		
		zad1.zadDVA(Integer.parseInt(answer));
		System.out.println("Printujemo opet zadatak 3 cisto radi provere");
		zad1.zadJEDAN();

	}

}
