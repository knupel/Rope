/**
	* ROPE - ROmanesco Processing Environment – 
	* Copyleft (c) 2014-2019
	* Variable shared throughout rope.core.
	* Rope Constants Colour
	* v 0.0.3
	* Processing 3.5.4
	* @author @stanlepunk
	* @see https://github.com/StanLepunK/Rope
	* @see https://fr.wikipedia.org/wiki/Liste_de_noms_de_couleur
	*/

package rope.core;

public interface R_Constants_Colour {

	static final int RGB   = 1;  // image & color // processing value
	static final int ARGB  = 2;  // image // processing value
	static final int RGBA  = 2;  // image // processing value
	static final int HSB   = 3;  // color // processing value
	static final int ALPHA = 4;  // image // processing value

	
	static final int HUE = 50;
	static final int SATURATION = 51;
	static final int BRIGHTNESS = 52;
		
	static final int RAINBOW = 61;
	static final int SPECTRUM = 62;
	static final int PALETTE = 63;

	static final int GRADIENT = 70;
	static final int GRADIENT_HUE = 71;
	static final int GRADIENT_SATURATION = 72;
	static final int GRADIENT_BRIGHTNESS = 73;
	
	
	

	static final String ANSI_RESET = "\u001B[0m";
	static final String ANSI_BLACK = "\u001B[30m";
	static final String ANSI_RED = "\u001B[31m";
	static final String ANSI_GREEN = "\u001B[32m";
	static final String ANSI_YELLOW = "\u001B[33m";
	static final String ANSI_BLUE = "\u001B[34m";
	static final String ANSI_PURPLE = "\u001B[35m";
	static final String ANSI_CYAN = "\u001B[36m";
	static final String ANSI_WHITE = "\u001B[37m";
	/**
	* System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
	*/

	static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";



	static final int BLACK = -16777216;
	static final int NOIR = -16777216;
	static final int WHITE = -1;
	static final int BLANC = -1;

	// LUNE > #F4FEFE > 0.5 , 0.03937008 , 0.99607843
	static final int LUNE = -721154;
	static final int MOON = -721154;
	// LIN > #FAF0E6 > 0.083333336 , 0.08 , 0.98039216
	static final int LIN = -331546;

  // ARGENT > #C0C0C0 > 0.0 , 0.0 , 0.7529412;
	static final int ARGENT = -4144960;
	static final int SILVER = -4144960;
	// PERLE > #CECECE > 0.0 , 0.0 , 0.80784315;
	static final int PERLE = -3223858;
	// SOURIS > #9E9E9E > 0.0 , 0.0 , 0.61960787
	static final int SOURIS = -6381922;
	// PAYNE > #677179 > 0.5740741 , 0.14876033 , 0.4745098
	static final int PAYNE = -9997959;
	// COLOMBIN > #BBACAC > 0.0 , 0.080213904 , 0.73333335
	static final int COLOMBIN = -4477780;
	// VERT_DE_GRIS > #95A595 > 0.33333334 , 0.096969694 , 0.64705884
	static final int VERT_DE_GRIS = -6969963;

	// static final int GRAY = 4050 ; // this GRAY already existe
	static final int GRAY_MEDIUM = -8421505;
	// static final int GRIS = -8421505;
	static final int GRIS_MOYEN = -8421505;
	
	static final int [] GRAY = {
		-15790321,-15132391,-14474461,-13816531,-12961222,
		-12105913,-11250604,-10263709,-9276814,-8421505,
		-7566196,-6710887,-5921371,-5066062,-4210753,
		-3355444,-2697514,-2039584,-1381654,-723724
	};
	static final int [] GRIS = {
		-15790321,-15132391,-14474461,-13816531,-12961222,
		-12105913,-11250604,-10263709,-9276814,-8421505,
		-7566196,-6710887,-5921371,-5066062,-4210753,
		-3355444,-2697514,-2039584,-1381654,-723724
	};

