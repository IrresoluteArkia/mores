package com.irar.mores.name;

import java.util.Random;

public class AlloyName {
	private static String getPre(Random r){

		String[] all=new String[] {"Ja", "Re", "Ra", "Ro", "Ru", "Je", "Jo", "Ar", "Ath", "Ad", "By", "Br", "Be", "Ca", "Chr", "Cr", "Do", "Di", "Em", "Ed", "Fa", "Fe", "Fl", "Ga", "Gi", "Ha", "He", "Hi", "I", "Iv", "Ka", "Ke", "Kim", "La", "Li", "Lo", "Ma", "Mi", "My", "No", "Na", "Ni", "Oc", "Or", "Ow", "Pu", "Pa", "Pe", "Qu", "Sa", "Sh", "So", "Tr", "Ta", "Te", "Ul", "Ul", "Vi", "Wa", "Wi", "Wy", "Xa", "Xy", "Yu", "Yo", "Za", "Zo"};

		return all[r.nextInt(all.length)];

	}

	private static String getMid(Random r){

		String[] all= new String[] {"co", "be", "k", "ch", "n", "ni", "f", "se", "de", "ri", "an", "do", "ia", "th", "le", "is", "ti", "u", "re", "va", "il", "wa", "lic", "i", "br", "de", "l", "la", "or", "ur", "ga", "di", "cha", "co", "ta", "bli", "me", "ne", "lo", "as", "au", "lo", "ac", "bi", "d", "ys", "c", "k", "l", "li", "at", "vi", "bri", "ra"};

		return all[r.nextInt(all.length)];

	}

	private static String getSuf(Random r){

		String[] all=new String[] {"b", "ah", "el", "se", "by", "er", "ph", "ia", "nt", "na", "om", "y", "an", "el", "ny", "rt", "rd", "ye", "ith", "on", "ey", "en", "ry", "ke", "vy", "ani", "rly", "th", "n", "son", "rna", "ra", "ko", "le", "via", "us", "la", "pe", "ar", "ber", "na", "mon", "y", "tha", "ses", "ric", "tor", "de", "am", "t", "er", "a", "ri", "rk", "na"};

		return all[r.nextInt(all.length)];

	}

	private static String getRandomNameN(Random r){

		String name = "";

		int vowel = r.nextInt(2);

		int apostrophe = 0;

		name += getPre(r);

		for(int i = 0; vowel < 10; i++){

			int x = r.nextInt(3);

			if(apostrophe != 1 && r.nextInt(100) == 1){

				name += "'";

				apostrophe = 1;

			}else if(x < i && name.toCharArray()[name.toCharArray().length-1] != '\''){

				vowel = 10;

			}else{

				name += getMid(r);

			}

		}

		name += getSuf(r);

		return name;

	}

	private static String getUppercaseConsonant(Random r){

		String[] all=new String[] {"B","C","D","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Z", "Sh", "Ts","Y"};

		return all[r.nextInt(all.length)];

	}

	private static String getLowercaseConsonant(Random r){

		String[] all=new String[] {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","z", "sh", "ts","y"};

		return all[r.nextInt(all.length)];

	}

	private static String getUppercaseVowel(Random r){

		String[] all=new String[] {"A","E","I","O","U"};

		return all[r.nextInt(all.length)];

	}

	private static String getLowercaseVowel(Random r){

		String[] all=new String[] {"a","e","i","o","u"};

		return all[r.nextInt(all.length)];

	}

	private static String getRandomNameJ(Random r){

		String name="";

		int vowel=r.nextInt(2);

		int apostrophe=0;

		if(vowel==0){

			name+=getUppercaseConsonant(r);

			vowel=1;

//			if(getRandom(2)==1){

//				vowel=2;

//			}

		}else{

			name+=getUppercaseVowel(r);

			vowel=0;

			if(r.nextInt(2) == 1){

				vowel=3;

			}

		}

		for(int i=0;vowel<10;i++){

			int x=r.nextInt(10) + 1;

			if(apostrophe != 1 && r.nextInt(100)==1){

//				name+="'";

//				apostrophe=1;

			}else if(x<=i && name.charAt(name.length() - 1) != '\'' && (vowel == 0 || vowel == 3)){

				vowel=10;

			}else{

				if(vowel==0 || vowel==2){

					name+=getLowercaseConsonant(r);

					vowel=1;

				}else{

					name+=getLowercaseVowel(r);

					vowel=0;

					if(r.nextInt(2)==1 && vowel==1){

						vowel=3;

					}

				}

			}

		}

		return name;

	}

	public static String getRandomName(Random r){

		if(r.nextInt(2) == 1){

			return getRandomNameJ(r);

		}else{

			return getRandomNameN(r);

		}

	}

}
