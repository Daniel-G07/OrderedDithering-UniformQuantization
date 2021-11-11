readme.txt file for CS4551 Homework 1
author: Guevara Daniel
CS4551 

Files in folder:
CS4551_Guevara
CS4551_Hw1Tasks

Compile requirement
======================================
JDK Version 7.0 or above

Compile Instruction on Command Line:
======================================
javac CS4551_Main.java MImage.java 
or 
javac *.java

Execution Instruction on Command Line:
======================================
java CS4551_Guevara [inputfile]
e.g.
java CS4551_Guevara Ducky.ppm

CS4551_Guevara: Contains a main method that runs full program.

CS4551_Hw1Tasks: Contains methods to help CS4551_Guevara run succesfully.
Following methods in CS4551_Hw1Tasks include:
public void grayScaleConversion(String im): concerts a 24-bit color image to 8-bit Gray-Scale.
public void grayScaleConversion1(String im): concerts a 24-bit color image to 8-bit Gray-Scale and returns the name of the finished file.
public void convertPixel(MImage img): Perfoms calculations for grayScaleConversion.
public void orderedDithering(String im, int k): Perfoms ordered dithering (k=4) on 8-bit grayscale image.
public void task3(String name): Generates and displays the 8-bit color LUT, converts the input 24-bit pixels to 8-bit indexed values and saves indexes in PPM format, saves the quantized RGB pixels in PPM format.
public int[][] generateLUT(): generates LUT for Task 3.
public void printLUT(int[][] lut): prints LUT to the console.
public int[] getColor(int index, int[][] lut): for each 8-bit index value of the input, retrieves its corresponding RGB value from the LUT. 



