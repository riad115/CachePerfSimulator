package com.test.CachePerfSimulator;

import java.io.BufferedReader;
import java.io.FileReader;

public class CachePerfSimulator {

	/**
	 * @param args
	 */
	public static int cacheCapacity;
	public static int associativity;
	public static int blocksize;
	public static int nblks;
	public static int nsets;
	public static int offsetbits;
	public static int setbits; //index bits
	public static int tagbits;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readConfigFile(args[0]);
		System.out.println(cacheCapacity);
		System.out.println(blocksize);
		System.out.println(associativity);

	}
	
	
	public static void readConfigFile(String filename){
		String line = null;
		try {
	        BufferedReader reader = new BufferedReader(new FileReader(filename));
	        while((line = reader.readLine()) != null){
	        	if ( line.trim().length() == 0 ) {  
	        		continue;  // Skip blank lines  
	        	}
	        	String[] vals = line.split("\\=");
	        	if(vals[0].equalsIgnoreCase("Cache Size")){
	        		cacheCapacity = Integer.parseInt(vals[1]);
	        	}
	        	
	        	if(vals[0].equalsIgnoreCase("Block Size")){
	        		blocksize = Integer.parseInt(vals[1]);
	        	}
	        	
	        	if(vals[0].equalsIgnoreCase("Associativity")){
	        		associativity = Integer.parseInt(vals[1]);
	        	}
	        	//for(int i=0;i<vals.length;i++){
        			//System.out.println(vals[i]);
        	    //}
	        }
	        
	        reader.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		
		nblks = cacheCapacity / blocksize ; 
		nsets = cacheCapacity / (associativity * blocksize );
		offsetbits = (int) Math.log(blocksize);
		setbits = (int) Math.log(nsets);
		tagbits = 32 - (offsetbits + setbits);
		
	}
}
