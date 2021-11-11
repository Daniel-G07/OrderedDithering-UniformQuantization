
public class CS4551_Hw1Tasks {
	
	public void task3(String name) {
		int[][] lut = generateLUT();
		MImage img = new MImage(name);
		MImage outputimg = new MImage(img.getW(), img.getH());
		name = name.replace(".ppm", "");
		int[] rgb = new int[3];
		for (int y = 0; y < img.getH(); y++) { 
			for (int x = 0; x < img.getW(); x++) {
				img.getPixel(x, y, rgb);
				int red = rgb[0] >> 5;
				int green = rgb[1] >> 5;
				int blue = rgb[2] >> 6;
				int bitValue = (red << 5) | (green << 2) | blue;
				rgb[0] = rgb[1] = rgb[2] = bitValue;
				outputimg.setPixel(x, y, rgb);
			}
		}

		outputimg.write2PPM(name + "-index.ppm");

		MImage outputimg2 = new MImage(outputimg.getW(), outputimg.getH());

		int[] rgb2 = new int[3];
		for (int y = 0; y < img.getH(); y++) {
			for (int x = 0; x < img.getW(); x++) {
				outputimg.getPixel(x, y, rgb2);
				int index = rgb2[0];
				int[] newRGB = getColor(index, lut);
				outputimg2.setPixel(x, y, newRGB);
			}
		}

		outputimg2.write2PPM(name + "-QT8.ppm");
	}

	public int[] getColor(int index, int[][] lut) {
		int[] result = new int[3];
		for(int i = 0; i < lut.length; i++) {
			for(int j = 0; j < lut[i].length; j++) {
				if(index == i) {
					result[0] = lut[i][0];
					result[1] = lut[i][1];
					result[2] = lut[i][2];
				}
			}
		}
		return result;
	}

	public int[][] generateLUT() {
		int[][] lut = new int[256][3];
		for (int i = 0; i < 256; i++) {
			int red = i >> 5;
			int green = (i >> 2) & 7;
			int blue = i & 3;
			int redValue = red * 32 + 16;
			int greenValue = green * 32 + 16;
			int blueValue = blue * 64 + 32;
			lut[i][0] = redValue;
			lut[i][1] = greenValue;
			lut[i][2] = blueValue;
		}
		printLUT(lut);
		return lut;
	}

	public void printLUT(int[][] lut) {
		System.out.println("LUT by UCQ");
		System.out.println("Index R G B");
		System.out.println("---------------------");
		for (int i = 0; i < lut.length; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < lut[i].length; j++) {
				System.out.print(lut[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void orderedDithering(String im, int k) {
		MImage img = new MImage(im);
		int[] rgb = new int[3];
		int[][] ditheringMatrix = { { 0, 8, 2, 10 }, { 12, 4, 14, 6 }, { 3, 11, 1, 9 }, { 15, 7, 13, 5 } };
		for (int y = 0; y < img.getH(); y++) {
			for (int x = 0; x < img.getW(); x++) {
				img.getPixel(x, y, rgb);
				int pixel = rgb[0];
				int intensity = (int) (pixel * ((Math.pow(k, 2) + 1) / (256)));
				int[] black = { 0, 0, 0 };
				int[] white = { 255, 255, 255 };
				int i = y % k;
				int j = x % k;
				if (intensity > ditheringMatrix[i][j]) {
					img.setPixel(x, y, white);
				} else {
					img.setPixel(x, y, black);
				}
			}
		}
		im = im.replace(".ppm", "");
		img.write2PPM(im + "-0D4.ppm");
	}

	public void grayScaleConversion(String im) {
		MImage img = new MImage(im);
		convertPixel(img);
		im = im.replace(".ppm", "");
		img.write2PPM(im + "-gray.ppm");
	}

	public String grayScaleConversion1(String im) {
		MImage img = new MImage(im);
		convertPixel(img);
		im = im.replace(".ppm", "");
		String name = (im + "-gray.ppm");
		img.write2PPM(name);
		return name;
	}

	public void convertPixel(MImage img) {
		int[] rgb = new int[3];
		for (int y = 0; y < img.getH(); y++) {
			for (int x = 0; x < img.getW(); x++) {
				img.getPixel(x, y, rgb);
				int red = rgb[0];
				int green = rgb[1];
				int blue = rgb[2];
				int newRed = (int) (red * 0.299);
				int newBlue = (int) (green * 0.587);
				int newGreen = (int) (blue * 0.114);
				int grayScale = Math.round(newRed + newGreen + newBlue);
				int[] newRGB = { grayScale, grayScale, grayScale };
				img.setPixel(x, y, newRGB);
			}
		}
	}

}