  /*
  HSB,1,1,1
  --
  GRAY[0] > 0,0,0.06 > int = -15790321
	GRAY[1] > 0,0,0.1 >  int = -15132391
	GRAY[2] > 0,0,0.14 > int = -14474461
	GRAY[3] > 0,0,0.18 > int = -13816531
	GRAY[4] > 0,0,0.23 > int = -12961222
	GRAY[5] > 0,0,0.28 > int = -12105913
	GRAY[6] > 0,0,0.33 > int = -11250604
	GRAY[7] > 0,0,0.39 > int = -10263709
	GRAY[8] > 0,0,0.45 > int = -9276814
	GRAY[9] > 0,0,0.5 > int = -8421505
	GRAY[10] > 0,0,0.55 > int = -7566196
	GRAY[11] > 0,0,0.6 > int = -6710887
	GRAY[12] > 0,0,0.65 > int = -5921371
	GRAY[13] > 0,0,0.7 > int = -5066062
	GRAY[14] > 0,0,0.75 > int = -4210753
	GRAY[15] > 0,0,0.8 > int = -3355444
	GRAY[16] > 0,0,0.84 > int = -2697514
	GRAY[17] > 0,0,0.88 > int = -2039584
	GRAY[18] > 0,0,0.92 > int = -1381654
	GRAY[19] > 0,0,0.96 > int = -723724
	*/

	// ROUGE > HSB,1,1,1 > color(0,1,1);
	static final int RED = -65536;
	static final int ROUGE = -65536;
	// AMARANTE > #91283B > 0.96984124 , 0.7241379 , 0.5686275
	static final int AMARANTE = -7264197;
	// VERMILLON > #DB1702 > 0.016129037 , 0.99086756 , 0.85882354
	static final int VERMILLON = -2418942;
	// CERISE > #BB0B0B > 0.0 , 0.9411765 , 0.73333335
	static final int CERISE = -4519157;
	// BLOOD > #850606 > 0.0 , 0.9548872 , 0.52156866
	static final int BLOOD = -8059386;
	static final int SANG = -8059386; 
	// CARMINE  > color(0,1,.55);
	static final int CARMINE = -7602176;
	static final int CARMIN = -7602176; 
	// GRENAT > #6E0B14 > 0.9848485 , 0.9 , 0.43137255
	static final int GRENAT = -9565420;
	// BRIQUE > #842E1B > 0.030158728 , 0.79545456 , 0.5176471
	static final int BRIQUE = -8114661;
	// GUEULES > #E21313 > 0.0 , 0.9159292 , 0.8862745
	static final int GUEULES = -1961197;
	// POURPRE > #9E0E40 > 0.9421296 , 0.9113924 , 0.61960787
	static final int POURPRE = -6418880;


