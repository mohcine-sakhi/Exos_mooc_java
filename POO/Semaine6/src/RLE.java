import java.util.Scanner;

class RLE {

    private static Scanner scanner = new Scanner(System.in);

    private final static char FLAG = '#';

    public static void main(String[] args) {

        System.out.println("Entrez les données à comprimer : ");
        String dta = scanner.nextLine();
        String rle = RLEAlgorithm.compress(dta, FLAG);
        System.out.println("Forme compressée:   " + rle + "\n[ratio = " + rle.length()*100.0/dta.length() + "%]");
        String dcp = "";
        try {
            dcp = RLEAlgorithm.decompresse(rle, FLAG);
        } catch (RLEException e) {
            e.printStackTrace();
        }
        if (!dcp.equals(dta)) {
            System.out.println("Erreur - données corrompues:" + dcp);
        } else {
            System.out.println("décompression ok!");
        }

        // teste la decompression
        System.out.println("Entrez les données à décompresser : ");
        dta = scanner.nextLine();
        try {
            dcp = RLEAlgorithm.decompresse(dta, FLAG);
            System.out.println("décompressé : " + dcp);
        }
        catch (RLEException exception) {
            System.out.println("Erreur de décompression : " + exception.getMessage() + "\n");
            System.out.println("décodé à ce stade : " + exception.getDecoded() + "\n");
            System.out.println("non décodé        : " + exception.getRemaining());
        }
    }
}

class RLEException extends Exception {
    // A COMPLETER
    private String decodee;
    private String nondecodee;
    public RLEException(String message, String decodee, String nondecodee){
        super(message);
        this.decodee = decodee;
        this.nondecodee = nondecodee;
    }

    public String getDecoded(){
        return decodee;
    }

    public String getRemaining(){
        return nondecodee;
    }

}



class RLEAlgorithm {

    public static String compress(String data, char flag) {
        // A COMPLETER
        String chaineCompressee = "";
        String dataCopie = data;

        while(dataCopie.length() > 0) {
            int i = 0;
            char c = dataCopie.charAt(i);

            if(c == flag) {
                chaineCompressee += flag+"0";
                ++i; // pour extraire la chaine a partir du caractere suivant
            }else {
                 i = 1;
                while(i < dataCopie.length() && i < 9 && dataCopie.charAt(i) == c) { //la plus longue sequence ne doit pas depasse 9 caracteres
                    ++i;
                }
                if(i == 1) {
                    chaineCompressee += c;
                }else if(i == 2) {
                    chaineCompressee += c+""+c;

                }else {
                    chaineCompressee += c+""+flag+""+i;

                }
            }

            if(i < dataCopie.length()) { // dans le cas ou on arrive a la fin du fichier
                dataCopie = dataCopie.substring(i, dataCopie.length());
            }else {
                dataCopie = "";
            }
        }

        return chaineCompressee;

    }

    public static String decompresse(String rledata, char flag) throws RLEException {
        // A COMPLETER
        String chaineDecompressee = "";
        String dataCopie = rledata;

        while(dataCopie.length() > 0) {
            int i = 0;
            char c = dataCopie.charAt(i);

            if(c == flag) {
                if(dataCopie.length() == 1){
                    throw new RLEException(" Flag "+ flag + " sans rien derrière", chaineDecompressee, dataCopie);
                }else if(dataCopie.charAt(i+1) == '0'){
                    chaineDecompressee += "#";
                    i += 2; // pour extraire la chaine a partir du caractere qui suit le 0
                }else{
                    throw new RLEException(" caractère "+dataCopie.charAt(i+1)+" incorrect après le flag "+flag, chaineDecompressee, dataCopie);
                }
            }else {
                if(dataCopie.length() == 1){
                    chaineDecompressee += c;
                    ++i; //pour extraire la chaine a partir du caractere suivant
                }else {
                    if(dataCopie.charAt(i+1) == flag) {
                        if(dataCopie.length() == 2){
                            throw new RLEException(" Flag "+ flag + " sans rien derrière", chaineDecompressee, dataCopie);
                        }else{
                            try {
                                int occurenceCaractere = Integer.parseInt(String.valueOf(dataCopie.charAt(i+2)));
                                for(int k = 0; k < occurenceCaractere; ++k){
                                    chaineDecompressee += c;
                                }
                                i += 3; // pour extraire la nouvelle chaine
                            }catch (Exception e){
                                throw new RLEException(" caractère "+dataCopie.charAt(i+2)+" incorrect après le flag "+flag, chaineDecompressee, dataCopie);
                            }
                        }


                    }else if(dataCopie.charAt(i+1) == c) {
                        chaineDecompressee += c+""+c;
                        i += 2; // pour extraire la nouvelle chaine

                    }else {
                        chaineDecompressee += c;
                        ++i; //pour extraire la chaine a partir du caractere suivant

                    }
                }
            }

            if(i < dataCopie.length()) { // dans le cas ou on arrive a la fin du fichier
                dataCopie = dataCopie.substring(i, dataCopie.length());
            }else {
                dataCopie = "";
            }
        }

        return chaineDecompressee;
    }
}


