import java.util.Scanner;

public class CS4551_Guevara {
	public static void main(String[] args) {
		// the program expects one command line argument
		// if there is no command line argument, exit the program
		if (args.length != 1) {
			usage();
			System.exit(1);
		}

		System.out.println("--Welcome to Multimedia Software System--");

		// Create an Image object with the input PPM file name.
		MImage img = new MImage(args[0]);
		// Save it into another PPM file.
		img.write2PPM("out.ppm");
		// Save it into another PPM file.
		String name = args[0];
		Scanner in = new Scanner(System.in);
		CS4551_Hw1Tasks tasks = new CS4551_Hw1Tasks();
		boolean active = true;
		while (active) {
			System.out.println("1. Conversion to Gray-scale Image (24bits->8bits)");
			System.out.println("2. Conversion to Binary Image using Ordered Dithering (k=4)");
			System.out.println("3. Conversion to 8bit Indexed Color Image using Uniform Color Quantization (24bits->8bits)");
			System.out.println("4. Quit");
			System.out.println("Please enter the task number [1-4]:");
			int command = in.nextInt();
			switch (command) {
			case 1:
				tasks.grayScaleConversion(name);
				break;
			case 2:
				String n = tasks.grayScaleConversion1(name);
				tasks.orderedDithering(n, 4);
				break;
			case 3:
				tasks.task3(name);
				break;
			case 4:
				active = false;
				break;
			}

		}
		System.out.println("--Good Bye--");
	}

	public static void usage() {
		System.out.println("\nUsage: java CS4551_Main [input_ppm_file]\n");
	}

}