	// MARRON > CAFE > #462E01 > 0.10869565 , 0.98571426 , 0.27450982
	static final int MARRON = -12177919;
	static final int BROWN = -12177919;
	static final int CAFE = -12177919;
	static final int COFFEE = -12177919;
	// NOISETTE > #955628 > 0.070336394 , 0.7315436 , 0.58431375
	static final int NOISETTE = -6990296;
	// BIS > #766F64 > 0.10185185 , 0.15254237 , 0.4627451
	static final int BIS = -9015452;
	// BISTRE > #856D4D > 0.09523809 , 0.42105263 , 0.52156866
	static final int BISTRE = -8032947;
	// CHOCOLAT > #5A3A22 > 0.07142857 , 0.62222224 , 0.3529412
	static final int CHOCOLAT = -10864094;
	// SEPIA > #AE8964 > 0.083333336 , 0.42528737 , 0.68235296
	static final int SEPIA = -5338780;
	// SHAKUDOU > #752100 > 0.047008544 , 1.0 , 0.45882353
	static final int SHAKUDOU = -9101056;
	// TAUPE > #463F32 > 0.10833333 , 0.2857143 , 0.27450982
	static final int TAUPE = -12173518;
	// CANELLE > #7E5835 > 0.07990868 , 0.5793651 , 0.49411765
	static final int CANELLE = -8497099;
	// BRONZE > #614E1A > 0.12206572 , 0.73195875 , 0.38039216
	static final int BRONZE = -10400230;
	// CHAMOIS > #D0C07A > 0.13565892 , 0.41346154 , 0.8156863
	static final int CHAMOIS = -3096454;
	// ACAJOU > #88421D > 0.057632398 , 0.7867647 , 0.53333336
	static final int ACAJOU = -7847395;

  
  // ORANGE  > color(.08,1,1);
	static final int ORANGE = -34304;
	// ABRICOT > #E67E30 > 0.07142857 , 0.79130435 , 0.9019608
	static final int ABRICOT = -1671632;
	// MANDARINE > #FEA347 > 0.083788715 , 0.72047246 , 0.99607843
	static final int MANDARINE = -89273;
	// CAROTTE  > #F4661B > 0.057603687 , 0.8893443 , 0.95686275
	static final int CAROTTE = -760293;
	// CITROUILLE  > #DF6D14 > 0.07307061 , 0.9103139 , 0.8745098
	static final int CITROUILLE = -2134764;
	// CORAIL  > #E73E01 > 0.044202894 , 0.995671 , 0.90588236
	static final int CORAIL = -1622527;
	// OCRE  > #DD985C > 0.07751938 , 0.58371043 , 0.8666667 > ocre_rouge officiel but my feeling is not
	static final int OCRE = -2254756;
	// OCRE_ROUGE > 0.02020202 , 0.58235294 , 0.6666667
	static final int OCRE_ROUGE = -5614777;


	// JAUNE > color(0.166 1.0 1.0);
	static final int YELLOW = -256;
	static final int JAUNE = -256;
	// OCRE_JAUNE  > #DFAF2C > 0.12197393 , 0.80269057 , 0.8745098
	static final int OCRE_JAUNE = -2117844;
	// OR  > color(0.12 1.0 1.0);
	static final int OR = -20736;
	static final int GOLD = -20736;
	// MIMOSA > #FEF86C > 0.15981735 , 0.5748032 , 0.99607843
	static final int MIMOSA = -67476;
	// NAPLE > #FFF0BC > 0.12935324 , 0.2627451 , 1.0
	static final int NAPLE = -3908;
	// NANKIN > #F7E269 > 0.14201878 , 0.5748988 , 0.96862745
	static final int NANKIN = -531863;
	// BLOND > #E2BC74 > 0.1090909 , 0.48672566 , 0.8862745
	static final int BLOND = -1917836;
	// AMBRE > #F0C300 > 0.13541667 , 1.0 , 0.9411765
	static final int AMBRE = -998656;




