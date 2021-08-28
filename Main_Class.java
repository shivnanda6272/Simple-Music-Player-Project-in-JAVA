package com.Shivnanda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

//import javax.swing.text.html.HTMLDocument.Iterator;

public class Main_Class {

	private static ArrayList<Album> albums = new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		private static ArrayList<Album> albums = new ArrayList<>();
		Album album = new Album("Album1", "AC/DC");
		
		album.addSong("TNT", 5.5);
		album.addSong("high to hell", 4.5);
		album.addSong("Thunderstruct", 5.0);
		albums.add(album);
		
		album = new Album("Album2", "Eminem");
		
		album.addSong("Rap God", 5.5);
		album.addSong("Not Afrain", 4.5);
		album.addSong("lose yourself", 3.5);
		
		albums.add(album);
		
		LinkedList<Song> playList_1 = new LinkedList<>();
		albums.get(0).addToPlayList("TNT",playList_1);
		albums.get(0).addToPlayList("Highway to hell",playList_1);
		albums.get(1).addToPlayList("rap god",playList_1);
		albums.get(1).addToPlayList("Lose yourself", playList_1);
		
		play(playList_1);
	}
	
	private static void play(LinkedList<Song> playList) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		boolean farword = true;
		ListIterator<Song> listiterator = playList.listIterator();
		if(playList.size() == 0) {
			System.out.println("This playList have no Song");
		}
		else {
			System.out.println("Now Playing" + listiterator.next().toString());
			printMenu();
		}
		
		while(!quit) {
			int action = sc.nextInt();
			sc.nextLine();
			
			switch(action) {
				
			case 0: 
				System.out.println("PlayList Complete");
				quit = true;
				break;
				
			case 1:
				if(farword) {
					if(listiterator.hasNext()) {
						listiterator.next();
					}
					farword = true;
				}
				if(listiterator.hasNext()) {
					System.out.print("Now Playing" +listiterator.next().toString());
				}
				else {
					System.out.println("No Song avilable reached to the end of the song");
					farword = false;
				}
				break;
				
			case 2:
				if(farword) {
					if(listiterator.hasPrevious()) {
						listiterator.previous();
					}
					farword = false;
				}
				if(listiterator.hasPrevious()) {
					System.out.println("Now playing "+listiterator.previous().toString());
				}
				else {
					System.out.println("We are at the first Song");farword = false;
				}
				break;
				
			case 3:
				if(farword) {
					if(listiterator.hasPrevious()) {
						System.out.println("Now playing "+listiterator.previous().toString());
						farword = false;
					}
					else {
						System.out.println("We are of the start of the list");
					}
				}
				else {
					if(listiterator.hasNext()) {
						System.out.println("Now Playing" +listiterator.next().toString());
						farword = true;
					}
					else {
						System.out.println("We have reached to the end of the List");
					}
				}
				break;
				
			case 4:
				printList(playList);
				break;
				
			case 5:
				printMenu();
				break;
				
			case 6:
				if(playList.size()>0) {
					listiterator.remove();
					if(listiterator.hasNext()) {
						System.out.println("Now playing" +listiterator.next().toString());
//						farword = true;
					}
					else {
						if(listiterator.hasPrevious()) {
							System.out.println("Now Playing " +listiterator.previous().toString());
						}
					}
				}
			}
		}
	}
	private static void printMenu() {
		System.out.println("Available Option\n press");
		System.out.println("0 - to Quit\n"+
							"1 - to Play the next Song \n"+
							"2 - to playing previous Song\n"+
							"3 - to Replay the current Song \n "+
							"4 - to List of all Songs\n"+
							"5 - Print all available option\n"+
							"6 - Delete current Song"
							);
		}
	
	private static void printList(LinkedList<Song> playList) {
		Iterator<Song> iterator = playList.iterator();
		
		System.out.println("--------------------------------");	
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	
		System.out.println("--------------------------------");
	}
}

