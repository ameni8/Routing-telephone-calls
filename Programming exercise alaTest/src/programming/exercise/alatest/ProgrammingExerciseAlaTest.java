/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package programming.exercise.alatest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author ameni
 */

public class ProgrammingExerciseAlaTest {


	public static void main(String[] args) throws FileNotFoundException, IOException {

		 File file = new File("newfile"); 
  
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  
  String st; 
  String operator=br.readLine();
            System.out.println(operator);
  //while ((st = br.readLine()) != null) 
    //System.out.println(st); 
  
  } 
} 

	


    