	// VERT  > color(0.333 1.0 1.0);
	static final int GREEN = -16711936;
	static final int VERT = -16711936;
	// PISTACHE > #BEF574 > 0.23772609 , 0.5265306 , 0.9607843
	static final int PISTACHE = -4262540;
	// BOUTEILLE > #096A09 > 0.33333334 , 0.9150943 , 0.41568628
	static final int BOUTEILLE = -16160247;
	// SAPIN > #095228 > 0.4041096 , 0.8902439 , 0.32156864
	static final int SAPIN = -16166360;
	// IMPERIAL > #00561B > 0.3856589 , 1.0 , 0.3372549
	static final int IMPERIAL = -16755173;
	// VESSIE > #22780F > 0.30317461 , 0.875 , 0.47058824
	static final int VESSIE = -14518257;
	// SINOPLE > #149414 > 0.33333334 , 0.8648649 , 0.5803922
	static final int SINOPLE = -15428588;
	// OLIVE > #708D23 > 0.21226414 , 0.75177306 , 0.5529412
	static final int OLIVE = -9401053;
	// SAUGE > #689D71 > 0.3616352 , 0.3375796 , 0.6156863
	static final int SAUGE = -9921167;
	// TILLEUL > #A5D152 > 0.22440946 , 0.6076555 , 0.81960785
	static final int TILLEUL = -5910190;
	// CANARD >  #048B94 > 0.5104167 , 0.972973 , 0.5803922
	static final int CANARD = -16479340;
	// LIME > #9EFD38 > 0.24703892 , 0.7786561 , 0.99215686
	static final int LIME = -6357704;
	// PERROQUET > #3AF24B > 0.34873188 , 0.76033056 , 0.9490196
	static final int PERROQUET = -12914101;
	// VERT_D_EAU > #B0F2B6 > 0.34848484 , 0.27272728 , 0.9490196
	static final int VERT_D_EAU = -5180746;
	// CHARTREUSE > #7FFF00 > 0.25032678 , 1.0 , 1.0
	static final int CHARTREUSE = -8388864;

 
  // BLUE  > color(.6503,1,1);
	static final int BLUE = -16770561;
	static final int BLEU = -16770561;
	// TURQUOISE > #25FDE9 > 0.4845679 , 0.85375494 , 0.99215686
	static final int TURQUOISE = -14287383;
	// CELESTE > #26C4EC > 0.53367 , 0.83898306 , 0.9254902
	static final int CELESTE = -14236436;
	// CIEL > #77B5FE > 0.5901235 , 0.53149605 , 0.99607843
	static final int CIEL = -8931842;
	// CAERULEUM > #357AB7 > 0.5782051 , 0.7103825 , 0.7176471
	static final int CAERULEUM = -13272393;
	// CYAN > color(0.5 1.0 1.0);
	static final int CYAN = -16711681;
	// AZUR > #007FFF > 0.5836601 , 1.0 , 1.0
	static final int AZUR = -16744449;
	// COBALT > #22427C > 0.6074074 , 0.7258065 , 0.4862745
	static final int COBALT = -14531972;
	// FRANCE > #318CE7 > 0.5833333 , 0.7878788 , 0.90588236
	static final int FRANCE = -13529881;
	// LAPIS_LAZULI > #26619C > 0.5833333 , 0.75641024 , 0.6117647
	static final int LAPIS_LAZULI = -14261860;
	// OUTREMER > #1B019B > 0.6948052 , 0.9935484 , 0.60784316
	static final int OUTREMER = -15007333;
	// NUIT > #0F056B > 0.6830065 , 0.95327103 , 0.41960785
	static final int NUIT = -15792789;
	// SMALT > #003399 > 0.6111111 , 1.0 , 0.6
	static final int SMALT = -16764007; 

	// ROSE  > color(.86,.65,1);
	static final int PINK = -42524;
	static final int ROSE = -42524;
	// MAGENTA  > color(.8333,1,1);
	static final int MAGENTA = -65281;
	// CAPUCINE > #FF5E4D > 0.0159176 , 0.69803923 , 1.0
	static final int CAPUCINE = -41395;
	// FUSCHIA > #FD3F92 > 0.927193 , 0.7509881 , 0.99215686
	static final int FUSCHIA = -180334;



	// VIOLET  > color(.7496,1,1);
	static final int VIOLET = -8453889;  
	static final int PURPLE = -8453889;
	// LAVANDE > #9683EC > 0.69682544 , 0.44491526 , 0.9254902
	static final int LAVANDE = -6913044;
	// LILAS > #B666D2 > 0.79012346 , 0.51428574 , 0.8235294
	static final int LILAS = -4823342;
	// MAUVE > #D473D4 > 0.8333333 , 0.45754716 , 0.83137256
	static final int MAUVE = -2853932;
	// MOUNTBATTEN > #997A8D > 0.89784944 , 0.20261438 , 0.6
	static final int MOUNTBATTEN = -6718835;
	// EVEQUE > #723E64 > 0.8782051 , 0.45614034 , 0.44705883
	static final int EVEQUE = -9290140;
	// ZINZOLIN > #6C0277 > 0.81766385 , 0.9831933 , 0.46666667
	static final int ZINZOLIN = -9698697;
	// PRUNE > #811453 > 0.9036697 , 0.8449612 , 0.5058824
	static final int PRUNE = -8317869;
	// AUBERGINE > #370028 > 0.8787879 , 1.0 , 0.21568628
	static final int AUBERGINE = -13172696;

}
