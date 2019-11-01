package pack01;

public class AppHelper {
	
	final static int NBR_PRIMES_NUM_TOGET = 222;
    final static int MAX_NBR_LIGNE_PAGE = 30;
    final static int MAX_NBR_COL_PAGE = 4;
	
	public static boolean isPrimeNumber(int number)
	{
		for (int i = 2; i*i <= number; i++)
			if( number%i ==0 )
				return false;
		return true;
	}
	
	public static int[] getNFirstPrimesNum(int n)
	{
		int listPrimesNum[] = new int[n+1];
		int tmpPrimeNum = 3;
		int cptLstPrimesNum = 0;
		
		listPrimesNum[cptLstPrimesNum++]= 2;
		
		while( cptLstPrimesNum <= n ) {
			if(isPrimeNumber(tmpPrimeNum))
				listPrimesNum[cptLstPrimesNum++] = tmpPrimeNum;
			// les nombres pairs ne sont pas premiers
			tmpPrimeNum += 2;
		}
		return listPrimesNum;
	}
	
	public static void affichage(int [] tab)
	{
		int  poffset, numeroPage;
        
        numeroPage = 1;
        poffset = 0;
		
        while (poffset < NBR_PRIMES_NUM_TOGET) {
            System.out.println("----------------------------------------------------");
            System.out.println("**** The First " + NBR_PRIMES_NUM_TOGET + " Prime numbers # Page " + numeroPage++);
            System.out.println("----------------------------------------------------");
            for (int roffset = poffset; roffset < poffset + MAX_NBR_LIGNE_PAGE; roffset++) {
                for (int c = 0; c < MAX_NBR_COL_PAGE; c++)
                    if (roffset + c * MAX_NBR_LIGNE_PAGE <= NBR_PRIMES_NUM_TOGET)
                        System.out.format("%10d", tab[roffset + c * MAX_NBR_LIGNE_PAGE]);
                System.out.println();
            }
            System.out.println("\n");
            poffset += (MAX_NBR_LIGNE_PAGE * MAX_NBR_COL_PAGE);
        }
	}
	
	
	public static void runApp() {
		
        int tabPrimesNum[] ;
        tabPrimesNum =getNFirstPrimesNum(NBR_PRIMES_NUM_TOGET);
        affichage(tabPrimesNum);
    }

}
