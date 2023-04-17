package modelo;
public class Dictionary {
   private String[][] words = {{"hola","caballo","cortina","hogar"},{"Hello","Horse","Table","Home"}};
   
   public String getRandomWord() {
	   int i = (int)(Math.random()*words.length);
	   return words[0][i];
   }
   public String getRandomWord(int n) {
	   int i = (int)(Math.random()*words.length);
	   return words[n-1][i];
   }
}
