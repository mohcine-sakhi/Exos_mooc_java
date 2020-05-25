class Exemple {

    /*Expliquer pourquoi ce code ne compile pas
     */
    public void m1()  {
        try {
            foo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int foo() throws Exception {
        throw new Exception();
    }

    /*Expliquer pourquoi ce code n'est pas considéré comme bon
     */
    public void m2() {
        try {
            //do stuff...
        } catch (Exception e) {

        }
    }

    /*Expliquer pourquoi ce code ne compile pas
     */
    public void m3() {
        try {
            //do stuff...
        } catch (NullPointerException e) {

        } catch (Exception e) {

        }
    }

    /*Expliquer pourquoi ce code ne compile pas
     */
    public void m4() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    private class CustomCheckedException extends Exception {

        private static final long serialVersionUID = -7944813576443065516L;

        public CustomCheckedException() {
            //nothing
        }

    }

    /*Expliquer pourquoi ce code ne compile pas
     */
    public int m5() {
        int age = 0;
        String s = "24";
        try {
            age = getAccessCode();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return age;
    }

    public int getAccessCode() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /*Expliquer pourquoi ce code COMPILE
     */
    public void m6() {
        bar();
    }

    public int bar() {
        throw new RuntimeException();
    }

}


